package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.consts.*;
import vitily.com.mapper.mem.MemMoneyTransferMapper;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.other_entity.NoExistsException;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemMoneyTransferService;
import vitily.com.service_adapter.MemLocalAccountAdapter;
import vitily.com.tb_entity.mem.TbMemMoneyTransfer;
import vitily.com.ts_entity.mem.TsMemMoneyTransfer;
import vitily.com.tv_entity.mem.TvMemMoneyTransfer;
import vitily.com.util.CommonUtil;
import vitily.com.util.NumberUtil;

import java.util.Date;

@Component
public class MemMoneyTransferServiceImpl extends BasicServiceImpl<TbMemMoneyTransfer,TsMemMoneyTransfer,TvMemMoneyTransfer> implements MemMoneyTransferService {

	public static final Object AUDIT_LOCK_OBJ =new Object();//单机并发控制
	final MemMoneyTransferMapper memMoneyTransferMapper;
	final MemLocalAccountAdapter memLocalAccountAdapter;
	@Autowired()
	public MemMoneyTransferServiceImpl(MemMoneyTransferMapper memMoneyTransferMapper
									   ,MemLocalAccountAdapter memLocalAccountAdapter
	) {
		this.memMoneyTransferMapper = memMoneyTransferMapper;
		this.memLocalAccountAdapter = memLocalAccountAdapter;
		super.setBaseMapper(memMoneyTransferMapper);
	}
	@Override
	public int insert(TsMemMoneyTransfer bean)throws Exception{
		//先判断是否有存在3条以上的转上记录
		TsMemMoneyTransfer query = new TsMemMoneyTransfer();
		query.getEntity().setOrderNo(bean.getEntity().getOrderNo());
		int count = memMoneyTransferMapper.getCountPaging(query);
		if(count > 0){
			throw new DuplicateDataException("该订单号已存在！");
		}
		query.setEntity(new TbMemMoneyTransfer());
		query.getEntity().setMemberId(bean.getEntity().getMemberId());
		query.getEntity().setState(MoneyTransverStateDesc.未处理.getValue());
		count = memMoneyTransferMapper.getCountPaging(query);
		if(count > 3){
			throw new DuplicateDataException("您已有3条未处理数据，请等待网站工作人员审核之后再进行操作。");
		}
		Date now=new Date();
		bean.getEntity().setState(MoneyTransverStateDesc.未处理.getValue());
		bean.getEntity().setCreateDate(now);
		bean.getEntity().setDeltag(DelTagDesc.正常.getValue());
		return memMoneyTransferMapper.insertSelective(bean.getEntity());
	}
	/**
	 * 审核打款
	 * @param e
	 * @return
	 */
	@Override
	public boolean updateForAudit(TvMemMoneyTransfer e)throws Exception{
		synchronized (AUDIT_LOCK_OBJ) {
			TbMemMoneyTransfer oldRecharge = memMoneyTransferMapper.selectByPrimaryKey(e.getId());
			CommonUtil.checkIsNullEntity(oldRecharge);
			if (!CommonUtil.isEqual(DelTagDesc.正常.getValue(), oldRecharge.getDeltag())) {
				throw new NoExistsException("充值记录不存在，订单号：" + e.getOrderNo());
			}
			if (!CommonUtil.isEqual(MoneyTransverStateDesc.未处理.getValue(), oldRecharge.getState())) {
				throw new CustomerException("订单状态不正确，参考该状态：" + oldRecharge.getStateDesc(), ResultStatus.操作异常);
			}
			Date now = new Date();
			oldRecharge.setUpdateDate(now);
			oldRecharge.setState(e.getState());
			oldRecharge.setAuditAdmUserId(e.getAuditAdmUserId());
			boolean auditOk = CommonUtil.isEqual(MoneyTransverStateDesc.充值成功.getValue(), e.getState());
			if(memMoneyTransferMapper.updateByPrimaryKeySelective(oldRecharge) < 1){
				return false;
			}
			//如果审核不通过，直接更新，返回
			if(!auditOk){
				return true;
			}

			String memo = "线下打款,订单号："+oldRecharge.getOrderNo()+"金额："+ NumberUtil.respScale2MDownYuanByCent(oldRecharge.getAmount());
			memLocalAccountAdapter.availableIn(oldRecharge.getMemberId(),oldRecharge.getAmount(),FundsTypeDesc.线下打款,memo,PlatformDesc.其他.getValue(),oldRecharge.getId(),now);
		}
		return true;
	}
}
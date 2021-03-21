package vitily.com.service.finance.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.consts.*;
import vitily.com.tb_entity.finance.TbRecharge;
import vitily.com.mapper.finance.AccountFlowMapper;
import vitily.com.mapper.mem.MemLocalAccountMapper;
import vitily.com.mapper.finance.RechargeMapper;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.other_entity.NoExistsException;
import vitily.com.service.finance.RechargeService;
import vitily.com.service_adapter.MemLocalAccountAdapter;
import vitily.com.ts_entity.finance.TsRecharge;
import vitily.com.tv_entity.finance.TvRecharge;
import vitily.com.util.CommonUtil;
import vitily.com.util.NumberUtil;

import java.util.Date;

@Component
public class RechargeServiceImpl extends BasicServiceImpl<TbRecharge,TsRecharge,TvRecharge> implements RechargeService {

	final RechargeMapper rechargeMapper;
	final MemLocalAccountMapper memLocalAccountMapper;
	final MemLocalAccountAdapter memLocalAccountAdapter;
	public static final Object ORDER_LOCK_OBJ =new Object();//单机并发控制
	public static final Object AUDIT_LOCK_OBJ =new Object();//单机并发控制

	@Autowired()
	public RechargeServiceImpl(RechargeMapper rechargeMapper,
								MemLocalAccountMapper memLocalAccountMapper,
								AccountFlowMapper accountFlowMapper,
							   MemLocalAccountAdapter memLocalAccountAdapter
								  ) {
		this.rechargeMapper = rechargeMapper;
		this.memLocalAccountMapper = memLocalAccountMapper;
		this.memLocalAccountAdapter = memLocalAccountAdapter;
		super.setBaseMapper(rechargeMapper);
	}
	@Override
	public int insert(TsRecharge bean)throws Exception{
		synchronized (ORDER_LOCK_OBJ) {
			bean.getEntity().setState(RechargeStateDesc.充值中.getValue());
			//生成订单号
			bean.getEntity().setOrderNo(CommonUtil.getOrderNo(String.valueOf(bean.getEntity().getPlatform()),0,bean.getEntity().getMemberId()));
			bean.getEntity().setArrivedAmount(null);
			if(rechargeMapper.isExists(bean)){
				throw new DuplicateDataException("订单号已存在");
			}
			Date now=new Date();
			bean.getEntity().setCreateDate(now);
			bean.getEntity().setDeltag(DelTagDesc.正常.getValue());
			return rechargeMapper.insertSelective(bean.getEntity());
		}
	}
	/**
	 * 审核充值
	 * @param
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateForAudit(TbRecharge bean)throws Exception{
		synchronized (AUDIT_LOCK_OBJ) {
			TvRecharge oldRecharge = rechargeMapper.selectByOrderNoForUpdate(bean.getOrderNo());
			CommonUtil.checkIsNullEntity(oldRecharge);
			if (!CommonUtil.isEqual(DelTagDesc.正常.getValue(), oldRecharge.getDeltag())) {
				throw new NoExistsException("充值记录不存在，订单号：" + bean.getOrderNo());
			}
			if (!CommonUtil.isEqual(RechargeStateDesc.充值中.getValue(), oldRecharge.getState())) {
				throw new CustomerException("订单状态不正确，参考该状态：" + oldRecharge.getStateDesc(), ResultStatus.操作异常);
			}
			if (!CommonUtil.isEqual(bean.getMemberId(), oldRecharge.getMemberId())) {
				throw new CustomerException("该充值订单不属于你！" , ResultStatus.操作异常);
			}
			Date now = new Date();
			oldRecharge.setUpdateDate(now);
			oldRecharge.setMemo(bean.getMemo());
			oldRecharge.setState(bean.getState());
			oldRecharge.setAuditAdmUserId(bean.getAuditAdmUserId());
			boolean auditOk = CommonUtil.isEqual(RechargeStateDesc.充值成功.getValue(), bean.getState());
			if(auditOk){
				oldRecharge.setArrivedAmount(bean.getArrivedAmount());
			}
			if(rechargeMapper.updateByPrimaryKey(oldRecharge) < 1){
				return 0;
			}
			//如果审核不通过，直接更新，返回
			if(!auditOk){
				return 1;
			}

			FundsTypeDesc fundsType = CommonUtil.isEqual(oldRecharge.getMode(),RechargeModeDesc.后台充值.getValue()) ? FundsTypeDesc.后台充值 : FundsTypeDesc.充值;
			String memo = oldRecharge.getModeDesc()+"充值,订单号："+oldRecharge.getOrderNo()+"金额："+ NumberUtil.respScale2MDownYuanByCent(oldRecharge.getApplyAmount());
			memLocalAccountAdapter.availableIn(oldRecharge.getMemberId(),oldRecharge.getArrivedAmount(),fundsType,memo,oldRecharge.getPlatform(),oldRecharge.getId(),now);
		}
		return 1;
	}
	
}
package vitily.com.service.finance.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.cache.DictionaryCache;
import vitily.com.consts.*;
import vitily.com.tb_entity.finance.TbWithdraw;
import vitily.com.mapper.finance.WithdrawMapper;
import vitily.com.mapper.mem.MemLocalAccountMapper;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.other_entity.NoExistsException;
import vitily.com.service.finance.WithdrawService;
import vitily.com.service_adapter.MemLocalAccountAdapter;
import vitily.com.ts_entity.finance.TsWithdraw;
import vitily.com.tv_entity.finance.TvWithdraw;
import vitily.com.util.*;

import java.util.Date;

@Component
public class WithdrawServiceImpl extends BasicServiceImpl<TbWithdraw,TsWithdraw,TvWithdraw> implements WithdrawService {

	final WithdrawMapper withdrawMapper;
	final MemLocalAccountMapper memLocalAccountMapper;
	final MemLocalAccountAdapter memLocalAccountAdapter;
	final DictionaryCache dictionaryCache;
	public static final Object ORDER_LOCK_OBJ =new Object();//单机并发控制
	public static final Object AUDIT_LOCK_OBJ =new Object();//单机并发控制

	@Autowired()
	public WithdrawServiceImpl(WithdrawMapper withdrawMapper,
                               MemLocalAccountMapper memLocalAccountMapper,
							   DictionaryCache dictionaryCache,
							   MemLocalAccountAdapter memLocalAccountAdapter
								  ) {
		this.withdrawMapper = withdrawMapper;
		this.memLocalAccountMapper = memLocalAccountMapper;
		this.memLocalAccountAdapter = memLocalAccountAdapter;
		this.dictionaryCache = dictionaryCache;
		super.setBaseMapper(withdrawMapper);
	}
	@Override
	public int insert(TsWithdraw bean)throws Exception{
		synchronized (ORDER_LOCK_OBJ) {
			TbWithdraw entity = bean.getEntity();
			entity.setState(WithdrawStateDesc.已申请未审核.getValue());
			//生成订单号
			entity.setOrderNo( CommonUtil.getOrderNo(String.valueOf(entity.getPlatform()),0,entity.getMemberId()));
			//默认提现手续费
			if(CommonUtil.isNull(entity.getExpectedFee())){
				entity.setExpectedFee(NumberUtil.yuanToCent(Double.valueOf(dictionaryCache.getValue(DictionaryKey.Keys.默认提现手续费.getValue()))));
			}
			if(CommonUtil.isNull(entity.getApplyAmount())  || entity.getApplyAmount() <= 0){
				throw new CustomerException("提现金额必须大于0",ResultStatus.参数不全);//之后统一搞到参数校验里面
			}
			if(withdrawMapper.isExists(bean)){
				throw new DuplicateDataException("订单号已存在");
			}
			Date now=new Date();
			entity.setCreateDate(now);
			entity.setDeltag(DelTagDesc.正常.getValue());
			int res = withdrawMapper.insertSelective(entity);
			if(res < 1){
				throw new CustomerException("提现异常，请联系客服",ResultStatus.操作异常);
			}

			FundsTypeDesc fundsType;
			if(CommonUtil.isEqual(entity.getMode(),WithdrawModeDesc.线下提现.getValue())){
				fundsType = FundsTypeDesc.线下提现申请;
			}else if(CommonUtil.isEqual(entity.getMode(),WithdrawModeDesc.委托扣款.getValue())){
				fundsType = FundsTypeDesc.委托扣款;
			}else{
				fundsType = FundsTypeDesc.提现申请;
			}
			String memo = EnumHelperUtil.getEnumWrapDescByValue(WithdrawModeDesc.class,entity.getMode())
					+"提现申请,订单号["+entity.getOrderNo()
					+"],申请金额:["+NumberUtil.respScale2MDownYuanByCent(entity.getApplyAmount())+"],预计手续费:["
					+ NumberUtil.respScale2MDownYuanByCent(entity.getExpectedFee())+"]";

			memLocalAccountAdapter.availableToFreeze(entity.getMemberId(),entity.getApplyAmount(),fundsType,memo,entity.getPlatform(),entity.getId(),now);
			return res;
		}
	}
	/**
	 * 审核提现
	 * @param
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateForAudit(TbWithdraw bean)throws Exception{
		synchronized (AUDIT_LOCK_OBJ) {
			TvWithdraw oldWithdraw = withdrawMapper.selectByOrderNoForUpdate(bean.getOrderNo());
			CommonUtil.checkIsNullEntity(oldWithdraw);
			if (!CommonUtil.isEqual(DelTagDesc.正常.getValue(), oldWithdraw.getDeltag())) {
				throw new NoExistsException("充值记录不存在，订单号：" + bean.getOrderNo());
			}
			if (!CommonUtil.isEqual(WithdrawStateDesc.已申请未审核.getValue(), oldWithdraw.getState())) {
				throw new CustomerException("订单状态不正确，参考该状态：" + oldWithdraw.getStateDesc(), ResultStatus.操作异常);
			}
			if (!CommonUtil.isEqual(bean.getMemberId(), oldWithdraw.getMemberId())) {
				throw new CustomerException("该充值订单不属于你！" , ResultStatus.操作异常);
			}
			Date now = new Date();
			oldWithdraw.setUpdateDate(now);
			if(!StringUtil.isEmpty(bean.getMemo())) {
				oldWithdraw.setMemo(oldWithdraw.getMemo()+";审核人备注:"+bean.getMemo());
			}
			oldWithdraw.setState(bean.getState());
			oldWithdraw.setAuditAdmUserId(bean.getAuditAdmUserId());
			oldWithdraw.setActualFee(bean.getActualFee());
			boolean auditOk = CommonUtil.isEqual(WithdrawStateDesc.提现成功.getValue(), bean.getState());
			TsWithdraw upWithdraw = new TsWithdraw();
			upWithdraw.setEntity(oldWithdraw);
			upWithdraw.setStateStr(String.valueOf(WithdrawStateDesc.已申请未审核.getValue()));
			if(withdrawMapper.updateByIdAndState(upWithdraw) < 1){
				return 0;
			}

			FundsTypeDesc fundsType;
			String memo;
			if(auditOk){
				memo = oldWithdraw.getModeDesc()+"提现审核通过，请留意,订单号："+oldWithdraw.getOrderNo()
						+",提现金额："+NumberUtil.respScale2MDownYuanByCent(oldWithdraw.getApplyAmount())
						+",实际扣除手续费："+NumberUtil.respScale2MDownYuanByCent(oldWithdraw.getActualFee());
				fundsType = FundsTypeDesc.提现成功;
				memLocalAccountAdapter.freezeOut(bean.getMemberId(),oldWithdraw.getApplyAmount(),fundsType,memo,oldWithdraw.getPlatform(),oldWithdraw.getId(),now);
			}else{
				memo = oldWithdraw.getModeDesc()+"提现被驳回,订单号："+oldWithdraw.getOrderNo();
				fundsType = FundsTypeDesc.提现申请驳回资金返还;
				memLocalAccountAdapter.freezeToAvailable(bean.getMemberId(),oldWithdraw.getApplyAmount(),fundsType,memo,oldWithdraw.getPlatform(),oldWithdraw.getId(),now);
			}
		}
		return 1;
	}
}
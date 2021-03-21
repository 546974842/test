package vitily.com.service.pay.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import vitily.com.consts.*;
import vitily.com.mapper.finance.RechargeMapper;
import vitily.com.mapper.mem.MemBaseMapper;
import vitily.com.mapper.mem.MemLocalAccountMapper;
import vitily.com.mapper.pay.OrderDropoutMapper;
import vitily.com.mapper.pay.OrderFlowMapper;
import vitily.com.mapper.pay.PayOrderMapper;
import vitily.com.mapper.pay.PayRecordMapper;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.ResultBack;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.pay.PayOrderService;
import vitily.com.service_adapter.MemLocalAccountAdapter;
import vitily.com.tb_entity.finance.TbRecharge;
import vitily.com.tb_entity.pay.TbOrderFlow;
import vitily.com.tb_entity.pay.TbPayOrder;
import vitily.com.ts_entity.pay.TsPayOrder;
import vitily.com.tv_entity.pay.TvPayOrder;
import vitily.com.util.CommonUtil;


@Service
public class PayOrderServiceImpl extends BasicServiceImpl<TbPayOrder,TsPayOrder,TvPayOrder> implements PayOrderService {

	protected PayOrderMapper payOrderMapper;
	@Autowired
	protected OrderFlowMapper orderFlowMapper;
	@Autowired
	protected MemLocalAccountAdapter memLocalAccountAdapter;
	@Autowired
	protected PayRecordMapper payRecordMapper;
	@Autowired
	protected OrderDropoutMapper orderDropoutMapper;
	@Autowired
	protected RechargeMapper rechargeMapper;
	@Autowired
	protected MemBaseMapper memBaseMapper;
	@Autowired()
	public void setPayOrderMapper(PayOrderMapper payOrderMapper) {
		this.payOrderMapper = payOrderMapper;
		super.setBaseMapper(payOrderMapper);
	}
	
	@Override
	public long insert(TbPayOrder entity) throws Exception{
		long cal=0;
		CommonUtil.formartInsertEnntity(entity);
		cal = payOrderMapper.insert(entity);
		return cal;
	}
	/**
	 * 修改：
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void update(TbPayOrder entity) throws Exception{
		CommonUtil.formartUpdateEnntity(entity);
		payOrderMapper.updateByPrimaryKeySelective(entity);
	}
	
	/**
	 *
	 */
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.NESTED)
	public TbPayOrder createOrder(TbRecharge recharge)throws CustomerException, Exception {
		ResultBack errorResult = new ResultBack();
		TbPayOrder payOrder = new TbPayOrder();
		payOrder.setActualPayUser(null);
		payOrder.setOrderAmount(recharge.getApplyAmount());
		Date date = new Date();
		payOrder.setOrderTime(date);
		payOrder.setPaidTime(null);
		payOrder.setUserId(String.valueOf(recharge.getMemberId()));
		payOrder.setLockState(PayOrderLockEnum.Normal.getValue());
		payOrder.setPaidAmount(null);
		payOrder.setPayState(PayStateEnum.NotPay.getValue());
		payOrder.setInvoiceState(PayOrderInvoiceStateEnum.NoSend.getValue());
		payOrder.setDesc(null);
		
		payOrder.setPayment(PaymentEnum.ZFBInstant.getValue());//

		Date now = new Date();
		now.setMinutes(now.getMinutes() + 60*24*365);
		payOrder.setPayDeadline(now);
		
		payOrder.setId(0);
		
		//订单号
		payOrder.setOrderNo(recharge.getOrderNo());
		payOrder.setOther6(recharge.getMemo());
		//**************格式化完毕
		payOrderMapper.insert(payOrder);
		if(payOrder.getId() <=0){
			errorResult.setCode(ResultStatus.操作异常.getValue());
			errorResult.setContent("订单创建失败！");
			throw new CustomerException(errorResult);
		}
		//订单插入完毕
		//插入订单流水
		TbOrderFlow orderFlow = new TbOrderFlow();
		orderFlow.setOrderId(payOrder.getId());
		orderFlow.setOrderNo(payOrder.getOrderNo());
		orderFlow.setHandler("system");
		orderFlow.setDesc("用户创建订单");
		orderFlow.setContent(JSON.toJSONString(payOrder));
		orderFlow.setDealTime(date);
		orderFlowMapper.insertSelective(orderFlow);

		return payOrder;
	}
	/**
	 * 去支付的时候判断
	 * @param entity
	 * @throws CustomerException
	 * @throws Exception
	 */
	public void getToPayCheck(TbPayOrder entity)throws CustomerException,Exception{

        //如果已经超过支付时间直接报错
        ResultBack result = new ResultBack();
        if(new Date().compareTo(entity.getPayDeadline()) > 0){
        	result.setCode(ResultStatus.该信息已过时.getValue());
        	result.setContent("订单已超过支付时间.");
        	throw new CustomerException(result);
        }
        //只有订单未支付的时候才可能去支付:如果其他状态需要再支付请在后台操作
        if(!PayStateEnum.getCouldPay(entity.getPayState())){
        	result.setCode(ResultStatus.该信息已过时.getValue());
        	result.setContent("订单只有未支付/部分支付/支付失败的时候才可以进行支付.");
        	throw new CustomerException(result);
        }
	}
}
package vitily.com.tv_entity.order;

import java.util.List;

import vitily.com.consts.DeliveryStatusDesc;
import vitily.com.consts.OrderDealStatusDesc;
import vitily.com.consts.PayStateDesc;
import vitily.com.tb_entity.order.TbOrderForm;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvOrderForm extends TbOrderForm {
	private String memName;//购买该产品地会员
	private String deliveryName;//送货方式
	private String payWayName;//支付方式

	private String dealStatusDesc;
	/**
	 * 订单支付状态
	 */
	private String payStateDesc;
	/**
	 * 订单物流状态
	 */
	private String deliveryStatusDesc;
	

	private List<TvOrderDetail> orderDetails;

	public List<TvOrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<TvOrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getDealStatusDesc() {
		if(CommonUtil.isNull(dealStatusDesc)){
			this.dealStatusDesc = EnumHelperUtil.getEnumWrapDescByValue(OrderDealStatusDesc.class,this.getDealStatus());
		}
		return dealStatusDesc;
	}

	public String getPayStateDesc() {
		if(CommonUtil.isNull(payStateDesc)){
			this.payStateDesc = EnumHelperUtil.getEnumWrapDescByValue(PayStateDesc.class,this.getPayState());
		}
		return payStateDesc;
	}

	public String getDeliveryStatusDesc() {
		if(CommonUtil.isNull(deliveryStatusDesc)){
			this.deliveryStatusDesc = EnumHelperUtil.getEnumWrapDescByValue(DeliveryStatusDesc.class,this.getDeliveryStatus());
		}
		return deliveryStatusDesc;
	}

	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getPayWayName() {
		return payWayName;
	}
	public void setPayWayName(String payWayName) {
		this.payWayName = payWayName;
	}


}

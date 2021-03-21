package vitily.com.ts_entity.order;

import vitily.com.tb_entity.order.TbOrderForm;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsOrderForm extends BaseSearch<TbOrderForm> {
	public TsOrderForm(){
		super(new TbOrderForm());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//订单时间
	private String orderBeginTime;
	private String orderEndTime;
	
	//订单金额
	private Long beginAmountPay;//订单金额：起始
	private Long endAmountPay;//订单金额：结束
	
	//订单编号
	private String selOrderNo;
	//商品编号：搜详细里的
	private String selProNumber;
	
	//产品名称
	private String selProName;
	//收货人信息
	private String selReceiver;
	
	private String selPhone;
	private String selEmail;
	
	private String memberIdStr;
	
	private String dealStatusStr;
	
	
	private String payStateStr;
	private String payWayIdStr;
	private String deliveryIdStr;
	private String deliveryStatusStr;
	
	private String selCommonInfo;
	

	public String getOrderBeginTime() {
		return orderBeginTime;
	}
	public void setOrderBeginTime(String orderBeginTime) {
		this.orderBeginTime = orderBeginTime;
	}
	public String getOrderEndTime() {
		return orderEndTime;
	}
	public void setOrderEndTime(String orderEndTime) {
		this.orderEndTime = orderEndTime;
	}
	public Long getBeginAmountPay() {
		return beginAmountPay;
	}
	public void setBeginAmountPay(Long beginAmountPay) {
		this.beginAmountPay = beginAmountPay;
	}
	public Long getEndAmountPay() {
		return endAmountPay;
	}
	public void setEndAmountPay(Long endAmountPay) {
		this.endAmountPay = endAmountPay;
	}
	public String getSelOrderNo() {
		return selOrderNo;
	}
	public void setSelOrderNo(String selOrderNo) {
		this.selOrderNo = selOrderNo;
	}
	public String getSelProNumber() {
		return selProNumber;
	}
	public void setSelProNumber(String selProNumber) {
		this.selProNumber = selProNumber;
	}
	public String getSelProName() {
		return selProName;
	}
	public void setSelProName(String selProName) {
		this.selProName = selProName;
	}
	public String getSelReceiver() {
		return selReceiver;
	}
	public void setSelReceiver(String selReceiver) {
		this.selReceiver = selReceiver;
	}
	public String getSelPhone() {
		return selPhone;
	}
	public void setSelPhone(String selPhone) {
		this.selPhone = selPhone;
	}
	public String getSelEmail() {
		return selEmail;
	}
	public void setSelEmail(String selEmail) {
		this.selEmail = selEmail;
	}
	public String getMemberIdStr() {
		return memberIdStr;
	}
	public void setMemberIdStr(String memberIdStr) {
		if(CommonUtil.isNumOrD(memberIdStr)){
			this.memberIdStr = memberIdStr;
		}
	}
	public String getDealStatusStr() {
		return dealStatusStr;
	}
	public void setDealStatusStr(String dealStatusStr) {
		if(CommonUtil.isNumOrD(dealStatusStr)){
			this.dealStatusStr = dealStatusStr;
		}
	}
	public String getPayStateStr() {
		return payStateStr;
	}
	public void setPayStateStr(String payStateStr) {
		if(CommonUtil.isNumOrD(payStateStr)){
			this.payStateStr = payStateStr;
		}
	}
	public String getPayWayIdStr() {
		return payWayIdStr;
	}
	public void setPayWayIdStr(String payWayIdStr) {
		if(CommonUtil.isNumOrD(payWayIdStr)){
			this.payWayIdStr = payWayIdStr;
		}
	}
	public String getDeliveryIdStr() {
		return deliveryIdStr;
	}
	public void setDeliveryIdStr(String deliveryIdStr) {
		if(CommonUtil.isNumOrD(deliveryIdStr)){
			this.deliveryIdStr = deliveryIdStr;
		}
	}
	public String getDeliveryStatusStr() {
		return deliveryStatusStr;
	}
	public void setDeliveryStatusStr(String deliveryStatusStr) {
		if(CommonUtil.isNumOrD(deliveryStatusStr)){
			this.deliveryStatusStr = deliveryStatusStr;
		}
	}
	public String getSelCommonInfo() {
		return selCommonInfo;
	}
	public void setSelCommonInfo(String selCommonInfo) {
		this.selCommonInfo = selCommonInfo;
	}
}

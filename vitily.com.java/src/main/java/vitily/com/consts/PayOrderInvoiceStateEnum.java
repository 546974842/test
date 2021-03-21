package vitily.com.consts;

import vitily.com.util.CommonUtil;

/**
 * 订单发票送达状态
 * @author whh 2017年05月17日09:20:54
 *
 */
public enum PayOrderInvoiceStateEnum {
	NoSend(0,"未发送","gray"),
	Sending(1,"发送中","green"),
	Send(2,"已送达","green"),
	Received(3,"已签收","green"),
	Refund(4,"退回","red"),
	Exception(5,"异常","red"),
	Other(99,"其他","gray");
	private int value;
	private String desc;
	private String type;
	private String wrapDesc;
	private PayOrderInvoiceStateEnum(int value,String desc,String type){
		this.value=value;
		this.desc=desc;
		this.type=type;
	}
	public int getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}
	public String getWrapDesc() {
		this.wrapDesc = "<span style='color:"+this.type+"'>"+this.desc+"</span>";
		return wrapDesc;
	}
	public static String getWrapDescByValue(Integer v){
		for(PayOrderInvoiceStateEnum item:PayOrderInvoiceStateEnum.values()){
			if(CommonUtil.isEqual(item.getValue(), v)){
				return item.getWrapDesc();
			}
		}
		return PayOrderInvoiceStateEnum.Other.getWrapDesc();
	}
}

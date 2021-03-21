package vitily.com.consts;

import vitily.com.util.CommonUtil;

/**
 * 支付方式表（enum）
 * @author whh 2017年05月17日09:20:54
 *
 */
public enum PaymentEnum {
	WeChatQrCode(0,"微信扫码","green"),
	ZFBQrCode(1,"支付宝扫码","green"),
	ZFBInstant(2,"支付宝即时到账","green"),
	UnionNet(3,"银联网关","green"),
	UnionQrCode(4,"银联扫码","green"),
	Ofline(5,"线下支付","green");
	private int value;
	private String desc;
	private String type;
	private String wrapDesc;
	private PaymentEnum(int value,String desc,String type){
		this.value=value;
		this.desc=desc;
		this.type=type;
	}
	public static PaymentEnum getPaymentEnum(int v){
		for(PaymentEnum item:PaymentEnum.values()){
			if(CommonUtil.isEqual(item.getValue(), v)){
				return item;
			}
		}
		return PaymentEnum.Ofline;
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
		for(PaymentEnum item:PaymentEnum.values()){
			if(CommonUtil.isEqual(item.getValue(), v)){
				return item.getWrapDesc();
			}
		}
		return PaymentEnum.Ofline.getWrapDesc();
	}
}

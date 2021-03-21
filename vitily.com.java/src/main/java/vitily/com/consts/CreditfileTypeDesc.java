package vitily.com.consts;

/**
 * 信用验证类型
 */
public enum CreditfileTypeDesc {
	企业营业执照(0,"企业营业执照"),
	企业注册资本(1,"企业注册资本"),
	企业车辆信息(2,"企业车辆信息"),
	企业房产信息(3,"企业房产信息"),
	企业持有股票基金(4,"企业持有股票基金"),
	企业公司资产(5,"企业公司资产"),
	企业其他信用信息(6,"企业其他信用信息"),

	个人教育认证(7,"个人教育认证"),
	个人工作信息(8,"个人工作信息"),
	个人驾照(9,"个人驾照"),
	个人车辆信息(10,"个人车辆信息"),
	个人房产信息(11,"个人房产信息"),
	个人持有股票基金(12,"个人持有股票基金"),
	个人其他信用信息(13,"个人其他信用信息"),

	开通个人信用账户(60,"开通个人信用账户"),
	开通企业信用账户(61,"开通企业信用账户"),

	其他(99,"其他"),
	;
	private final int value;
	private final String desc;
	CreditfileTypeDesc(int value, String desc){
		this.value=value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}
}

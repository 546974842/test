package vitily.com.consts;

/**
 * 平台
 * @author lether 2016年03月19日12:05:42
 *
 */
public enum PlatformDesc {
	支付宝(0,"支付宝"),
	银行(1,"银行"),
	其他(9,"其他");
	private final int value;
	private final String desc;
	PlatformDesc(int value, String desc){
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

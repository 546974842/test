package vitily.com.consts;

/**
 * 充值模式
 * @author lether
 *
 */
public enum RechargeModeDesc {
	pc("pc","pc"),
	ios("ios","ios"),
	android("android","android"),
	wap("wap","wap"),
	后台充值("offline","后台充值[线下]"),
	其他("other","其他");
	private final String value;
	private final String desc;
	RechargeModeDesc(String value, String desc){
		this.value=value;
		this.desc=desc;
	}
	public String getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}
}

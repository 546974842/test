package vitily.com.consts;

/**
 * 提现申请模式
 * @author lether
 *
 */
public enum WithdrawModeDesc {
	pc("pc","pc"),
	ios("ios","ios"),
	android("android","android"),
	wap("wap","wap"),
	线下提现("offline","后台提现[线下]"),
	委托扣款("entrust","委托扣款[线下]"),
	其他("other","其他");
	private final String value;
	private final String desc;
	WithdrawModeDesc(String value, String desc){
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

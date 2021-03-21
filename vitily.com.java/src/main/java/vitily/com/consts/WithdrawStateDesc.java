package vitily.com.consts;

/**
 * 提现状态
 */
public enum WithdrawStateDesc {
	已申请未审核(0,"已申请未审核"),
	//通过申请未汇款(1,"通过申请未汇款"),
	提现成功(2,"提现成功"),
	驳回申请(3,"驳回申请");
	private final int value;
	private final String desc;
	WithdrawStateDesc(int value, String desc){
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

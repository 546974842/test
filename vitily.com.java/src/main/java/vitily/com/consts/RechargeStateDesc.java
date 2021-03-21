package vitily.com.consts;

/**
 * 充值状态
 */
public enum RechargeStateDesc {
	充值中(0,"充值中"),
	充值成功(1,"充值成功"),
	充值无效(2,"充值无效"),
	已超时(3,"已超时"),
	已作废(4,"已作废");
	private final int value;
	private final String desc;
	RechargeStateDesc(int value, String desc){
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

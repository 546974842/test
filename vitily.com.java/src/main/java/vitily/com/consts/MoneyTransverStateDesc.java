package vitily.com.consts;

/**
 * 打款处理状态
 */
public enum MoneyTransverStateDesc {
	未处理(0,"未处理"),
	充值成功(1,"充值成功"),
	充值无效(2,"充值无效"),
	已作废(4,"已作废");
	private final int value;
	private final String desc;
	MoneyTransverStateDesc(int value, String desc){
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

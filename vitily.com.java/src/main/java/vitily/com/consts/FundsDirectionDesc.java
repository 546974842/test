package vitily.com.consts;

/**
 * 收入/支出
 */
public enum FundsDirectionDesc {
	//income
	收入(0,"收入"),
	支出(1,"支出"),
	预授权收入(2,"预授权收入"),
	预授权支出(3,"预授权支出")
	;
	private final int value;
	private final String desc;
	FundsDirectionDesc(int value, String desc){
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

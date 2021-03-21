package vitily.com.consts;

/**
 *
 *
 */
public enum ShowExperiTypeDesc {
	线下退货(0,"线下退货"),
	无需退货(1,"产品赠送"),
	;
	private final int value;
	private final String desc;
	ShowExperiTypeDesc(int value, String desc){
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

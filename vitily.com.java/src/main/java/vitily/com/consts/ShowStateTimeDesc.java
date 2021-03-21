package vitily.com.consts;

/**
 *
 *
 */
public enum ShowStateTimeDesc {
	不限制(0,"不限制"),
	四到六分钟(1,"四到六分钟"),
	六到九分钟(2,"六到九分钟"),
	九分钟以上(3,"九分钟以上"),
	;
	private final int value;
	private final String desc;
	ShowStateTimeDesc(int value, String desc){
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

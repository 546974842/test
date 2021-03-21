package vitily.com.consts;

/**
 *
 *
 */
public enum ShowExperiWayDesc {
	关键字(0,"关键字"),
	淘口令(1,"淘口令"),
	二维码(2,"二维码"),
	;
	private final int value;
	private final String desc;
	ShowExperiWayDesc(int value, String desc){
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

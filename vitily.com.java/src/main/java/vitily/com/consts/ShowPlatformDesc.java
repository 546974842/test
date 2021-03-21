package vitily.com.consts;

/**
 *
 *
 */
public enum ShowPlatformDesc {
	手机淘宝(0,"手机淘宝"),
	手机天猫(1,"手机天猫"),
	手机京东(2,"手机京东"),
	;
	private final int value;
	private final String desc;
	ShowPlatformDesc(int value, String desc){
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

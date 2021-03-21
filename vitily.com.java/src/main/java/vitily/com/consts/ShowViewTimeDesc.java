package vitily.com.consts;

/**
 *
 *
 */
public enum ShowViewTimeDesc {
	问大家(0,"问大家"),
	初评追踪(1,"初评追踪"),
	二到三款宝贝(2,"二到三款宝贝"),
	;
	private final int value;
	private final String desc;
	ShowViewTimeDesc(int value, String desc){
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

package vitily.com.consts;

/**
 * 消息状态：各种消息可共享状态
 */
public enum MsgStateDesc {
	未读(0,"未读"),
	已读(1,"已读"),
	已过期(2,"已过期"),
	;
	private final int value;
	private final String desc;
	MsgStateDesc(int value, String desc){
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

package vitily.com.consts;


/**
 * 活动分类(0-无分类，1-鹏友会活动
 *
 */
public enum ActivityTypeDesc {
	无(0,"无"),
	普通活动(1,"普通活动"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	ActivityTypeDesc(int value, String desc){
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

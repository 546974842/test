package vitily.com.consts;

/**
 * 是否
 * @author lether
 *
 */
public enum YesOrNoDesc {
	否(0,"否"),
	是(1,"是"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	YesOrNoDesc(int value, String desc){
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

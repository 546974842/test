package vitily.com.consts;

/**
 * 证件类型
 * @author lether
 *
 */
public enum IdTypeDesc {
	身份证(0,"身份证"),
	驾照(1,"驾照"),
	护照(2,"护照"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	IdTypeDesc(int value, String desc){
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

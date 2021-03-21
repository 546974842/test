package vitily.com.consts;

/**
 * 日志状态
 * @author lether
 *
 */
public enum LogStateDesc {
	普通(0,"普通"),
	异常(1,"异常"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	LogStateDesc(int value, String desc){
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

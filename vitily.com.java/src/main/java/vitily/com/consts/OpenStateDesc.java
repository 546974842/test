package vitily.com.consts;

/**
 * 开放相关
 * @author lether
 *
 */
public enum OpenStateDesc {
	不开放(0,"不开放"),
	开放(1,"开放"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	OpenStateDesc(int value, String desc){
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

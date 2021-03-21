package vitily.com.consts;


/**
 * 是否发布
 * @author lether
 *
 */
public enum PublishedDesc {
	未发布(0,"未发布"),
	已发布(1,"已发布"),
	发布异常(2,"发布异常"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	PublishedDesc(int value, String desc){
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

package vitily.com.consts;


/**
 * 是否记录日志相关
 * @author lether
 *
 */
public enum RecordLogDesc {
	不记录(0,"不记录"),
	记录(1,"记录"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	RecordLogDesc(int value, String desc){
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

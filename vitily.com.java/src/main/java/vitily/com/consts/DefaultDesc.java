package vitily.com.consts;

/**
 * 默认相关
 * @author lether
 *
 */
public enum DefaultDesc {
	否(0,"否"),
	是(1,"是"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	DefaultDesc(int value,String desc){
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

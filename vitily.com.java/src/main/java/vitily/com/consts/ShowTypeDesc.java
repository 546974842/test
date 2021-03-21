package vitily.com.consts;

/**
 * 显示类型
 * @author lether 2016年03月19日12:05:42
 *
 */
public enum ShowTypeDesc {
	图片方式(0,"图片方式"),
	文字方式(1,"文字方式"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	ShowTypeDesc(int value, String desc){
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

package vitily.com.consts;

/**
 * 内容类型相关
 * @author lether
 *
 */
public enum HtmlTypeDesc {
	单选下拉框(0,"单选下拉框"),
	多选下拉框(1,"多选下拉"),
	单行文本框(2,"单行文本框"),
	多行文本框(3,"多行文本框"),
	单选框(4,"单选框"),
	多选框(5,"多选框"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	HtmlTypeDesc(int value, String desc){
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

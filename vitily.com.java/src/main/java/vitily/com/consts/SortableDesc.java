package vitily.com.consts;

/**
 * 排序相关
 * @author lether
 *
 */
public enum SortableDesc {
	不可排序(0,"不可排序"),
	可排序(1,"可排序"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	SortableDesc(int value, String desc){
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

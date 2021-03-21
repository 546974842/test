package vitily.com.consts;

/**
 * 性别
 * @author lether
 *
 */
public enum GenderDesc {
	先生(0,"先生"),
	女士(1,"女士"),
	隐藏(2,"隐藏"),
	不限(3,"不限"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	GenderDesc(int value, String desc){
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

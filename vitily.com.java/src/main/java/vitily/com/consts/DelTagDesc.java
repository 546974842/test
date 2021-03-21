package vitily.com.consts;

/**
 * 删除位
 * @author lether
 *
 */
public enum DelTagDesc {
	正常(0,"正常"),
	已删除(1,"已删除"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	DelTagDesc(int value, String desc){
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

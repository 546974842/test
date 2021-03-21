package vitily.com.consts;

/**
 * 备忘录状态
 */
public enum AideMemoireStateDesc {
	未处理(0,"无效"),
	已完成(1,"已完成"),
	已失效(2,"已失效"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	AideMemoireStateDesc(int value, String desc){
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

package vitily.com.consts;

public enum StateDesc {
	无效(0,"无效"),
	正常(1,"正常"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	StateDesc(int value, String desc){
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

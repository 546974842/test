package vitily.com.consts;

public enum TopDesc {
	未置顶(0,"未置顶"),
	已置顶(1,"已置顶"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	TopDesc(int value, String desc){
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

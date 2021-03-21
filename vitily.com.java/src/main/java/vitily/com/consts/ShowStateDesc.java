package vitily.com.consts;

public enum ShowStateDesc {
	未审核(0,"未审核"),
	审核通过(1,"审核通过"),
	审核失败(2,"审核失败"),
	申请取消中(3,"申请取消中"),
	已取消(4,"已取消"),
	已结束(5,"已结束"),
	;
	private final int value;
	private final String desc;
	ShowStateDesc(int value, String desc){
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

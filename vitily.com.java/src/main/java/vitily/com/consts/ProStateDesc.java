package vitily.com.consts;

/**
 * 产品状态
 */
public enum ProStateDesc {
	下架(0,"下架"),
	上架(1,"上架"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	ProStateDesc(int value, String desc){
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

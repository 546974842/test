package vitily.com.consts;

/**
 * 会员类型
 *
 */
public enum MemTypeDesc {
	个人用户(0,"个人用户"),
	企业用户(1,"企业用户"),
	;
	private final int value;
	private final String desc;
	MemTypeDesc(int value, String desc){
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

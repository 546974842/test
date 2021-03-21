package vitily.com.consts;

/**
 * 机构类型
 *
 */
public enum OrgTypeDesc {
	普通公司(0,"普通公司"),
	贵宾公司(1,"贵宾公司"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	OrgTypeDesc(int value, String desc){
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

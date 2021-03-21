package vitily.com.consts;


/**
 *
 *
 */
public enum CommonAuditStateDesc {
	未审核(0,"未审核"),
	审核通过(1,"审核通过"),
	审核不通过(2,"审核不通过"),
	;
	private final int value;
	private final String desc;
	CommonAuditStateDesc(int value, String desc){
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

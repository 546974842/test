package vitily.com.consts;

/**
 * 信用验证状态
 */
public enum CreditfileCertifyStateDesc {
	未验证(0,"未验证"),
	申请验证中(2,"申请验证中"),
	验证通过(1,"验证通过"),
	验证无效(-1,"验证无效"),
	重新申请(3,"重新申请"),
	;
	private final int value;
	private final String desc;
	CreditfileCertifyStateDesc(int value, String desc){
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

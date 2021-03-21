package vitily.com.consts;

/**
 * 银行卡状态
 */
public enum MemBankCardStateDesc {
	未认证(0,"未认证"),
	认证成功(1,"认证成功"),
	认证无效(2,"认证无效"),
	;
	private final int value;
	private final String desc;
	MemBankCardStateDesc(int value, String desc){
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

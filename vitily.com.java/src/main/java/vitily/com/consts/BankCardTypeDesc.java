package vitily.com.consts;

/**
 * 银行卡类型
 * @author lether 2016年03月19日12:05:42
 *
 */
public enum BankCardTypeDesc {
	借记卡(0,"借记卡"),
	信用卡(1,"信用卡"),
	其他(9,"其他");
	private final int value;
	private final String desc;
	BankCardTypeDesc(int value, String desc){
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

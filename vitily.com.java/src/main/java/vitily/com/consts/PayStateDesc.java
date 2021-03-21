package vitily.com.consts;

/**
 * 支付状态
 * @author lether
 *
 */
public enum PayStateDesc {
	未支付(0,"未支付"),
	已支付(1,"已支付"),
	部分支付(2,"部分支付"),
	支付无效(3,"支付无效"),
	已退款(5,"已退款"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	PayStateDesc(int value, String desc){
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

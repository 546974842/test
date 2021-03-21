package vitily.com.consts;

/**
 * 运送状态
 *
 */
public enum DeliveryStatusDesc {
	未配送(0,"未配送"),
	配送中(1,"配送中"),
	已配送待签收(2,"已配送待签收"),
	已签收(3,"配送中"),
	退货中(4,"配送中"),
	已退货(5,"配送中"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	DeliveryStatusDesc(int value, String desc){
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

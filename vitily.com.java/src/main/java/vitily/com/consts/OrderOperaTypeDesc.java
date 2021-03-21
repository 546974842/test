package vitily.com.consts;

/**
 * 订单操作类型
 * @author lether
 *
 */
public enum OrderOperaTypeDesc {
	创建订单(0,"创建订单"),
	支付订单(1,"支付订单"),
	修改订单(2,"修改订单"),
	发货(3,"发货"),
	退单(4,"退单"),
	签单(5,"签单"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	OrderOperaTypeDesc(int value, String desc){
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

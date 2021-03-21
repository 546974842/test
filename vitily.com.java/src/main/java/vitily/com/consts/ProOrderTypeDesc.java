package vitily.com.consts;


/**
 * 产品订单类型
 * @author lether
 *
 */
public enum ProOrderTypeDesc {
	普通订单(0,"普通订单"),
	团购订单(1,"团购订单"),
	抢购订单(2,"抢购订单"),
	派发订单(3,"派发订单"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	ProOrderTypeDesc(int value, String desc){
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

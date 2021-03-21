package vitily.com.consts;

/**
 * 体验秀订单状态
 * @author lether
 *
 */
public enum OrderDealShowStatusDesc {
	待提交体验报告(0,"待提交体验报告"),
	待选择体验报告(1,"待选择体验报告"),
	待评价使用报告(2,"待评价使用报告"),
	待进行线下退货(3,"待进行线下退货"),
	待确认体验结束(4,"待确认体验结束"),
	售后中(5,"售后中"),
	待审核(66,"待审核"),
	进行中(67,"进行中"),
	已完成(68,"已完成"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	OrderDealShowStatusDesc(int value, String desc){
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

package vitily.com.consts;

/**
 * 订单状态
 * @author lether
 *
 */
public enum OrderDealStatusDesc {
	未处理(0,"未处理"),//暂时不需要
	已付款(1,"已付款"),//暂时不需要
	送货中(2,"送货中"),//暂时不需要
	已送货(3,"已送货"),//暂时不需要
	已签收(4,"已签收"),//暂时不需要
	已完成(5,"已完成"),//暂时不需要
	已退货(6,"已退货"),//暂时不需要
	已作废(7,"已作废"),//模特下单后商家审核为已作废
	
	待审核(66,"待审核"),//模特下单，等待商家审核任务
	进行中(67,"进行中"),//模特下单后商家审核为进行中，进行中的模特可以进行评论，等待商家进行评论
	已结束(68,"已结束"),//商家将寄回中改为已结束，结账佣金
	寄回中(69,"寄回中"),//商家审核评论之后变为机会中或者返回进行中
	待商家审核评论(70,"待商家审核评论"),//等待商家审核评论
	;
	private final int value;
	private final String desc;
	OrderDealStatusDesc(int value, String desc){
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

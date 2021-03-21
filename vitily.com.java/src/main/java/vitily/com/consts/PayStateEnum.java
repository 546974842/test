package vitily.com.consts;

import vitily.com.util.CommonUtil;

/**
 * 支付（订单）状态表（enum）
 * @author whh 2017年05月17日09:20:44
 *
 */
public enum PayStateEnum {
	NotPay(0,"未支付","green"),
	PaidPart(1,"部分支付","green"),
	PaidAll(2,"已支付","green"),
	Refunding(3,"退款中","green"),
	RefundPart(4,"部分退款","green"),
	RefundAll(5,"已退款","green"),
	Expired(6,"已过期","green"),
	Invoid(7,"已作废","green"),
	Aberrant(8,"订单异常","green"),
	Error(9,"支付失败","green"),//支付失败：可以重新发起支付
	Completed(10,"已完成","green"),
	ApplyRefunding(11,"申请退款中","green"),
	BackApprovalRefund(12,"项目负责人同意退款,等待财务审核","green"),
	FinaceApprovalRefund(13,"财务审核批准退款","green"),
	BackRefuseRefund(14,"项目负责人拒绝退款申请","green"),
	FinaceRefuseRefund(15,"财务拒绝退款申请","green"),
	ForFree(16,"免费","green"),
	;
	//已完成：表示无法再退款申请
	private int value;
	private String desc;
	private String type;
	private String wrapDesc;
	private PayStateEnum(int value,String desc,String type){
		this.value=value;
		this.desc=desc;
		this.type=type;
	}
	public int getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}
	public String getWrapDesc() {
		this.wrapDesc = "<span style='color:"+this.type+"'>"+this.desc+"</span>";
		return wrapDesc;
	}
	/**
	 * 根据状态判断是否可以进行申请退款：
	 * 只有 部分支付/支付成功/部分退款 的订单才可以进行退款
	 * 拒绝了退款申请也不能再次申请了。
	 * @param v
	 * @return
	 */
	public static boolean getCoulRefundByState(Integer v){
		return CommonUtil.isEqual(PaidPart.getValue(),v) ||
			   CommonUtil.isEqual(RefundPart.getValue(),v) ||
			   CommonUtil.isEqual(PaidAll.getValue(),v)
			   ;
	}
	/**
	 *  判断是否可以进行订单更新：防止处理多次掉单
	 * @param v
	 * @return
	 */
	public static boolean getCouldDealPaid(Integer v){
		return  CommonUtil.isEqual(NotPay.getValue(),v) ||
				CommonUtil.isEqual(PaidPart.getValue(),v) ||
				CommonUtil.isEqual(Error.getValue(),v);
	}
	/**
	 * 是否可以前往支付
	 * @param v
	 * @return
	 */
	public static boolean getCouldPay(Integer v){
		return  CommonUtil.isEqual(NotPay.getValue(),v) ||
				CommonUtil.isEqual(PaidPart.getValue(),v) ||
				CommonUtil.isEqual(Error.getValue(),v);
	}
	public static String getWrapDescByValue(Integer v){
		for(PayStateEnum item:PayStateEnum.values()){
			if(CommonUtil.isEqual(item.getValue(), v)){
				return item.getWrapDesc();
			}
		}
		return PayStateEnum.NotPay.getWrapDesc();
	}
}

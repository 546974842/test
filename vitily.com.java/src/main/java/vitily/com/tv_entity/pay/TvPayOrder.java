package vitily.com.tv_entity.pay;

import vitily.com.consts.PayStateEnum;
import vitily.com.consts.PaymentEnum;
import vitily.com.consts.TrueFalseDesc;
import vitily.com.tb_entity.pay.TbPayOrder;

public class TvPayOrder extends TbPayOrder {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String paymentDesc;
	private String payStateDesc;
	private String lockStateDesc;
	
	public String getPaymentDesc() {
		paymentDesc = PaymentEnum.getWrapDescByValue(this.getPayment());
		return paymentDesc;
	}
	public String getPayStateDesc() {
		payStateDesc = PayStateEnum.getWrapDescByValue(this.getPayState());
		return payStateDesc;
	}
	public String getLockStateDesc() {
		lockStateDesc = TrueFalseDesc.getWrapDescByValue(this.getLockState());
		return lockStateDesc;
	}
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}

package vitily.com.ts_entity.pay;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.pay.TbPayOrder;
import vitily.com.util.CommonUtil;

import java.math.BigDecimal;

public class TsPayOrder extends BaseSearch<TbPayOrder> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String paymentStr;
	private String selPayMobile;
	private BigDecimal beginOrderAmount;
	private BigDecimal endOrderAmount;
	
	private BigDecimal beginPaidAmount;
	private BigDecimal endPaidAmount;
	
	private String payStateStr;
	private String beginOrderTime;
	private String endOrderTime;

	private String beginPaidTime;
	private String endPaidTime;
	private String selOrderNo;
	
	public TsPayOrder(){
		super(new TbPayOrder());
	}

	public String getPaymentStr() {
		return paymentStr;
	}

	public void setPaymentStr(String paymentStr) {
		if(CommonUtil.isNumOrD(paymentStr)){
			this.paymentStr = paymentStr;
		}
	}

	public String getSelPayMobile() {
		return selPayMobile;
	}

	public void setSelPayMobile(String selPayMobile) {
		this.selPayMobile = selPayMobile;
	}

	public BigDecimal getBeginOrderAmount() {
		return beginOrderAmount;
	}

	public void setBeginOrderAmount(BigDecimal beginOrderAmount) {
		this.beginOrderAmount = beginOrderAmount;
	}

	public BigDecimal getEndOrderAmount() {
		return endOrderAmount;
	}

	public void setEndOrderAmount(BigDecimal endOrderAmount) {
		this.endOrderAmount = endOrderAmount;
	}

	public BigDecimal getBeginPaidAmount() {
		return beginPaidAmount;
	}

	public void setBeginPaidAmount(BigDecimal beginPaidAmount) {
		this.beginPaidAmount = beginPaidAmount;
	}

	public BigDecimal getEndPaidAmount() {
		return endPaidAmount;
	}

	public void setEndPaidAmount(BigDecimal endPaidAmount) {
		this.endPaidAmount = endPaidAmount;
	}

	public String getPayStateStr() {
		return payStateStr;
	}

	public void setPayStateStr(String payStateStr) {
		if(CommonUtil.isNumOrD(payStateStr)){
			this.payStateStr = payStateStr;
		}
	}

	public String getBeginOrderTime() {
		return beginOrderTime;
	}

	public void setBeginOrderTime(String beginOrderTime) {
		this.beginOrderTime = beginOrderTime;
	}

	public String getEndOrderTime() {
		return endOrderTime;
	}

	public void setEndOrderTime(String endOrderTime) {
		this.endOrderTime = endOrderTime;
	}

	public String getBeginPaidTime() {
		return beginPaidTime;
	}

	public void setBeginPaidTime(String beginPaidTime) {
		this.beginPaidTime = beginPaidTime;
	}

	public String getEndPaidTime() {
		return endPaidTime;
	}

	public void setEndPaidTime(String endPaidTime) {
		this.endPaidTime = endPaidTime;
	}

	public String getSelOrderNo() {
		return selOrderNo;
	}

	public void setSelOrderNo(String selOrderNo) {
		this.selOrderNo = selOrderNo;
	}
}

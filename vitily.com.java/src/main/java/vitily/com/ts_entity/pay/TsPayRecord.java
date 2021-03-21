package vitily.com.ts_entity.pay;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.pay.TbPayRecord;
import vitily.com.util.CommonUtil;

import java.math.BigDecimal;

public class TsPayRecord extends BaseSearch<TbPayRecord> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selOrderNo;
	private String selDesc;
	private BigDecimal beginPayAmount;
	private BigDecimal endPayAmount;
	private BigDecimal beginPaidAmount;
	private BigDecimal endPaidAmount;
	private String paymentStr;
	/**
	 * 传回的支付号码
	 */
	private String selPayId;
	private String beginReceivedTime;
	private String endReceivedTime;
	
	public TsPayRecord(){
		super(new TbPayRecord());
	}

	public String getSelOrderNo() {
		return selOrderNo;
	}

	public void setSelOrderNo(String selOrderNo) {
		this.selOrderNo = selOrderNo;
	}

	public String getSelDesc() {
		return selDesc;
	}

	public void setSelDesc(String selDesc) {
		this.selDesc = selDesc;
	}

	public BigDecimal getBeginPayAmount() {
		return beginPayAmount;
	}

	public void setBeginPayAmount(BigDecimal beginPayAmount) {
		this.beginPayAmount = beginPayAmount;
	}

	public BigDecimal getEndPayAmount() {
		return endPayAmount;
	}

	public void setEndPayAmount(BigDecimal endPayAmount) {
		this.endPayAmount = endPayAmount;
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

	public String getPaymentStr() {
		return paymentStr;
	}

	public void setPaymentStr(String paymentStr) {
		if(CommonUtil.isNumOrD(paymentStr)){
			this.paymentStr = paymentStr;
		}
	}

	public String getSelPayId() {
		return selPayId;
	}

	public void setSelPayId(String selPayId) {
		this.selPayId = selPayId;
	}

	public String getBeginReceivedTime() {
		return beginReceivedTime;
	}

	public void setBeginReceivedTime(String beginReceivedTime) {
		this.beginReceivedTime = beginReceivedTime;
	}

	public String getEndReceivedTime() {
		return endReceivedTime;
	}

	public void setEndReceivedTime(String endReceivedTime) {
		this.endReceivedTime = endReceivedTime;
	}
}

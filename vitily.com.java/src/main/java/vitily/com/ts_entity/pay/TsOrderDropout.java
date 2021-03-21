package vitily.com.ts_entity.pay;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.pay.TbOrderDropout;

import java.math.BigDecimal;

public class TsOrderDropout extends BaseSearch<TbOrderDropout> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selOrderNo;
	private String selHandler;
	private BigDecimal beginDropAmount;
	private BigDecimal endDropAmount;
	
	private String beginDealTime;
	private String endDealTime;
	
	public TsOrderDropout(){
		super(new TbOrderDropout());
	}

	public String getSelOrderNo() {
		return selOrderNo;
	}

	public void setSelOrderNo(String selOrderNo) {
		this.selOrderNo = selOrderNo;
	}

	public String getSelHandler() {
		return selHandler;
	}

	public void setSelHandler(String selHandler) {
		this.selHandler = selHandler;
	}

	public BigDecimal getBeginDropAmount() {
		return beginDropAmount;
	}

	public void setBeginDropAmount(BigDecimal beginDropAmount) {
		this.beginDropAmount = beginDropAmount;
	}

	public BigDecimal getEndDropAmount() {
		return endDropAmount;
	}

	public void setEndDropAmount(BigDecimal endDropAmount) {
		this.endDropAmount = endDropAmount;
	}

	public String getBeginDealTime() {
		return beginDealTime;
	}

	public void setBeginDealTime(String beginDealTime) {
		this.beginDealTime = beginDealTime;
	}

	public String getEndDealTime() {
		return endDealTime;
	}

	public void setEndDealTime(String endDealTime) {
		this.endDealTime = endDealTime;
	}
	
}

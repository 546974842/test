package vitily.com.ts_entity.order;

import vitily.com.tb_entity.order.TbOrderPayRecord;
import vitily.base.ts_entity.BaseSearch;

public class TsOrderPayRecord extends BaseSearch<TbOrderPayRecord> {
	public TsOrderPayRecord(){
		super(new TbOrderPayRecord());
	}
	/**
	 * 
	 */
	private String selOrderNo;
	private String beginTradingDate;
	private String endTradingDate;
	private Long beginTradingAmount;
	private Long endTradingAmount;
	private static final long serialVersionUID = 1L;
	public String getSelOrderNo() {
		return selOrderNo;
	}
	public void setSelOrderNo(String selOrderNo) {
		this.selOrderNo = selOrderNo;
	}
	public String getBeginTradingDate() {
		return beginTradingDate;
	}
	public void setBeginTradingDate(String beginTradingDate) {
		this.beginTradingDate = beginTradingDate;
	}
	public String getEndTradingDate() {
		return endTradingDate;
	}
	public void setEndTradingDate(String endTradingDate) {
		this.endTradingDate = endTradingDate;
	}
	public Long getBeginTradingAmount() {
		return beginTradingAmount;
	}
	public void setBeginTradingAmount(Long beginTradingAmount) {
		this.beginTradingAmount = beginTradingAmount;
	}
	public Long getEndTradingAmount() {
		return endTradingAmount;
	}
	public void setEndTradingAmount(Long endTradingAmount) {
		this.endTradingAmount = endTradingAmount;
	}
	
}

package vitily.com.ts_entity.pay;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.pay.TbOrderFlow;

public class TsOrderFlow extends BaseSearch<TbOrderFlow> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selOrderNo;
	private String selHandler;
	private String selDesc;
	private String beginDealTime;
	private String endDealTime;
	
	public TsOrderFlow(){
		super(new TbOrderFlow());
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

	public String getSelDesc() {
		return selDesc;
	}

	public void setSelDesc(String selDesc) {
		this.selDesc = selDesc;
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

package vitily.com.ts_entity.mem;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.mem.TbMemCreditHistory;
import vitily.com.util.CommonUtil;

public class TsMemCreditHistory extends BaseSearch<TbMemCreditHistory> {
	public TsMemCreditHistory(){
		super(new TbMemCreditHistory());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer beginCreditValue;
	private Integer endCreditValue;
	private String recordTypeStr;
	private String selMemo;

	public Integer getBeginCreditValue() {
		return beginCreditValue;
	}

	public void setBeginCreditValue(Integer beginCreditValue) {
		this.beginCreditValue = beginCreditValue;
	}

	public Integer getEndCreditValue() {
		return endCreditValue;
	}

	public void setEndCreditValue(Integer endCreditValue) {
		this.endCreditValue = endCreditValue;
	}

	public String getRecordTypeStr() {
		return recordTypeStr;
	}

	public void setRecordTypeStr(String recordTypeStr) {
		if(CommonUtil.isNumOrD(recordTypeStr)) {
			this.recordTypeStr = recordTypeStr;
		}
	}

	public String getSelMemo() {
		return selMemo;
	}

	public void setSelMemo(String selMemo) {
		this.selMemo = selMemo;
	}
}

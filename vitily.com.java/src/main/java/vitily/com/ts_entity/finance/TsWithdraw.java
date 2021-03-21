package vitily.com.ts_entity.finance;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.finance.TbWithdraw;
import vitily.com.util.CommonUtil;

public class TsWithdraw extends BaseSearch<TbWithdraw> {
	public TsWithdraw(){
		super(new TbWithdraw());
	}
	private String selOrderNo;
	private Long beginAppAmount;//单位：分
	private Long endAppAmount;//单位：分
	private Long beginExpectedFee;//单位：分
	private Long endExpectedFee;//单位：分
	private Long beginActualFee;//单位：分
	private Long endActualFee;//单位：分
	private String platformStr;
	private String modeStr;

	public String getSelOrderNo() {
		return selOrderNo;
	}

	public void setSelOrderNo(String selOrderNo) {
		this.selOrderNo = selOrderNo;
	}

	public Long getBeginAppAmount() {
		return beginAppAmount;
	}

	public void setBeginAppAmount(Long beginAppAmount) {
		this.beginAppAmount = beginAppAmount;
	}

	public Long getEndAppAmount() {
		return endAppAmount;
	}

	public void setEndAppAmount(Long endAppAmount) {
		this.endAppAmount = endAppAmount;
	}

	public Long getBeginExpectedFee() {
		return beginExpectedFee;
	}

	public void setBeginExpectedFee(Long beginExpectedFee) {
		this.beginExpectedFee = beginExpectedFee;
	}

	public Long getEndExpectedFee() {
		return endExpectedFee;
	}

	public void setEndExpectedFee(Long endExpectedFee) {
		this.endExpectedFee = endExpectedFee;
	}

	public Long getBeginActualFee() {
		return beginActualFee;
	}

	public void setBeginActualFee(Long beginActualFee) {
		this.beginActualFee = beginActualFee;
	}

	public Long getEndActualFee() {
		return endActualFee;
	}

	public void setEndActualFee(Long endActualFee) {
		this.endActualFee = endActualFee;
	}

	public String getPlatformStr() {
		return platformStr;
	}

	public void setPlatformStr(String platformStr) {
		if(CommonUtil.isNumOrD(platformStr)) {
			this.platformStr = platformStr;
		}
	}

	public String getModeStr() {
		return modeStr;
	}

	public void setModeStr(String modeStr) {
		if(CommonUtil.isNormalSql(modeStr)) {
			this.modeStr = modeStr;
		}
	}
}

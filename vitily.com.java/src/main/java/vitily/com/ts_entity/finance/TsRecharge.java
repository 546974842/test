package vitily.com.ts_entity.finance;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.finance.TbRecharge;
import vitily.com.util.CommonUtil;

public class TsRecharge extends BaseSearch<TbRecharge> {
	public TsRecharge(){
		super(new TbRecharge());
	}
	private String selOrderNo;
	private String modeStr;
	private Long beginAppAmount;//单位：分
	private Long endAppAmount;//单位：分
	private Long beginArrivedAmount;//单位：分
	private Long endArrivedAmount;//单位：分
	private String platformStr;

	public String getSelOrderNo() {
		return selOrderNo;
	}

	public void setSelOrderNo(String selOrderNo) {
		this.selOrderNo = selOrderNo;
	}

	public String getModeStr() {
		return modeStr;
	}

	public void setModeStr(String modeStr) {
		if(CommonUtil.isNormalSql(modeStr)) {
			this.modeStr = modeStr;
		}
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

	public Long getBeginArrivedAmount() {
		return beginArrivedAmount;
	}

	public void setBeginArrivedAmount(Long beginArrivedAmount) {
		this.beginArrivedAmount = beginArrivedAmount;
	}

	public Long getEndArrivedAmount() {
		return endArrivedAmount;
	}

	public void setEndArrivedAmount(Long endArrivedAmount) {
		this.endArrivedAmount = endArrivedAmount;
	}

	public String getPlatformStr() {
		return platformStr;
	}

	public void setPlatformStr(String platformStr) {
		if(CommonUtil.isNumOrD(platformStr)) {
			this.platformStr = platformStr;
		}
	}
}

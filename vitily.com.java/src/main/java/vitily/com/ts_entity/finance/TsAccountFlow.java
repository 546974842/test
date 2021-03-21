package vitily.com.ts_entity.finance;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.finance.TbAccountFlow;
import vitily.com.util.CommonUtil;

public class TsAccountFlow extends BaseSearch<TbAccountFlow> {
	/**
	* @Fields {todo}
	*/
	private static final long serialVersionUID = 1L;

	public TsAccountFlow(){
		super(new TbAccountFlow());
	}
	private Long beginAmount;//单位：分
	private Long endAmount;//单位：分
	private Long beginAvailableBalance;//单位：分
	private Long endAvailableBalance;//单位：分
	private Long beginFreezeBalance;//单位：分
	private Long endFreezeBalance;//单位：分
	private String selRemark;
	private String fundsTypeStr;
	private String platformStr;

	public Long getBeginAmount() {
		return beginAmount;
	}

	public void setBeginAmount(Long beginAmount) {
		this.beginAmount = beginAmount;
	}

	public Long getEndAmount() {
		return endAmount;
	}

	public void setEndAmount(Long endAmount) {
		this.endAmount = endAmount;
	}

	public Long getBeginAvailableBalance() {
		return beginAvailableBalance;
	}

	public void setBeginAvailableBalance(Long beginAvailableBalance) {
		this.beginAvailableBalance = beginAvailableBalance;
	}

	public Long getEndAvailableBalance() {
		return endAvailableBalance;
	}

	public void setEndAvailableBalance(Long endAvailableBalance) {
		this.endAvailableBalance = endAvailableBalance;
	}

	public Long getBeginFreezeBalance() {
		return beginFreezeBalance;
	}

	public void setBeginFreezeBalance(Long beginFreezeBalance) {
		this.beginFreezeBalance = beginFreezeBalance;
	}

	public Long getEndFreezeBalance() {
		return endFreezeBalance;
	}

	public void setEndFreezeBalance(Long endFreezeBalance) {
		this.endFreezeBalance = endFreezeBalance;
	}

	public String getSelRemark() {
		return selRemark;
	}

	public void setSelRemark(String selRemark) {
		this.selRemark = selRemark;
	}

	public String getFundsTypeStr() {
		return fundsTypeStr;
	}

	public void setFundsTypeStr(String fundsTypeStr) {
		if(CommonUtil.isNumOrD(fundsTypeStr)) {
			this.fundsTypeStr = fundsTypeStr;
		}
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

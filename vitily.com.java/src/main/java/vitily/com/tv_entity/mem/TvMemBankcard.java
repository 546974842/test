package vitily.com.tv_entity.mem;

import vitily.com.consts.BankCardTypeDesc;
import vitily.com.consts.MemBankCardStateDesc;
import vitily.com.tb_entity.mem.TbMemBankcard;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvMemBankcard extends TbMemBankcard {
	private String memName;
	private String memRealName;//真实姓名or公司名称
	private Integer type;
	private String bankName;
	private String cardTypeDesc;

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemRealName() {
		return memRealName;
	}

	public void setMemRealName(String memRealName) {
		this.memRealName = memRealName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCardTypeDesc() {
		if(CommonUtil.isNull(cardTypeDesc)){
			this.cardTypeDesc = EnumHelperUtil.getEnumWrapDescByValue(BankCardTypeDesc.class,this.getType());
		}
		return cardTypeDesc;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override
	public String getStateDesc(){
		String stateDesc = EnumHelperUtil.getEnumWrapDescByValue(MemBankCardStateDesc.class, this.getState());
		return stateDesc;
	}
}

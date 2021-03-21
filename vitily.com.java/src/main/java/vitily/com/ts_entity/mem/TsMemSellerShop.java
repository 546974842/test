package vitily.com.ts_entity.mem;

import vitily.com.tb_entity.mem.TbMemSellerShop;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsMemSellerShop extends BaseSearch<TbMemSellerShop> {
	public TsMemSellerShop(){
		super(new TbMemSellerShop());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selReceiver;
	private String selAddress;
	private String selPhoneCall;
	private String defaultStr;
	private Integer memberId;

	public String getSelReceiver() {
		return selReceiver;
	}

	
	public Integer getMemberId() {
		return memberId;
	}


	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}


	public void setSelReceiver(String selReceiver) {
		this.selReceiver = selReceiver;
	}

	public String getSelAddress() {
		return selAddress;
	}

	public void setSelAddress(String selAddress) {
		this.selAddress = selAddress;
	}

	public String getSelPhoneCall() {
		return selPhoneCall;
	}

	public void setSelPhoneCall(String selPhoneCall) {
		this.selPhoneCall = selPhoneCall;
	}

	public String getDefaultStr() {
		return defaultStr;
	}

	public void setDefaultStr(String defaultStr) {
		if(CommonUtil.isNumOrD(defaultStr)) {
			this.defaultStr = defaultStr;
		}
	}
}

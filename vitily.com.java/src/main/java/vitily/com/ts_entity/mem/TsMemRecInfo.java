package vitily.com.ts_entity.mem;

import vitily.com.tb_entity.mem.TbMemRecInfo;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsMemRecInfo extends BaseSearch<TbMemRecInfo> {
	public TsMemRecInfo(){
		super(new TbMemRecInfo());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selReceiver;
	private String selAddress;
	private String selPhoneCall;
	private String defaultStr;

	public String getSelReceiver() {
		return selReceiver;
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

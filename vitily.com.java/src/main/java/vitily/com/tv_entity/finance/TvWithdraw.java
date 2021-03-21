package vitily.com.tv_entity.finance;

import vitily.com.consts.*;
import vitily.com.tb_entity.finance.TbWithdraw;
import vitily.com.tv_entity.mem.TvMemBankcard;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvWithdraw extends TbWithdraw {
	private String memName;
	private String memRealName;//真实姓名or公司名称
	private String modeDesc;
	private String platformDesc;
	private String applyAdmUserName;
	private String auditAdmUserName;

	TvMemBankcard memBankcard;

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

	@Override
	public String getStateDesc(){
		return EnumHelperUtil.getEnumWrapDescByValue(WithdrawStateDesc.class, this.getState());
	}
	public String getModeDesc() {
		if(CommonUtil.isNull(modeDesc)){
			this.modeDesc = EnumHelperUtil.getEnumWrapDescByValue(WithdrawModeDesc.class,this.getMode());
		}
		return modeDesc;
	}

	public String getPlatformDesc() {
		if(CommonUtil.isNull(platformDesc)){
			this.platformDesc = EnumHelperUtil.getEnumWrapDescByValue(PlatformDesc.class,this.getPlatform());
		}
		return platformDesc;
	}

	public String getApplyAdmUserName() {
		return applyAdmUserName;
	}

	public void setApplyAdmUserName(String applyAdmUserName) {
		this.applyAdmUserName = applyAdmUserName;
	}

	public String getAuditAdmUserName() {
		return auditAdmUserName;
	}

	public void setAuditAdmUserName(String auditAdmUserName) {
		this.auditAdmUserName = auditAdmUserName;
	}
	public TvMemBankcard getMemBankcard() {
		return memBankcard;
	}
	public void setMemBankcard(TvMemBankcard memBankcard) {
		this.memBankcard = memBankcard;
	}
}

package vitily.com.tv_entity.finance;

import vitily.com.consts.PlatformDesc;
import vitily.com.consts.RechargeModeDesc;
import vitily.com.consts.RechargeStateDesc;
import vitily.com.tb_entity.finance.TbRecharge;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvRecharge extends TbRecharge {
	private String memName;
	private String memRealName;//真实姓名or公司名称
	private String modeDesc;
	private String platformDesc;
	private String applyAdmUserName;
	private String auditAdmUserName;

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
		String stateDesc = EnumHelperUtil.getEnumWrapDescByValue(RechargeStateDesc.class, this.getState());
		return stateDesc;
	}
	public String getModeDesc() {
		if(CommonUtil.isNull(modeDesc)){
			this.modeDesc = EnumHelperUtil.getEnumWrapDescByValue(RechargeModeDesc.class,this.getMode());
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
}

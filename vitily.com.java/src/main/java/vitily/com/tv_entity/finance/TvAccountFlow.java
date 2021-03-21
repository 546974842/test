package vitily.com.tv_entity.finance;

import vitily.com.consts.FundsDirectionDesc;
import vitily.com.consts.FundsTypeDesc;
import vitily.com.consts.PlatformDesc;
import vitily.com.tb_entity.finance.TbAccountFlow;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvAccountFlow extends TbAccountFlow {
	/**
	* @Fields {todo}
	*/
	private static final long serialVersionUID = 1L;
	private String fundsTypeDesc;
	private String platformDesc;
	private String memName;
	private String memRealName;//真实姓名or公司名称
	private String directionDesc;
	public String getFundsTypeDesc() {
		if(CommonUtil.isNull(fundsTypeDesc)){
			this.fundsTypeDesc = EnumHelperUtil.getEnumWrapDescByValue(FundsTypeDesc.class,this.getFundsType());
		}
		return fundsTypeDesc;
	}

	public String getPlatformDesc() {
		if(CommonUtil.isNull(platformDesc)){
			this.platformDesc = EnumHelperUtil.getEnumWrapDescByValue(PlatformDesc.class,this.getPlatform());
		}
		return platformDesc;
	}

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

	public String getDirectionDesc() {
		if(CommonUtil.isNull(directionDesc)){
			this.directionDesc = EnumHelperUtil.getEnumWrapDescByValue(FundsDirectionDesc.class,this.getDirection());
		}
		return directionDesc;
	}
}

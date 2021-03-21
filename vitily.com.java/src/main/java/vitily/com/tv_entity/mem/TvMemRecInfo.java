package vitily.com.tv_entity.mem;

import vitily.com.consts.DefaultDesc;
import vitily.com.tb_entity.mem.TbMemRecInfo;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvMemRecInfo extends TbMemRecInfo {
	private String memName;
	private String memRealName;//真实姓名or公司名称
	private String defaultDesc;

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

	public String getDefaultDesc() {
		if(CommonUtil.isNull(defaultDesc)){
			this.defaultDesc = EnumHelperUtil.getEnumWrapDescByValue(DefaultDesc.class,this.getIsDefault());
		}
		return defaultDesc;
	}
}

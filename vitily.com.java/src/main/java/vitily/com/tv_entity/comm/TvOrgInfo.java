package vitily.com.tv_entity.comm;

import vitily.com.consts.OrgTypeDesc;
import vitily.com.tb_entity.comm.TbOrgInfo;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvOrgInfo extends TbOrgInfo {
	private String typeName;

	public String getTypeName() {
		if(CommonUtil.isNull(typeName)){
			this.typeName = EnumHelperUtil.getEnumWrapDescByValue(OrgTypeDesc.class,this.getType());
		}
		return typeName;
	}

}

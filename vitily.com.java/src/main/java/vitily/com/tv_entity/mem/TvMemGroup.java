package vitily.com.tv_entity.mem;

import vitily.com.consts.DefaultDesc;
import vitily.com.tb_entity.mem.TbMemGroup;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvMemGroup extends TbMemGroup {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 默认状态
	 */
	private String defaultDesc;
	public String getDefaultDesc() {
		if(CommonUtil.isNull(defaultDesc)){
			this.defaultDesc = EnumHelperUtil.getEnumWrapDescByValue(DefaultDesc.class,this.getIsDefault());
		}
		return defaultDesc;
	}


}

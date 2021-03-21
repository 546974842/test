package vitily.com.ts_entity.show;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.show.TbShowBase;
import vitily.com.util.CommonUtil;

public class TsShowBase extends BaseSearch<TbShowBase> {
	public TsShowBase(){
		super(new TbShowBase());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cateIds;

	public String getCateIds() {
		return cateIds;
	}

	public void setCateIds(String cateIds) {
		if(CommonUtil.isNumOrD(cateIds)){
			this.cateIds = cateIds;
		}
	}
}

package vitily.com.ts_entity.pro;

import vitily.com.tb_entity.pro.TbProMemPri;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsProMemPri extends BaseSearch<TbProMemPri> {
	public TsProMemPri(){
		super(new TbProMemPri());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 规格参数组合Id 组
	 */
	private String specParProIds;
	public String getSpecParProIds() {
		return specParProIds;
	}
	public void setSpecParProIds(String specParProIds) {
		if(CommonUtil.isNumOrD(specParProIds)){
			this.specParProIds = specParProIds;
		}
	}
	
}

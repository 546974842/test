package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbAdvertise;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsAdvertise extends BaseSearch<TbAdvertise> {
	public TsAdvertise(){
		super(new TbAdvertise());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 类型idstr：如(1,2,...x)
	 */
	private String typeIdStr;
	
	/**
	 * 标题模糊搜索
	 */
	private String selTitle;

	public String getTypeIdStr() {
		return typeIdStr;
	}

	public void setTypeIdStr(String typeIdStr) {
		if(CommonUtil.isNumOrD(typeIdStr)){
			this.typeIdStr = typeIdStr;
		}
	}

	public String getSelTitle() {
		return selTitle;
	}

	public void setSelTitle(String selTitle) {
		this.selTitle = selTitle;
	}
}

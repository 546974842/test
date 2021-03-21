package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbCateVirtual;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsCateVirtual extends BaseSearch<TbCateVirtual> {
	public TsCateVirtual(){
		super(new TbCateVirtual());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * name 模糊搜索
	 */
	private String selName;
	
	/**
	 * 类型idstr：如(1,2,...x)
	 */
	private String typeIdStr;

	public String getSelName() {
		return selName;
	}

	public void setSelName(String selName) {
		this.selName = selName;
	}

	public String getTypeIdStr() {
		return typeIdStr;
	}

	public void setTypeIdStr(String typeIdStr) {
		if(CommonUtil.isNumOrD(typeIdStr)){
			this.typeIdStr = typeIdStr;
		}
	}
}

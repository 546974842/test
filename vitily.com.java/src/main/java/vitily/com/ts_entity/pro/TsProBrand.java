package vitily.com.ts_entity.pro;

import vitily.com.tb_entity.pro.TbProBrand;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsProBrand extends BaseSearch<TbProBrand> {
	public TsProBrand(){
		super(new TbProBrand());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String typeIdStr;
	private String cateIdStr;
	private String selName;
	public String getTypeIdStr() {
		return typeIdStr;
	}
	public void setTypeIdStr(String typeIdStr) {
		if(CommonUtil.isNumOrD(typeIdStr)){
			this.typeIdStr = typeIdStr;
		}
	}
	public String getCateIdStr() {
		return cateIdStr;
	}
	public void setCateIdStr(String cateIdStr) {
		if(CommonUtil.isNumOrD(cateIdStr)){
			this.cateIdStr = cateIdStr;
		}
	}
	public String getSelName() {
		return selName;
	}
	public void setSelName(String selName) {
		this.selName = selName;
	}
}

package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbCategory;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsCategory extends BaseSearch<TbCategory> {
	public TsCategory(){
		super(new TbCategory());
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
	
	/**
	 * 系统类型
	 */
	private String sysTypeStr;
	/**
	 * 标识符
	 */
	private String selUrlTip;
	
	public String getSelUrlTip() {
		return selUrlTip;
	}

	public void setSelUrlTip(String selUrlTip) {
		this.selUrlTip = selUrlTip;
	}

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

	public String getSysTypeStr() {
		return sysTypeStr;
	}

	public void setSysTypeStr(String sysTypeStr) {
		if(CommonUtil.isNumOrD(sysTypeStr)){
			this.sysTypeStr = sysTypeStr;
		}
	}
}

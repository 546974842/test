package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbDynProper;
import vitily.com.tb_entity.comm.TbType;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

import java.util.List;

public class TsType extends BaseSearch<TbType> {
	public TsType(){
		super(new TbType());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 类型名称模糊搜索
	 */
	private String selName;
	
	/**
	 * 系统:如1,2...x
	 */
	private String sysTypeStr;

	/**
	 * 标识符
	 */
	private String selUrlTip;
	/**
	 * 额外属性
	 */
	private List<TbDynProper> dyns;

	private String delDynIds;
	
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

	public String getSysTypeStr() {
		return sysTypeStr;
	}

	public void setSysTypeStr(String sysTypeStr) {
		if(CommonUtil.isNumOrD(sysTypeStr)){
			this.sysTypeStr = sysTypeStr;
		}
	}

	public List <TbDynProper> getDyns() {
		return dyns;
	}

	public void setDyns(List <TbDynProper> dyns) {
		this.dyns = dyns;
	}

	public String getDelDynIds() {
		return delDynIds;
	}

	public void setDelDynIds(String delDynIds) {
		this.delDynIds = delDynIds;
	}
}

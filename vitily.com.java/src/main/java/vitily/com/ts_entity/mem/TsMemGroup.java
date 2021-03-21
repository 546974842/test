package vitily.com.ts_entity.mem;

import vitily.com.tb_entity.mem.TbMemGroup;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;


public class TsMemGroup extends BaseSearch<TbMemGroup> {
	public TsMemGroup(){super(new TbMemGroup());}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String defaultStr;
	private Double beginPercent;
	private Double endPercent;
	private String selName;

	public String getDefaultStr() {
		return defaultStr;
	}
	public void setDefaultStr(String defaultStr) {
		if(CommonUtil.isNumOrD(defaultStr)){
			this.defaultStr = defaultStr;
		}
	}
	public Double getBeginPercent() {
		return beginPercent;
	}
	public void setBeginPercent(Double beginPercent) {
		this.beginPercent = beginPercent;
	}
	public Double getEndPercent() {
		return endPercent;
	}
	public void setEndPercent(Double endPercent) {
		this.endPercent = endPercent;
	}
	public String getSelName() {
		return selName;
	}
	public void setSelName(String selName) {
		this.selName = selName;
	}
}

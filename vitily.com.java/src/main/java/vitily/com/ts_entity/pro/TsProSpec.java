package vitily.com.ts_entity.pro;

import vitily.com.tb_entity.pro.TbProSpAttr;
import vitily.com.tb_entity.pro.TbProSpec;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

import java.util.List;

public class TsProSpec extends BaseSearch<TbProSpec> {
	public TsProSpec(){
		super(new TbProSpec());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selName;
	private String showTypeStr;
	private List<TbProSpAttr> pars;
	private String delParIds;

	public String getSelName() {
		return selName;
	}

	public void setSelName(String selName) {
		this.selName = selName;
	}

	
	public String getShowTypeStr() {
		return showTypeStr;
	}

	public void setShowTypeStr(String showTypeStr) {
		if(CommonUtil.isNumOrD(showTypeStr)){
			this.showTypeStr = showTypeStr;
		}
	}

	public List <TbProSpAttr> getPars() {
		return pars;
	}

	public void setPars(List <TbProSpAttr> pars) {
		this.pars = pars;
	}

	public String getDelParIds() {
		return delParIds;
	}

	public void setDelParIds(String delParIds) {
		this.delParIds = delParIds;
	}
}

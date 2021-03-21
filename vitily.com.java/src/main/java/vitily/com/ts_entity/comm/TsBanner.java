package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbBanner;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsBanner extends BaseSearch<TbBanner> {
	public TsBanner(){
		super(new TbBanner());
	}
	
	private String selTitle;
	/**
	 * 页面类型
	 */
	private String pageTypeStr;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getPageTypeStr() {
		return pageTypeStr;
	}
	public void setPageTypeStr(String pageTypeStr) {
		if(CommonUtil.isNumOrD(pageTypeStr)){
			this.pageTypeStr = pageTypeStr;
		}
	}
	public String getSelTitle() {
		return selTitle;
	}
	public void setSelTitle(String selTitle) {
		this.selTitle = selTitle;
	}
}

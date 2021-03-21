package vitily.com.tv_entity.comm;


import vitily.com.consts.BannerPageDesc;
import vitily.com.tb_entity.comm.TbBanner;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvBanner extends TbBanner {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String pageTypeName;

	public String getPageTypeName() {
		if(CommonUtil.isNull(pageTypeName)) {
			pageTypeName = EnumHelperUtil.getEnumWrapDescByValue(BannerPageDesc.class,this.getPageType());
		}
		return pageTypeName;
	}
}

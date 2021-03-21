package vitily.com.tv_entity.comm;

import vitily.com.consts.FeedbackStateDesc;
import vitily.com.tb_entity.comm.TbSuggestion;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvSuggestion extends TbSuggestion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	 /**
     * 查看状态
     */
	private String viewStateDesc;

	public String getViewStateDesc() {
      if(CommonUtil.isNull(viewStateDesc)){
			this.viewStateDesc = EnumHelperUtil.getEnumWrapDescByValue(FeedbackStateDesc.class,this.getViewState());
		}
      
	  return viewStateDesc;
	}

}

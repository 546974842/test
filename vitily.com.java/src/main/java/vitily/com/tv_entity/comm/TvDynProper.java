package vitily.com.tv_entity.comm;


import vitily.com.consts.HtmlTypeDesc;
import vitily.com.tb_entity.comm.TbDynProper;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvDynProper extends TbDynProper {
	/**
	 * 系统类型
	 */
	private String htmlTypeDesc;
	
	/**
	 * 类型名称
	 */
	private String typeName;

	public String getHtmlTypeDesc(){
		if(CommonUtil.isNull(htmlTypeDesc)){
			this.htmlTypeDesc = EnumHelperUtil.getEnumWrapDescByValue(HtmlTypeDesc.class,this.getHtmlType());
		}
		return htmlTypeDesc;
	}


	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


}

package vitily.com.tv_entity.pro;

import vitily.com.tb_entity.pro.TbProBrand;

public class TvProBrand extends TbProBrand {
	/**
	 * 所属类型名称
	 */
	private String typeName;
	/**
	 * 所属分类名称
	 */
	private String cateName;
	
	@SuppressWarnings("unused")
	private String picSrcShow;
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	

	public String getPicSrcShow() {
		return this.picSrcShow ;
	}

	public void setPicSrcShow(String picSrcShow) {
		this.picSrcShow = "<img src='"+getPicSrc()+"' />";
	}


}

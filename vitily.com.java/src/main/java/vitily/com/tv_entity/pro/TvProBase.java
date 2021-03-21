package vitily.com.tv_entity.pro;

import vitily.com.tb_entity.pro.TbProBase;

public class TvProBase extends TbProBase {
	private String cateName;
	private String typeName;
	private String newsTitle;
	private String brandName;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


}

package vitily.com.tv_entity.pro;

import java.util.List;

import vitily.com.tb_entity.pro.TbProSpVal;

public class TvProSpVal extends TbProSpVal {
	private String productName;
	private String newsTitle;
	private String typeName;
	private String cateName;
	
	private List<TvProMemPri> pmps;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

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
	

	public List<TvProMemPri> getPmps() {
		return pmps;
	}

	public void setPmps(List<TvProMemPri> pmps) {
		this.pmps = pmps;
	}


}

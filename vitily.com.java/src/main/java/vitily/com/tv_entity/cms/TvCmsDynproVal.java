package vitily.com.tv_entity.cms;


import vitily.com.tb_entity.cms.TbCmsDynproVal;

public class TvCmsDynproVal extends TbCmsDynproVal {
	/**
	 * 属性名称
	 */
	private String proName;
	/**
	 * 属性名
	 */
	private String proValue;
	/**
	 * 类型名称
	 */
	private Integer htmlType;
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProValue() {
		return proValue;
	}
	public void setProValue(String proValue) {
		this.proValue = proValue;
	}
	public Integer getHtmlType() {
		return htmlType;
	}
	public void setHtmlType(Integer htmlType) {
		this.htmlType = htmlType;
	}

}

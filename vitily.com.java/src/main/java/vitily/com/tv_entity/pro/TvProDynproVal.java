package vitily.com.tv_entity.pro;


import vitily.com.tb_entity.pro.TbProDynproVal;

public class TvProDynproVal extends TbProDynproVal {
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

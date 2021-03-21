package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbOrgInfo;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsOrgInfo extends BaseSearch<TbOrgInfo> {
	public TsOrgInfo(){
		super(new TbOrgInfo());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 机构名称、简称
	 */
	private String selName;
	
	/**
	 * 网址
	 */
	private String selNetUrl;
	
	/**
	 * 类型idstr：如(1,2,...x)
	 */
	private String orgTypeStr;
	
	/**
	 * 联系方式等
	 */
	private String selServicePhone;

	public String getSelName() {
		return selName;
	}

	public void setSelName(String selName) {
		this.selName = selName;
	}

	public String getSelNetUrl() {
		return selNetUrl;
	}

	public void setSelNetUrl(String selNetUrl) {
		this.selNetUrl = selNetUrl;
	}
	
	public String getOrgTypeStr() {
		return orgTypeStr;
	}

	public void setOrgTypeStr(String orgTypeStr) {
		if(CommonUtil.isNumOrD(orgTypeStr)){
			this.orgTypeStr = orgTypeStr;
		}
	}

	public String getSelServicePhone() {
		return selServicePhone;
	}

	public void setSelServicePhone(String selServicePhone) {
		this.selServicePhone = selServicePhone;
	}
}

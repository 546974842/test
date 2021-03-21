package vitily.com.ts_entity.mem;

import vitily.com.tb_entity.mem.TbMemBase;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.mem.TbMemCompanyUserinfo;
import vitily.com.tb_entity.mem.TbMemPersonalUserinfo;
import vitily.com.util.CommonUtil;


public class TsMemBase extends BaseSearch<TbMemBase> {
	public TsMemBase(){
		super(new TbMemBase());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selName;
	private Integer parentId;
	private String email;
	private String qq;
	private String beginLastLoginDate;
	private String endLastLoginDate;
	
	private String typeStr;
	private String groupIdStr;
	private String regFromStr;

	private Boolean selOpenCretidfile;

	private TbMemPersonalUserinfo personalUserinfo;
	private TbMemCompanyUserinfo companyUserinfo;

	
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getSelName() {
		return selName;
	}
	public void setSelName(String selName) {
		this.selName = selName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getTypeStr() {
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		if(CommonUtil.isNumOrD(typeStr)){
			this.typeStr = typeStr;
		}
	}

	public String getGroupIdStr() {
		return groupIdStr;
	}
	public void setGroupIdStr(String groupIdStr) {
		if(CommonUtil.isNumOrD(groupIdStr)){
			this.groupIdStr = groupIdStr;
		}
	}

	public String getRegFromStr() {
		return regFromStr;
	}
	public void setRegFromStr(String regFromStr) {
		if(CommonUtil.isNumOrD(regFromStr)){
			this.regFromStr = regFromStr;
		}
	}

	public String getBeginLastLoginDate() {
		return beginLastLoginDate;
	}
	public void setBeginLastLoginDate(String beginLastLoginDate) {
		this.beginLastLoginDate = beginLastLoginDate;
	}
	public String getEndLastLoginDate() {
		return endLastLoginDate;
	}
	public void setEndLastLoginDate(String endLastLoginDate) {
		this.endLastLoginDate = endLastLoginDate;
	}

	public Boolean getSelOpenCretidfile() {
		return selOpenCretidfile;
	}

	public void setSelOpenCretidfile(Boolean selOpenCretidfile) {
		this.selOpenCretidfile = selOpenCretidfile;
	}

	public TbMemPersonalUserinfo getPersonalUserinfo() {
		return personalUserinfo;
	}

	public void setPersonalUserinfo(TbMemPersonalUserinfo personalUserinfo) {
		this.personalUserinfo = personalUserinfo;
	}

	public TbMemCompanyUserinfo getCompanyUserinfo() {
		return companyUserinfo;
	}

	public void setCompanyUserinfo(TbMemCompanyUserinfo companyUserinfo) {
		this.companyUserinfo = companyUserinfo;
	}
}

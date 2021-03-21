package vitily.com.tv_entity.mem;

import vitily.com.consts.MemCateDesc;
import vitily.com.consts.MemTypeDesc;
import vitily.com.consts.RegFromDesc;
import vitily.com.tb_entity.mem.*;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;


public class TvMemBase extends TbMemBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String groupName;
	private String typeDesc;
	private String cateDesc;
	/**
	 * 来源显示名称
	 */
	private String regFromName;
	private TbMemLocalAccount localAccount;
	private TbMemPersonalUserinfo personalUserinfo;
	private TbMemCompanyUserinfo companyUserinfo;
	private Integer personalCreditPoints;
	private Integer companyCreditPoints;
	private Integer parentId;
	private Integer cate;
	private String memRealName;//真实姓名or公司名称
	private TbMemSeller sellerInfo;
	private TbMemModelInfo modelInfo;
	private TbMemArtist artistInfo;
	private TbMemPersonalCertifyinfo memPersonalCertifyinfo;
	public String getGroupName() {
		return groupName;
	}

	
	
	public Integer getCate() {
		return cate;
	}



	public void setCate(Integer cate) {
		this.cate = cate;
	}



	public Integer getParentId() {
		return parentId;
	}


	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getRegFromName() {
		if(CommonUtil.isNull(regFromName)){
			this.regFromName = EnumHelperUtil.getEnumWrapDescByValue(RegFromDesc.class,this.getRegFrom());
		}
		return regFromName;
	}

	public TbMemLocalAccount getLocalAccount() {
		return localAccount;
	}

	public void setLocalAccount(TbMemLocalAccount localAccount) {
		this.localAccount = localAccount;
	}

	public String getTypeDesc() {
		if(CommonUtil.isNull(typeDesc)){
			typeDesc = EnumHelperUtil.getEnumWrapDescByValue(MemTypeDesc.class,this.getType());
		}
		return typeDesc;
	}
	public String getCateDesc() {
		if(CommonUtil.isNull(cateDesc)){
			cateDesc = EnumHelperUtil.getEnumWrapDescByValue(MemCateDesc.class,this.getCate());
		}
		return cateDesc;
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

	public Integer getPersonalCreditPoints() {
		return personalCreditPoints;
	}

	public void setPersonalCreditPoints(Integer personalCreditPoints) {
		this.personalCreditPoints = personalCreditPoints;
	}

	public Integer getCompanyCreditPoints() {
		return companyCreditPoints;
	}

	public void setCompanyCreditPoints(Integer companyCreditPoints) {
		this.companyCreditPoints = companyCreditPoints;
	}

	public String getMemRealName() {
		return memRealName;
	}

	public void setMemRealName(String memRealName) {
		this.memRealName = memRealName;
	}

	public TbMemSeller getSellerInfo() {
		return sellerInfo;
	}

	public void setSellerInfo(TbMemSeller sellerInfo) {
		this.sellerInfo = sellerInfo;
	}


	public TbMemArtist getArtistInfo() {
		return artistInfo;
	}

	public void setArtistInfo(TbMemArtist artistInfo) {
		this.artistInfo = artistInfo;
	}

	public TbMemPersonalCertifyinfo getMemPersonalCertifyinfo() {
		return memPersonalCertifyinfo;
	}

	public void setMemPersonalCertifyinfo(TbMemPersonalCertifyinfo memPersonalCertifyinfo) {
		this.memPersonalCertifyinfo = memPersonalCertifyinfo;
	}

	public TbMemModelInfo getModelInfo() {
		return modelInfo;
	}

	public void setModelInfo(TbMemModelInfo modelInfo) {
		this.modelInfo = modelInfo;
	}
}

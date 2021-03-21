package vitily.com.ts_entity.adm;

import vitily.com.tb_entity.adm.TbAdmUser;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsAdmUser extends BaseSearch<TbAdmUser> {
	public TsAdmUser(){
		super(new TbAdmUser());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 超级管理员id
	 */
	private Integer superAdminId;
	/**
	 * 分组idStr如 (1,2,...x)
	 */
	private String groupIdStr;
	/**
	 * 最近一次登录时间：开始
	 */
	private String beginLastLoginDate;
	/**
	 * 最近一次登录时间：结束
	 */
	private String endLastLoginDate;
	/**
	 * 登录用户名
	 */
	private String selUserName;
	/**
	 * 手机号码
	 */
	private String selPhone;
	/**
	 * email
	 */
	private String selEmail;
	/**
	 * 真实姓名
	 */
	private String selRealName;
	/**
	 * 昵称
	 */
	private String selNickName;
	private String selPhoneOrName;
	public Integer getSuperAdminId() {
		return superAdminId;
	}
	public void setSuperAdminId(Integer superAdminId) {
		this.superAdminId = superAdminId;
	}
	public String getGroupIdStr() {
		return groupIdStr;
	}
	public void setGroupIdStr(String groupIdStr) {
		if(CommonUtil.isNumOrD(groupIdStr)){
			this.groupIdStr = groupIdStr;
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
	public String getSelUserName() {
		return selUserName;
	}
	public void setSelUserName(String selUserName) {
		this.selUserName = selUserName;
	}
	public String getSelPhone() {
		return selPhone;
	}
	public void setSelPhone(String selPhone) {
		this.selPhone = selPhone;
	}
	public String getSelEmail() {
		return selEmail;
	}
	public void setSelEmail(String selEmail) {
		this.selEmail = selEmail;
	}
	public String getSelRealName() {
		return selRealName;
	}
	public void setSelRealName(String selRealName) {
		this.selRealName = selRealName;
	}
	public String getSelNickName() {
		return selNickName;
	}
	public void setSelNickName(String selNickName) {
		this.selNickName = selNickName;
	}
	public String getSelPhoneOrName() {
		return selPhoneOrName;
	}
	public void setSelPhoneOrName(String selPhoneOrName) {
		this.selPhoneOrName = selPhoneOrName;
	}
}

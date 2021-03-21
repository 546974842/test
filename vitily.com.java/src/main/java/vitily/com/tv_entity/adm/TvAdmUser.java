package vitily.com.tv_entity.adm;


import vitily.com.tb_entity.adm.TbAdmUser;

public class TvAdmUser extends TbAdmUser {
	/**
	 * 分组名称
	 */
	private String roleName;
	/**
	 * 分组权限
	 */
	private String rolePermissionStr;
	/**
	 * 分组状态
	 */
	private Integer roleState;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRolePermissionStr() {
		return rolePermissionStr;
	}
	public void setRolePermissionStr(String rolePermissionStr) {
		this.rolePermissionStr = rolePermissionStr;
	}
	public String getTotalPermissionStr() {
		return this.getPermissionStr() + this.rolePermissionStr;
	}
	public Integer getRoleState() {
		return roleState;
	}
	public void setRoleState(Integer roleState) {
		this.roleState = roleState;
	}

}

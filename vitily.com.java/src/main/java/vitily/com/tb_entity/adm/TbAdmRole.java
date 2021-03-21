package vitily.com.tb_entity.adm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:ti_adm_role表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbAdmRole extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 分组名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 权限字符串
     */
    private String permissionStr;

    /**
     * 分组名称
     * [whh]@return name 分组名称
     */
    public String getName() {
        return name;
    }

    /**
     * 分组名称
     * @param name 分组名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 描述
     * [whh]@return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 权限字符串
     * [whh]@return permission_str 权限字符串
     */
    public String getPermissionStr() {
        return permissionStr;
    }

    /**
     * 权限字符串
     * @param permissionStr 权限字符串
     */
    public void setPermissionStr(String permissionStr) {
        this.permissionStr = permissionStr;
    }
}
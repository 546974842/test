package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:ti_category表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-19
 */
public class TbCategory extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 类型id
     */
    private Integer typeId;

    /**
     * 系统类型
     */
    private Integer sysType;
    /**
     * 父级id
     */
    private Integer parentId;
    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类关键字
     */
    private String keyword;

    /**
     * 描述
     */
    private String description;

    /**
     * 标识符
     */
    private String urlTip;

    /**
     * 类型id
     * [whh]@return type_id 类型id
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 类型id
     * @param typeId 类型id
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 系统类型
     * [whh]@return sys_type 系统类型
     */
    public Integer getSysType() {
        return sysType;
    }

    /**
     * 系统类型
     * @param sysType 系统类型
     */
    public void setSysType(Integer sysType) {
        this.sysType = sysType;
    }

    /**
     * 父级id
     * [whh]@return parent_id 父级id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父级id
     * @param parentId 父级id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 分类名称
     * [whh]@return name 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 分类名称
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 分类关键字
     * [whh]@return keyword 分类关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 分类关键字
     * @param keyword 分类关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
     * 标识符
     * [whh]@return url_tip 标识符
     */
    public String getUrlTip() {
        return urlTip;
    }

    /**
     * 标识符
     * @param urlTip 标识符
     */
    public void setUrlTip(String urlTip) {
        this.urlTip = urlTip;
    }
}
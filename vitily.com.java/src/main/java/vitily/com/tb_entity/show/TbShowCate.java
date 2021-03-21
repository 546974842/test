package vitily.com.tb_entity.show;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:体验类目表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-07-15
 */
public class TbShowCate extends BaseEntity {
    /**
     * 类型id
     */
    private Integer typeId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;
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
}
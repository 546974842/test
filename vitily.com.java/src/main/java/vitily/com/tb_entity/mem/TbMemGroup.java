package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_mem_group表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbMemGroup extends BaseEntity {
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
     * 默认状态
     */
    private Integer isDefault;

    /**
     * 享受价格百分比
     */
    private Double percent;

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
     * 默认状态
     * [whh]@return is_default 默认状态
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * 默认状态
     * @param isDefault 默认状态
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 享受价格百分比
     * [whh]@return percent 享受价格百分比
     */
    public Double getPercent() {
        return percent;
    }

    /**
     * 享受价格百分比
     * @param percent 享受价格百分比
     */
    public void setPercent(Double percent) {
        this.percent = percent;
    }
}
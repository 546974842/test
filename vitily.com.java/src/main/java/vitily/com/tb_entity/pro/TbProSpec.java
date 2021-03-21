package vitily.com.tb_entity.pro;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_spec表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbProSpec extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 规格名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 显示类型（图片or其他）
     */
    private Integer showType;

    /**
     * 显示方式
     */
    private Integer showWay;

    /**
     * 规格名称
     * [whh]@return name 规格名称
     */
    public String getName() {
        return name;
    }

    /**
     * 规格名称
     * @param name 规格名称
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
     * 显示类型（图片or其他）
     * [whh]@return show_type 显示类型（图片or其他）
     */
    public Integer getShowType() {
        return showType;
    }

    /**
     * 显示类型（图片or其他）
     * @param showType 显示类型（图片or其他）
     */
    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    /**
     * 显示方式
     * [whh]@return show_way 显示方式
     */
    public Integer getShowWay() {
        return showWay;
    }

    /**
     * 显示方式
     * @param showWay 显示方式
     */
    public void setShowWay(Integer showWay) {
        this.showWay = showWay;
    }
}
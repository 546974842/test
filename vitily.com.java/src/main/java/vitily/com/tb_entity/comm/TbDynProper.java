package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_dyn_proper表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-19
 */
public class TbDynProper extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 类型id
     */
    private Integer typeId;

    /**
     * 所在类型id
     */
    private Integer htmlType;

    /**
     * 名称
     */
    private String name;

    /**
     * 值
     */
    private String value;

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
     * 所在类型id
     * [whh]@return html_type 所在类型id
     */
    public Integer getHtmlType() {
        return htmlType;
    }

    /**
     * 所在类型id
     * @param htmlType 所在类型id
     */
    public void setHtmlType(Integer htmlType) {
        this.htmlType = htmlType;
    }

    /**
     * 名称
     * [whh]@return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 值
     * [whh]@return value 值
     */
    public String getValue() {
        return value;
    }

    /**
     * 值
     * @param value 值
     */
    public void setValue(String value) {
        this.value = value;
    }
}
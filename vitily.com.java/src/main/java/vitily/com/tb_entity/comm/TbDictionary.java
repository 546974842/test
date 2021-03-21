package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:ti_dictionary表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbDictionary extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 类型id
     */
    private Integer typeId;

    /**
     * 键
     */
    private String key;

    /**
     * 值
     */
    private String value;

    /**
     * 描述
     */
    private String description;

    /**
     * 类型Id
     * @return 类型id
     */
    public Integer getTypeId() {
		return typeId;
	}
    /**
     * 类型id
     * @param  类型id
     */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
     * 键
     * [whh]@return key 键
     */
    public String getKey() {
        return key;
    }

    /**
     * 键
     * @param key 键
     */
    public void setKey(String key) {
        this.key = key;
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
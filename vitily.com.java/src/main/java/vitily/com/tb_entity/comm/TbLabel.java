package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_label表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-19
 */
public class TbLabel extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 类型
     */
    private Integer typeId;

    /**
     * 标签名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 标识符
     */
    private String urlTip;

    /**
     * 类型
     * [whh]@return type 类型
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 类型
     * @param type 类型
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 标签名
     * [whh]@return name 标签名
     */
    public String getName() {
        return name;
    }

    /**
     * 标签名
     * @param name 标签名
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
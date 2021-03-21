package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:ti_pay_way表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-19
 */
public class TbPayWay extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 支付方式名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 支付方式名称
     * [whh]@return name 支付方式名称
     */
    public String getName() {
        return name;
    }

    /**
     * 支付方式名称
     * @param name 支付方式名称
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
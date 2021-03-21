package vitily.com.tb_entity.comm;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:物流方式表表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-03-24
 */
public class TbDeliveryWay extends BaseEntity {
    /**
     * 物流名称
     */
    private String name;

    /**
     * 物流价格(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long price;

    /**
     * 描述
     */
    private String description;
    /**
     * 物流名称
     * [whh]@return name 物流名称
     */
    public String getName() {
        return name;
    }

    /**
     * 物流名称
     * @param name 物流名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 物流价格(单位：分)
     * [whh]@return price 物流价格(单位：分)
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 物流价格(单位：分)
     * @param price 物流价格(单位：分)
     */
    public void setPrice(Long price) {
        this.price = price;
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
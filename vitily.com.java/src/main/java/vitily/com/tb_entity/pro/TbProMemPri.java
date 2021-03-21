package vitily.com.tb_entity.pro;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:产品会员价格表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-03-24
 */
public class TbProMemPri extends BaseEntity {
    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 分组id
     */
    private Integer groupId;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 真实产品id
     */
    private Integer specParProId;

    /**
     * guid
     */
    private String guid;

    /**
     * 价格(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long price;

    /**
     * 规格参数id组合
     */
    private String specParIds;
    /**
     * 会员id
     * [whh]@return member_id 会员id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 会员id
     * @param memberId 会员id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 分组id
     * [whh]@return group_id 分组id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 分组id
     * @param groupId 分组id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 产品id
     * [whh]@return product_id 产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 产品id
     * @param productId 产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 真实产品id
     * [whh]@return spec_par_pro_id 真实产品id
     */
    public Integer getSpecParProId() {
        return specParProId;
    }

    /**
     * 真实产品id
     * @param specParProId 真实产品id
     */
    public void setSpecParProId(Integer specParProId) {
        this.specParProId = specParProId;
    }

    /**
     * guid
     * [whh]@return guid guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * guid
     * @param guid guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * 价格(单位：分)
     * [whh]@return price 价格(单位：分)
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 价格(单位：分)
     * @param price 价格(单位：分)
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 规格参数id组合
     * [whh]@return spec_par_ids 规格参数id组合
     */
    public String getSpecParIds() {
        return specParIds;
    }

    /**
     * 规格参数id组合
     * @param specParIds 规格参数id组合
     */
    public void setSpecParIds(String specParIds) {
        this.specParIds = specParIds;
    }

}
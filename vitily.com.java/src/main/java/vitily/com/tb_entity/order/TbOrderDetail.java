package vitily.com.tb_entity.order;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:订单详情表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-03-24
 */
public class TbOrderDetail extends BaseEntity {
    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 产品价格(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long proPrice;

    /**
     * 产品图片
     */
    private String proPicList;

    /**
     * 产品描述
     */
    private String proName;

    /**
     * 商品编号
     */
    private String proNumber;

    /**
     * 购买数量
     */
    private Integer purchaseQuantity;

    /**
     * 产品规格关联id
     */
    private Integer proSpId;

    /**
     * 订单Id
     */
    private Integer orderId;
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
     * 产品价格(单位：分)
     * [whh]@return pro_price 产品价格(单位：分)
     */
    public Long getProPrice() {
        return proPrice;
    }

    /**
     * 产品价格(单位：分)
     * @param proPrice 产品价格(单位：分)
     */
    public void setProPrice(Long proPrice) {
        this.proPrice = proPrice;
    }

    /**
     * 产品图片
     * [whh]@return pro_pic_list 产品图片
     */
    public String getProPicList() {
        return proPicList;
    }

    /**
     * 产品图片
     * @param proPicList 产品图片
     */
    public void setProPicList(String proPicList) {
        this.proPicList = proPicList;
    }

    /**
     * 产品描述
     * [whh]@return pro_name 产品描述
     */
    public String getProName() {
        return proName;
    }

    /**
     * 产品描述
     * @param proName 产品描述
     */
    public void setProName(String proName) {
        this.proName = proName;
    }

    /**
     * 商品编号
     * [whh]@return pro_number 商品编号
     */
    public String getProNumber() {
        return proNumber;
    }

    /**
     * 商品编号
     * @param proNumber 商品编号
     */
    public void setProNumber(String proNumber) {
        this.proNumber = proNumber;
    }

    /**
     * 购买数量
     * [whh]@return purchase_quantity 购买数量
     */
    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    /**
     * 购买数量
     * @param purchaseQuantity 购买数量
     */
    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    /**
     * 产品规格关联id
     * [whh]@return pro_sp_id 产品规格关联id
     */
    public Integer getProSpId() {
        return proSpId;
    }

    /**
     * 产品规格关联id
     * @param proSpId 产品规格关联id
     */
    public void setProSpId(Integer proSpId) {
        this.proSpId = proSpId;
    }

    /**
     * 订单Id
     * [whh]@return order_id 订单Id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 订单Id
     * @param orderId 订单Id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
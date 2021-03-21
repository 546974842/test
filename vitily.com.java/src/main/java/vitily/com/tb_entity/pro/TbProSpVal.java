package vitily.com.tb_entity.pro;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:产品规格参数组合（真实产品）表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-03-24
 */
public class TbProSpVal extends BaseEntity {
    /**
     * 类型id
     */
    private Integer typeId;

    /**
     * 分类id
     */
    private Integer cateId;

    /**
     * 对应新闻id
     */
    private Integer newsId;

    /**
     * 编号
     */
    private String number;

    /**
     * 进货价(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long inPrice;

    /**
     * 原价(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long primePrice;

    /**
     * 销售价(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long salePrice;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 规格id组合
     */
    private String specIds;

    /**
     * 规格名字组合
     */
    private String specNames;

    /**
     * 规格显示类型组合
     */
    private String specTypes;

    /**
     * 规格参数值id组合
     */
    private String specParIds;

    /**
     * 规格参数值组合
     */
    private String specParVals;

    /**
     * guid
     */
    private String guid;

    /**
     * 点击量
     */
    private Integer hits;

    /**
     * 可用的支付方式id组合
     */
    private String payWayIds;

    /**
     * 可用的配送方式列表
     */
    private String deliveryIds;

    /**
     * 限购数量
     */
    private Integer maxCanbuy;

    /**
     * 产品标签id组合
     */
    private String labelIds;

    /**
     * 产品描述（详情）
     */
    private String description;

    /**
     * 产品图片链接
     */
    private String picList;

    /**
     * 对应产品id
     */
    private Integer productId;

    /**
     * 版本
     */
    private Integer version;
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
     * 分类id
     * [whh]@return cate_id 分类id
     */
    public Integer getCateId() {
        return cateId;
    }

    /**
     * 分类id
     * @param cateId 分类id
     */
    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    /**
     * 对应新闻id
     * [whh]@return news_id 对应新闻id
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * 对应新闻id
     * @param newsId 对应新闻id
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * 编号
     * [whh]@return number 编号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 编号
     * @param number 编号
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 进货价(单位：分)
     * [whh]@return in_price 进货价(单位：分)
     */
    public Long getInPrice() {
        return inPrice;
    }

    /**
     * 进货价(单位：分)
     * @param inPrice 进货价(单位：分)
     */
    public void setInPrice(Long inPrice) {
        this.inPrice = inPrice;
    }

    /**
     * 原价(单位：分)
     * [whh]@return prime_price 原价(单位：分)
     */
    public Long getPrimePrice() {
        return primePrice;
    }

    /**
     * 原价(单位：分)
     * @param primePrice 原价(单位：分)
     */
    public void setPrimePrice(Long primePrice) {
        this.primePrice = primePrice;
    }

    /**
     * 销售价(单位：分)
     * [whh]@return sale_price 销售价(单位：分)
     */
    public Long getSalePrice() {
        return salePrice;
    }

    /**
     * 销售价(单位：分)
     * @param salePrice 销售价(单位：分)
     */
    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * 库存
     * [whh]@return stock 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 库存
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 规格id组合
     * [whh]@return spec_ids 规格id组合
     */
    public String getSpecIds() {
        return specIds;
    }

    /**
     * 规格id组合
     * @param specIds 规格id组合
     */
    public void setSpecIds(String specIds) {
        this.specIds = specIds;
    }

    /**
     * 规格名字组合
     * [whh]@return spec_names 规格名字组合
     */
    public String getSpecNames() {
        return specNames;
    }

    /**
     * 规格名字组合
     * @param specNames 规格名字组合
     */
    public void setSpecNames(String specNames) {
        this.specNames = specNames;
    }

    /**
     * 规格显示类型组合
     * [whh]@return spec_types 规格显示类型组合
     */
    public String getSpecTypes() {
        return specTypes;
    }

    /**
     * 规格显示类型组合
     * @param specTypes 规格显示类型组合
     */
    public void setSpecTypes(String specTypes) {
        this.specTypes = specTypes;
    }

    /**
     * 规格参数值id组合
     * [whh]@return spec_par_ids 规格参数值id组合
     */
    public String getSpecParIds() {
        return specParIds;
    }

    /**
     * 规格参数值id组合
     * @param specParIds 规格参数值id组合
     */
    public void setSpecParIds(String specParIds) {
        this.specParIds = specParIds;
    }

    /**
     * 规格参数值组合
     * [whh]@return spec_par_vals 规格参数值组合
     */
    public String getSpecParVals() {
        return specParVals;
    }

    /**
     * 规格参数值组合
     * @param specParVals 规格参数值组合
     */
    public void setSpecParVals(String specParVals) {
        this.specParVals = specParVals;
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
     * 点击量
     * [whh]@return hits 点击量
     */
    public Integer getHits() {
        return hits;
    }

    /**
     * 点击量
     * @param hits 点击量
     */
    public void setHits(Integer hits) {
        this.hits = hits;
    }

    /**
     * 可用的支付方式id组合
     * [whh]@return pay_way_ids 可用的支付方式id组合
     */
    public String getPayWayIds() {
        return payWayIds;
    }

    /**
     * 可用的支付方式id组合
     * @param payWayIds 可用的支付方式id组合
     */
    public void setPayWayIds(String payWayIds) {
        this.payWayIds = payWayIds;
    }

    /**
     * 可用的配送方式列表
     * [whh]@return delivery_ids 可用的配送方式列表
     */
    public String getDeliveryIds() {
        return deliveryIds;
    }

    /**
     * 可用的配送方式列表
     * @param deliveryIds 可用的配送方式列表
     */
    public void setDeliveryIds(String deliveryIds) {
        this.deliveryIds = deliveryIds;
    }

    /**
     * 限购数量
     * [whh]@return max_canbuy 限购数量
     */
    public Integer getMaxCanbuy() {
        return maxCanbuy;
    }

    /**
     * 限购数量
     * @param maxCanbuy 限购数量
     */
    public void setMaxCanbuy(Integer maxCanbuy) {
        this.maxCanbuy = maxCanbuy;
    }

    /**
     * 产品标签id组合
     * [whh]@return label_ids 产品标签id组合
     */
    public String getLabelIds() {
        return labelIds;
    }

    /**
     * 产品标签id组合
     * @param labelIds 产品标签id组合
     */
    public void setLabelIds(String labelIds) {
        this.labelIds = labelIds;
    }

    /**
     * 产品描述（详情）
     * [whh]@return description 产品描述（详情）
     */
    public String getDescription() {
        return description;
    }

    /**
     * 产品描述（详情）
     * @param description 产品描述（详情）
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 产品图片链接
     * [whh]@return pic_list 产品图片链接
     */
    public String getPicList() {
        return picList;
    }

    /**
     * 产品图片链接
     * @param picList 产品图片链接
     */
    public void setPicList(String picList) {
        this.picList = picList;
    }

    /**
     * 对应产品id
     * [whh]@return product_id 对应产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 对应产品id
     * @param productId 对应产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 版本
     * [whh]@return version 版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 版本
     * @param version 版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}
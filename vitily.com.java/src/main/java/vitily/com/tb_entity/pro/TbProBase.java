package vitily.com.tb_entity.pro;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:产品主表（虚拟产品）表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-03-24
 */
public class TbProBase extends BaseEntity {
    /**
     * 类型id
     */
    private Integer typeId;

    /**
     * 分类id
     */
    private Integer cateId;

    /**
     * 新闻id
     */
    private Integer newsId;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品编号
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
     * 点击量
     */
    private Integer hits;

    /**
     * 可用支付方式
     */
    private String payWayIds;

    /**
     * 可用配送方式
     */
    private String deliveryIds;

    /**
     * 限购数量
     */
    private Integer maxCanbuy;

    /**
     * 标签ids
     */
    private String labelIds;

    /**
     * 图片链接组
     */
    private String picList;

    /**
     * 品牌Id
     */
    private Integer brandId;

    /**
     * 原库存
     */
    private Integer stock;

    /**
     * 已售
     */
    private Integer soldCount;

    /**
     * 评论数
     */
    private Integer commitCount;

    /**
     * 简述
     */
    private String subDesc;

    /**
     * 版本
     */
    private Integer version;

    /**
     * 产品详情
     */
    private String description;
    /**
     * 页面关键字
     */
    private String keyword;
    /**
     * 页面标题
     */
    private String pageTitle;
    /**
     * 页面描述
     */
    private String pageDescription;
    /**
     * 选择的规格参数id组合
     */
    private String sppAttrIds;

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
     * 新闻id
     * [whh]@return news_id 新闻id
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * 新闻id
     * @param newsId 新闻id
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * 产品名称
     * [whh]@return name 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 产品名称
     * @param name 产品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 产品编号
     * [whh]@return number 产品编号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 产品编号
     * @param number 产品编号
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
     * 可用支付方式
     * [whh]@return pay_way_ids 可用支付方式
     */
    public String getPayWayIds() {
        return payWayIds;
    }

    /**
     * 可用支付方式
     * @param payWayIds 可用支付方式
     */
    public void setPayWayIds(String payWayIds) {
        this.payWayIds = payWayIds;
    }

    /**
     * 可用配送方式
     * [whh]@return delivery_ids 可用配送方式
     */
    public String getDeliveryIds() {
        return deliveryIds;
    }

    /**
     * 可用配送方式
     * @param deliveryIds 可用配送方式
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
     * 标签ids
     * [whh]@return label_ids 标签ids
     */
    public String getLabelIds() {
        return labelIds;
    }

    /**
     * 标签ids
     * @param labelIds 标签ids
     */
    public void setLabelIds(String labelIds) {
        this.labelIds = labelIds;
    }

    /**
     * 图片链接组
     * [whh]@return pic_list 图片链接组
     */
    public String getPicList() {
        return picList;
    }

    /**
     * 图片链接组
     * @param picList 图片链接组
     */
    public void setPicList(String picList) {
        this.picList = picList;
    }

    /**
     * 品牌Id
     * [whh]@return brand_id 品牌Id
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * 品牌Id
     * @param brandId 品牌Id
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * 原库存
     * [whh]@return stock 原库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 原库存
     * @param stock 原库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 已售
     * [whh]@return sold_count 已售
     */
    public Integer getSoldCount() {
        return soldCount;
    }

    /**
     * 已售
     * @param soldCount 已售
     */
    public void setSoldCount(Integer soldCount) {
        this.soldCount = soldCount;
    }

    /**
     * 评论数
     * [whh]@return commit_count 评论数
     */
    public Integer getCommitCount() {
        return commitCount;
    }

    /**
     * 评论数
     * @param commitCount 评论数
     */
    public void setCommitCount(Integer commitCount) {
        this.commitCount = commitCount;
    }

    /**
     * 简述
     * [whh]@return sub_desc 简述
     */
    public String getSubDesc() {
        return subDesc;
    }

    /**
     * 简述
     * @param subDesc 简述
     */
    public void setSubDesc(String subDesc) {
        this.subDesc = subDesc;
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

    /**
     * 产品详情
     * [whh]@return description 产品详情
     */
    public String getDescription() {
        return description;
    }

    /**
     * 产品详情
     * @param description 产品详情
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 页面关键字
     * @return
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 页面关键字
     * @param keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * 页面标题
     * @return
     */
    public String getPageTitle() {
        return pageTitle;
    }

    /**
     * 页面标题
     * @param pageTitle
     */
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    /**
     * 页面描述
     * @return
     */
    public String getPageDescription() {
        return pageDescription;
    }

    /**
     * 页面描述
     * @param pageDescription
     */
    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

    /**
     * 选择的规格参数id组合
     * @return
     */
    public String getSppAttrIds() {
        return sppAttrIds;
    }

    /**
     * 选择的规格参数id组合
     * @param sppAttrIds
     */
    public void setSppAttrIds(String sppAttrIds) {
        this.sppAttrIds = sppAttrIds;
    }
}
package vitily.com.tb_entity.comm;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:虚拟分类表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-03-24
 */
public class TbCateVirtual extends BaseEntity {
    /**
     * 类型id
     */
    private Integer typeId;

    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 描述
     */
    private String description;

    /**
     * 关键字筛选
     */
    private String selKeyword;

    /**
     * 最低价格(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long minPrice;

    /**
     * 最高价格(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long maxPrice;

    /**
     * 分类id组合
     */
    private String cateIds;

    /**
     * 品牌id组合
     */
    private String brandIds;

    /**
     * 标签id组合
     */
    private String labelIds;

    /**
     * 拼接的sql
     */
    private String sql;
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
     * 父级id
     * [whh]@return parent_id 父级id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父级id
     * @param parentId 父级id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 分类名称
     * [whh]@return name 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 分类名称
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 关键字
     * [whh]@return keyword 关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 关键字
     * @param keyword 关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
     * 关键字筛选
     * [whh]@return sel_keyword 关键字筛选
     */
    public String getSelKeyword() {
        return selKeyword;
    }

    /**
     * 关键字筛选
     * @param selKeyword 关键字筛选
     */
    public void setSelKeyword(String selKeyword) {
        this.selKeyword = selKeyword;
    }

    /**
     * 最低价格(单位：分)
     * [whh]@return min_price 最低价格(单位：分)
     */
    public Long getMinPrice() {
        return minPrice;
    }

    /**
     * 最低价格(单位：分)
     * @param minPrice 最低价格(单位：分)
     */
    public void setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * 最高价格(单位：分)
     * [whh]@return max_price 最高价格(单位：分)
     */
    public Long getMaxPrice() {
        return maxPrice;
    }

    /**
     * 最高价格(单位：分)
     * @param maxPrice 最高价格(单位：分)
     */
    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * 分类id组合
     * [whh]@return cate_ids 分类id组合
     */
    public String getCateIds() {
        return cateIds;
    }

    /**
     * 分类id组合
     * @param cateIds 分类id组合
     */
    public void setCateIds(String cateIds) {
        this.cateIds = cateIds;
    }

    /**
     * 品牌id组合
     * [whh]@return brand_ids 品牌id组合
     */
    public String getBrandIds() {
        return brandIds;
    }

    /**
     * 品牌id组合
     * @param brandIds 品牌id组合
     */
    public void setBrandIds(String brandIds) {
        this.brandIds = brandIds;
    }

    /**
     * 标签id组合
     * [whh]@return label_ids 标签id组合
     */
    public String getLabelIds() {
        return labelIds;
    }

    /**
     * 标签id组合
     * @param labelIds 标签id组合
     */
    public void setLabelIds(String labelIds) {
        this.labelIds = labelIds;
    }

    /**
     * 拼接的sql
     * [whh]@return sql 拼接的sql
     */
    public String getSql() {
        return sql;
    }

    /**
     * 拼接的sql
     * @param sql 拼接的sql
     */
    public void setSql(String sql) {
        this.sql = sql;
    }
}
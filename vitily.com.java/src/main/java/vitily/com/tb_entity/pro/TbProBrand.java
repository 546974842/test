package vitily.com.tb_entity.pro;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_brand表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbProBrand extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 类别名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片url
     */
    private String picSrc;

    /**
     * 分类Id
     */
    private Integer cateId;

    /**
     * 类型Id
     */
    private Integer typeId;

    /**
     * 详情
     */
    private String content;

    /**
     * 类别名称
     * [whh]@return name 类别名称
     */
    public String getName() {
        return name;
    }

    /**
     * 类别名称
     * @param name 类别名称
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
     * 图片url
     * [whh]@return pic_src 图片url
     */
    public String getPicSrc() {
        return picSrc;
    }

    /**
     * 图片url
     * @param picSrc 图片url
     */
    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc;
    }

    /**
     * 分类Id
     * [whh]@return cate_id 分类Id
     */
    public Integer getCateId() {
        return cateId;
    }

    /**
     * 分类Id
     * @param cateId 分类Id
     */
    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    /**
     * 类型Id
     * [whh]@return type_id 类型Id
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 类型Id
     * @param typeId 类型Id
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 详情
     * [whh]@return content 详情
     */
    public String getContent() {
        return content;
    }

    /**
     * 详情
     * @param content 详情
     */
    public void setContent(String content) {
        this.content = content;
    }
}
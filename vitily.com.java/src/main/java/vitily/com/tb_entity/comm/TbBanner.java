package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_banner表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-19
 */
public class TbBanner extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 页面类型
     */
    private Integer pageType;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片地址
     */
    private String picUrl;

    /**
     * 图片跳转连接
     */
    private String link;

    /**
     * 页面类型
     * [whh]@return page_type 页面类型
     */
    public Integer getPageType() {
        return pageType;
    }

    /**
     * 页面类型
     * @param pageType 页面类型
     */
    public void setPageType(Integer pageType) {
        this.pageType = pageType;
    }

    /**
     * 标题
     * [whh]@return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
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
     * 图片地址
     * [whh]@return pic_url 图片地址
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 图片地址
     * @param picUrl 图片地址
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 图片跳转连接
     * [whh]@return link 图片跳转连接
     */
    public String getLink() {
        return link;
    }

    /**
     * 图片跳转连接
     * @param link 图片跳转连接
     */
    public void setLink(String link) {
        this.link = link;
    }
}
package vitily.com.tb_entity.cms;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_cms_news表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbCmsNews extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 分类id
     */
    private Integer cateId;

    /**
     * 类型id
     */
    private Integer typeId;

    /**
     * 标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 简述
     */
    private String description;

    /**
     * 作者
     */
    private String author;

    /**
     * 来源
     */
    private String comeFrom;

    /**
     * 是否可评论
     */
    private Integer commentable;

    /**
     * 点击量
     */
    private Integer hits;

    /**
     * 是否置顶
     */
    private Integer top;

    /**
     * 页面标题
     */
    private String pageTitle;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 页面描述
     */
    private String pageDescription;

    /**
     * 是否已发布
     */
    private Integer published;

    /**
     * 标签id组合
     */
    private String labelIds;

    /**
     * 图片列表
     */
    private String picList;

    /**
     * 文件列表
     */
    private String fileList;

    /**
     * url标识符
     */
    private String urlTip;

    /**
     * 关联链接
     */
    private String relatedLink;

    /**
     * 发布时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date displaydate;

    /**
     * 内容
     */
    private String content;

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
     * 副标题
     * [whh]@return sub_title 副标题
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 副标题
     * @param subTitle 副标题
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * 简述
     * [whh]@return description 简述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 简述
     * @param description 简述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 作者
     * [whh]@return author 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 作者
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 来源
     * [whh]@return come_from 来源
     */
    public String getComeFrom() {
        return comeFrom;
    }

    /**
     * 来源
     * @param comeFrom 来源
     */
    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }

    /**
     * 是否可评论
     * [whh]@return commentable 是否可评论
     */
    public Integer getCommentable() {
        return commentable;
    }

    /**
     * 是否可评论
     * @param commentable 是否可评论
     */
    public void setCommentable(Integer commentable) {
        this.commentable = commentable;
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
     * 是否置顶
     * [whh]@return top 是否置顶
     */
    public Integer getTop() {
        return top;
    }

    /**
     * 是否置顶
     * @param top 是否置顶
     */
    public void setTop(Integer top) {
        this.top = top;
    }

    /**
     * 页面标题
     * [whh]@return page_title 页面标题
     */
    public String getPageTitle() {
        return pageTitle;
    }

    /**
     * 页面标题
     * @param pageTitle 页面标题
     */
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
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
     * 页面描述
     * [whh]@return page_description 页面描述
     */
    public String getPageDescription() {
        return pageDescription;
    }

    /**
     * 页面描述
     * @param pageDescription 页面描述
     */
    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

    /**
     * 是否已发布
     * [whh]@return published 是否已发布
     */
    public Integer getPublished() {
        return published;
    }

    /**
     * 是否已发布
     * @param published 是否已发布
     */
    public void setPublished(Integer published) {
        this.published = published;
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
     * 图片列表
     * [whh]@return pic_list 图片列表
     */
    public String getPicList() {
        return picList;
    }

    /**
     * 图片列表
     * @param picList 图片列表
     */
    public void setPicList(String picList) {
        this.picList = picList;
    }

    /**
     * 文件列表
     * [whh]@return file_list 文件列表
     */
    public String getFileList() {
        return fileList;
    }

    /**
     * 文件列表
     * @param fileList 文件列表
     */
    public void setFileList(String fileList) {
        this.fileList = fileList;
    }

    /**
     * url标识符
     * [whh]@return url_tip url标识符
     */
    public String getUrlTip() {
        return urlTip;
    }

    /**
     * url标识符
     * @param urlTip url标识符
     */
    public void setUrlTip(String urlTip) {
        this.urlTip = urlTip;
    }

    /**
     * 关联链接
     * [whh]@return related_link 关联链接
     */
    public String getRelatedLink() {
        return relatedLink;
    }

    /**
     * 关联链接
     * @param relatedLink 关联链接
     */
    public void setRelatedLink(String relatedLink) {
        this.relatedLink = relatedLink;
    }

    /**
     * 发布时间
     * [whh]@return displaydate 发布时间
     */
    public Date getDisplaydate() {
        return displaydate;
    }

    /**
     * 发布时间
     * @param displaydate 发布时间
     */
    public void setDisplaydate(Date displaydate) {
        this.displaydate = displaydate;
    }

    /**
     * 内容
     * [whh]@return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}
package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_advertise表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-19
 */
public class TbAdvertise extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 对应信息id
     */
    private Integer newsId;

    /**
     * 对应类型id
     */
    private Integer typeId;

    /**
     * 文件url
     */
    private String fileUrl;

    /**
     * 缩略图url
     */
    private String imgSamUrl;

    /**
     * 标题
     */
    private String title;

    /**
     * 广告内容
     */
    private String content;

    /**
     * 关联链接
     */
    private String link;

    /**
     * 对应信息id
     * [whh]@return news_id 对应信息id
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * 对应信息id
     * @param newsId 对应信息id
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * 对应类型id
     * [whh]@return type_id 对应类型id
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 对应类型id
     * @param typeId 对应类型id
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 文件url
     * [whh]@return file_url 文件url
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 文件url
     * @param fileUrl 文件url
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 缩略图url
     * [whh]@return img_sam_url 缩略图url
     */
    public String getImgSamUrl() {
        return imgSamUrl;
    }

    /**
     * 缩略图url
     * @param imgSamUrl 缩略图url
     */
    public void setImgSamUrl(String imgSamUrl) {
        this.imgSamUrl = imgSamUrl;
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
     * 广告内容
     * [whh]@return content 广告内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 广告内容
     * @param content 广告内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 关联链接
     * [whh]@return link 关联链接
     */
    public String getLink() {
        return link;
    }

    /**
     * 关联链接
     * @param link 关联链接
     */
    public void setLink(String link) {
        this.link = link;
    }
}
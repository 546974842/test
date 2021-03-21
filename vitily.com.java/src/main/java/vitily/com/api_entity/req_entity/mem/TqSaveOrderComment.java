package vitily.com.api_entity.req_entity.mem;

import vitily.com.annotation.RequireValidator;

/**
 * creator : whh-lether
 * date    : 2018/12/27 13:48
 * desc    :
 **/
public class TqSaveOrderComment extends TqMemBase {


    /**
     * 类型（0：评论，1：回复）
     */
    private Integer type;

    /**
     * 订单id
     */
    @RequireValidator
    private Integer orderId;

    /**
     * 模特秀id
     */
    private Integer showId;

    /**
     * 上级id
     */
    private Integer parentCommentId;

    /**
     * 标签
     */
    private String tags;

    /**
     * 内容
     */
    @RequireValidator
    private String content;

    /**
     * 图片0
     */
    private String pic0Url;

    /**
     * 图片1
     */
    private String pic1Url;

    /**
     * 图片2
     */
    private String pic2Url;

    /**
     * 图片3
     */
    private String pic3Url;

    /**
     * 图片4
     */
    private String pic4Url;

    /**
     * 视频0
     */
    private String video0Url;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }


    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic0Url() {
        return pic0Url;
    }

    public void setPic0Url(String pic0Url) {
        this.pic0Url = pic0Url;
    }

    public String getPic1Url() {
        return pic1Url;
    }

    public void setPic1Url(String pic1Url) {
        this.pic1Url = pic1Url;
    }

    public String getPic2Url() {
        return pic2Url;
    }

    public void setPic2Url(String pic2Url) {
        this.pic2Url = pic2Url;
    }

    public String getPic3Url() {
        return pic3Url;
    }

    public void setPic3Url(String pic3Url) {
        this.pic3Url = pic3Url;
    }

    public String getPic4Url() {
        return pic4Url;
    }

    public void setPic4Url(String pic4Url) {
        this.pic4Url = pic4Url;
    }

    public String getVideo0Url() {
        return video0Url;
    }

    public void setVideo0Url(String video0Url) {
        this.video0Url = video0Url;
    }
}

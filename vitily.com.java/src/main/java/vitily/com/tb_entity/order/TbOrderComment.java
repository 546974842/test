package vitily.com.tb_entity.order;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:体验秀订单评论表表的实体类
 * @version
 * @author:  pc
 * @创建时间: 2018-12-26
 */
public class TbOrderComment extends BaseEntity {

    /**
     * 类型（0：评论，1：回复）
     */
    private Integer type;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 模特秀id
     */
    private Integer showId;

    /**
     * 会员id
     */
    private Integer memberId;

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

    private String auditDescription;

    /**
     * 类型（0：评论，1：回复）
     * [whh]@return type 类型（0：评论，1：回复）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型（0：评论，1：回复）
     * @param type 类型（0：评论，1：回复）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 订单id
     * [whh]@return order_id 订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 订单id
     * @param orderId 订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 模特秀id
     * [whh]@return show_id 模特秀id
     */
    public Integer getShowId() {
        return showId;
    }

    /**
     * 模特秀id
     * @param showId 模特秀id
     */
    public void setShowId(Integer showId) {
        this.showId = showId;
    }

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
     * 上级id
     * [whh]@return parent_comment_id 上级id
     */
    public Integer getParentCommentId() {
        return parentCommentId;
    }

    /**
     * 上级id
     * @param parentCommentId 上级id
     */
    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    /**
     * 标签
     * [whh]@return tags 标签
     */
    public String getTags() {
        return tags;
    }

    /**
     * 标签
     * @param tags 标签
     */
    public void setTags(String tags) {
        this.tags = tags;
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

    /**
     * 图片0
     * [whh]@return pic0_url 图片0
     */
    public String getPic0Url() {
        return pic0Url;
    }

    /**
     * 图片0
     * @param pic0Url 图片0
     */
    public void setPic0Url(String pic0Url) {
        this.pic0Url = pic0Url;
    }

    /**
     * 图片1
     * [whh]@return pic1_url 图片1
     */
    public String getPic1Url() {
        return pic1Url;
    }

    /**
     * 图片1
     * @param pic1Url 图片1
     */
    public void setPic1Url(String pic1Url) {
        this.pic1Url = pic1Url;
    }

    /**
     * 图片2
     * [whh]@return pic2_url 图片2
     */
    public String getPic2Url() {
        return pic2Url;
    }

    /**
     * 图片2
     * @param pic2Url 图片2
     */
    public void setPic2Url(String pic2Url) {
        this.pic2Url = pic2Url;
    }

    /**
     * 图片3
     * [whh]@return pic3_url 图片3
     */
    public String getPic3Url() {
        return pic3Url;
    }

    /**
     * 图片3
     * @param pic3Url 图片3
     */
    public void setPic3Url(String pic3Url) {
        this.pic3Url = pic3Url;
    }

    /**
     * 图片4
     * [whh]@return pic4_url 图片4
     */
    public String getPic4Url() {
        return pic4Url;
    }

    /**
     * 图片4
     * @param pic4Url 图片4
     */
    public void setPic4Url(String pic4Url) {
        this.pic4Url = pic4Url;
    }

    /**
     * 视频0
     * [whh]@return video0_url 视频0
     */
    public String getVideo0Url() {
        return video0Url;
    }

    /**
     * 视频0
     * @param video0Url 视频0
     */
    public void setVideo0Url(String video0Url) {
        this.video0Url = video0Url;
    }

    public String getAuditDescription() {
        return auditDescription;
    }

    public void setAuditDescription(String auditDescription) {
        this.auditDescription = auditDescription;
    }
}
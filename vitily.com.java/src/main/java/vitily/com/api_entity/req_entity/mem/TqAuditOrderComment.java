package vitily.com.api_entity.req_entity.mem;

import vitily.com.annotation.RequireValidator;

/**
 * creator : whh-lether
 * date    : 2018/12/26 11:29
 * desc    :
 **/
public class TqAuditOrderComment extends TqMemBase {
    /**
     * 评论id
     */
    @RequireValidator
    private Integer orderCommentId;
    /**
     * 审核结果
     */
    @RequireValidator
    private Integer result;
    /**
     * 审核描述
     */
    private String auditDescription;

    public Integer getOrderCommentId() {
        return orderCommentId;
    }

    public void setOrderCommentId(Integer orderCommentId) {
        this.orderCommentId = orderCommentId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getAuditDescription() {
        return auditDescription;
    }

    public void setAuditDescription(String auditDescription) {
        this.auditDescription = auditDescription;
    }
}

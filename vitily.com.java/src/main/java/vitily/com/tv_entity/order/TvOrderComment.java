package vitily.com.tv_entity.order;

import vitily.com.consts.CommonAuditStateDesc;
import vitily.com.tb_entity.order.TbOrderComment;
import vitily.com.util.EnumHelperUtil;

public class TvOrderComment extends TbOrderComment {
    /**
     * 评论商户 id
     */
    private Integer showOwnerMemberId;

    public Integer getShowOwnerMemberId() {
        return showOwnerMemberId;
    }

    public void setShowOwnerMemberId(Integer showOwnerMemberId) {
        this.showOwnerMemberId = showOwnerMemberId;
    }
    protected String stateDesc;
    @Override
    public String getStateDesc(){
        this.stateDesc = EnumHelperUtil.getEnumWrapDescByValue(CommonAuditStateDesc.class, this.getState());
        return this.stateDesc;
    }
}
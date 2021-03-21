package vitily.com.ts_entity.order;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.order.TbOrderComment;

public class TsOrderComment extends BaseSearch<TbOrderComment> {

    public TsOrderComment() {
        super( new TbOrderComment());
    }
    private Integer sellerMemberId;

    public Integer getSellerMemberId() {
        return sellerMemberId;
    }

    public void setSellerMemberId(Integer sellerMemberId) {
        this.sellerMemberId = sellerMemberId;
    }
}
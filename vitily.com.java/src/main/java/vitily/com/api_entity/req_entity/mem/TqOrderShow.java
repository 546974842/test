package vitily.com.api_entity.req_entity.mem;

import vitily.base.ts_entity.PageInfo;

public class TqOrderShow extends TqMemBase{
    /**
     * 订单状态：
     * 待审核(66,"待审核"),
     * 进行中(67,"进行中"),
     * 已结束(68,"已结束"),
     */
    private Integer state;
    private Integer dealStatus;
    private PageInfo pageInfo;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }
}

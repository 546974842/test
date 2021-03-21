package vitily.com.api_entity.req_entity.mem;

import vitily.base.ts_entity.PageInfo;

public class TqMemMsgList extends TqMemBase{
    private Integer state;
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
}

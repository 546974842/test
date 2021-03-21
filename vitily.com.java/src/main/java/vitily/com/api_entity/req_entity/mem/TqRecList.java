package vitily.com.api_entity.req_entity.mem;

import vitily.base.ts_entity.PageInfo;

public class TqRecList extends TqMemBase {
    private PageInfo pageInfo;
    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}

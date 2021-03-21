package vitily.com.api_entity.req_entity.mem;

import vitily.base.ts_entity.PageInfo;

/**
 * creator : whh-lether
 * date    : 2018/12/26 11:29
 * desc    :
 **/
public class TqOrderCommentList extends TqMemBase {
    private PageInfo pageInfo;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}

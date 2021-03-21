package vitily.com.api_entity.req_entity.mem;

import vitily.base.ts_entity.PageInfo;

/**
 * creator : whh-lether
 * date    : 2018/12/25 15:09
 * desc    : 我的体验组
 **/
public class TqMyExpericenGroup extends TqMemBase{
    private PageInfo pageInfo;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}

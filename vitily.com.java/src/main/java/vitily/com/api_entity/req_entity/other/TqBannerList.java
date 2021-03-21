package vitily.com.api_entity.req_entity.other;

import vitily.base.ts_entity.PageInfo;
import vitily.base.ts_entity.TqBase;
import vitily.com.annotation.RequireValidator;

public class TqBannerList extends TqBase{
    @RequireValidator
    private Integer pageType;
    private PageInfo pageInfo;

    public Integer getPageType() {
        return pageType;
    }

    public void setPageType(Integer pageType) {
        this.pageType = pageType;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}

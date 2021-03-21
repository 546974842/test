package vitily.com.api_entity.req_entity.mem;

import vitily.base.ts_entity.PageInfo;

/**
 * creator : whh-lether
 * date    : 2018/12/11 10:07
 * desc    :
 **/
public class TqWithdrawList extends TqMemBase{
    private String beginDate;
    private String endDate;
    private Integer state;
    private PageInfo pageInfo;

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

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

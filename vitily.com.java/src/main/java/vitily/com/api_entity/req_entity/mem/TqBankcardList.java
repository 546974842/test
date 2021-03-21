package vitily.com.api_entity.req_entity.mem;

import vitily.base.ts_entity.PageInfo;

/**
 * creator : whh-lether
 * date    : 2018/12/11 9:58
 * desc    :
 **/
public class TqBankcardList extends TqMemBase {
    private String number;
    private Integer state;
    private PageInfo pageInfo;
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

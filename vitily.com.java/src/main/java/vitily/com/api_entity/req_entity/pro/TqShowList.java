package vitily.com.api_entity.req_entity.pro;

import vitily.base.ts_entity.PageInfo;
import vitily.base.ts_entity.TqBase;

/**
 * creator : whh-lether
 * date    : 2018/12/27 11:23
 * desc    :
 **/
public class TqShowList extends TqBase{
    /**
     * 0:线下退货(产品寄回)，1：无需退货（产品赠送）
     */
    private Integer experiType;
    private String cateIds;
    private PageInfo pageInfo;
    public PageInfo getPageInfo() {
        return pageInfo;
    }
    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getExperiType() {
        return experiType;
    }

    public void setExperiType(Integer experiType) {
        this.experiType = experiType;
    }

    public String getCateIds() {
        return cateIds;
    }

    public void setCateIds(String cateIds) {
        this.cateIds = cateIds;
    }
}

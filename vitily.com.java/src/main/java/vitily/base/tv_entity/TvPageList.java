package vitily.base.tv_entity;

import vitily.base.ts_entity.PageInfo;

import java.io.Serializable;
import java.util.List;

public class TvPageList implements Serializable{
    PageInfo pageInfo;
    List<?> list;
    public PageInfo getPageInfo() {
        return pageInfo;
    }
    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
    public List <?> getList() {
        return list;
    }
    public void setList(List <?> list) {
        this.list = list;
    }
}

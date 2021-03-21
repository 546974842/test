package vitily.com.api_entity.req_entity.other;

import vitily.base.ts_entity.TqBase;
import vitily.com.annotation.RequireValidator;

/**
 * creator : whh-lether
 * date    : 2018/12/27 14:37
 * desc    :
 **/
public class TqSingleId extends TqBase{
    @RequireValidator
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

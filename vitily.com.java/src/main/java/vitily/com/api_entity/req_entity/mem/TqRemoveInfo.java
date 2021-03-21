package vitily.com.api_entity.req_entity.mem;

import vitily.com.annotation.RequireValidator;

public class TqRemoveInfo extends TqMemBase{
    @RequireValidator
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

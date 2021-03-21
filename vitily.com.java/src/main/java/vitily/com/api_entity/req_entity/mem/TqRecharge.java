package vitily.com.api_entity.req_entity.mem;

import vitily.com.annotation.RequireValidator;

public class TqRecharge extends TqMemBase{
    /**
     * 充值金额：单位：分
     */
    @RequireValidator
    private Long appCent;

    public Long getAppCent() {
        return appCent;
    }

    public void setAppCent(Long appCent) {
        this.appCent = appCent;
    }
}

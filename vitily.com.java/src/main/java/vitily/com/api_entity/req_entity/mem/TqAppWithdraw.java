package vitily.com.api_entity.req_entity.mem;

import vitily.com.annotation.RequireValidator;

/**
 * creator : whh-lether
 * date    : 2018/12/11 10:08
 * desc    :
 **/
public class TqAppWithdraw extends TqMemBase{

    @RequireValidator
    private Double appAmount;
    @RequireValidator
    private Integer bankcardId;
    @RequireValidator
    private String mode;

    public Double getAppAmount() {
        return appAmount;
    }

    public void setAppAmount(Double appAmount) {
        this.appAmount = appAmount;
    }

    public Integer getBankcardId() {
        return bankcardId;
    }

    public void setBankcardId(Integer bankcardId) {
        this.bankcardId = bankcardId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}

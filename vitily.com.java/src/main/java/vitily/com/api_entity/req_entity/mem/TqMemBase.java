package vitily.com.api_entity.req_entity.mem;

import vitily.base.ts_entity.TqBase;
import vitily.com.annotation.RegexValidator;
import vitily.com.annotation.RequireValidator;
import vitily.com.util.Validator;

public class TqMemBase extends TqBase{
    /**
     * 用户token token
     */
    @RequireValidator
    @RegexValidator(regexStr = Validator.STR_MAX_LENGTH64)
    private String memToken;
    private Integer memberId;
    public String getMemToken() {
        return memToken;
    }
    public void setMemToken(String memToken) {
        this.memToken = memToken;
    }

    public Integer getMemberId() {
        return memberId;
    }
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}

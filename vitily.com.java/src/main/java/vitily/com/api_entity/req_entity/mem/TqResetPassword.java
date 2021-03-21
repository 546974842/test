package vitily.com.api_entity.req_entity.mem;

import vitily.base.ts_entity.TqBase;
import vitily.com.annotation.RequireValidator;

public class TqResetPassword extends TqBase {
    @RequireValidator
    private String phone;
    @RequireValidator
    private String phoneCode;
    @RequireValidator
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

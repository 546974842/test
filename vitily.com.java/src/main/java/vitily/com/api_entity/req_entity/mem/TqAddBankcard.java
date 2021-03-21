package vitily.com.api_entity.req_entity.mem;

import vitily.com.annotation.RequireValidator;

/**
 * creator : whh-lether
 * date    : 2018/12/11 9:59
 * desc    :
 **/
public class TqAddBankcard extends TqMemBase{
    @RequireValidator
    private Integer bankId;
    @RequireValidator
    private String branch;
    @RequireValidator
    private String number;
    @RequireValidator
    private String province;
    @RequireValidator
    private String city;
    @RequireValidator
    private String area;

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

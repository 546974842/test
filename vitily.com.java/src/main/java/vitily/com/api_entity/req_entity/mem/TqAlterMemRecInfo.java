package vitily.com.api_entity.req_entity.mem;

import vitily.com.annotation.RequireValidator;

public class TqAlterMemRecInfo extends TqMemBase{
    /**
     * id:修改的时候必填
     */
    private Integer id;
    /**
     * 收货人
     */
    @RequireValidator
    private String receiver;

    /**
     * 国家
     */
    @RequireValidator
    private String country;

    /**
     * 省
     */
    @RequireValidator
    private String province;

    /**
     * 市
     */
    @RequireValidator
    private String city;

    /**
     * 区
     */
    @RequireValidator
    private String area;

    /**
     * 详细地址
     */
    @RequireValidator
    private String address;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 手机
     */
    @RequireValidator
    private String phone;

    /**
     * 固话
     */
    private String call;

    /**
     * 是否默认
     */
    @RequireValidator
    private Integer isDefault;

    /**
     * 收货人
     * [whh]@return receiver 收货人
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 收货人
     * @param receiver 收货人
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 国家
     * [whh]@return country 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 国家
     * @param country 国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 省
     * [whh]@return province 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 市
     * [whh]@return city 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 区
     * [whh]@return area 区
     */
    public String getArea() {
        return area;
    }

    /**
     * 区
     * @param area 区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 详细地址
     * [whh]@return address 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 详细地址
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 邮编
     * [whh]@return post_code 邮编
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 邮编
     * @param postCode 邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * 手机
     * [whh]@return phone 手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机
     * @param phone 手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 固话
     * [whh]@return call 固话
     */
    public String getCall() {
        return call;
    }

    /**
     * 固话
     * @param call 固话
     */
    public void setCall(String call) {
        this.call = call;
    }

    /**
     * 是否默认
     * [whh]@return is_default 是否默认
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * 是否默认
     * @param isDefault 是否默认
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

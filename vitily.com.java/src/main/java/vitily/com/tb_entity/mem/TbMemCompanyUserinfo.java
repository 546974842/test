package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_mem_company_userinfo表的实体类
 * @version
 * @author:  whh
 * @创建时间: 2018-02-24
 */
public class TbMemCompanyUserinfo extends BaseEntity {
    /**
     * 会员Id
     */
    private Integer memberId;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 固话
     */
    private String call;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 会员Id
     * [whh]@return member_id 会员Id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 会员Id
     * @param memberId 会员Id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 企业名称
     * [whh]@return company_name 企业名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 企业名称
     * @param companyName 企业名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
}
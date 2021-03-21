package vitily.com.tb_entity.mem;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import vitily.base.tb_entity.BaseEntity;

import java.util.Date;

/**
 * 描述:tb_mem_personal_userinfo表的实体类
 * @version
 * @author:  whh
 * @创建时间: 2018-02-24
 */
public class TbMemPersonalUserinfo extends BaseEntity {
    /**
     * 会员Id
     */
    private Integer memberId;

    /**
     * 生日
     */
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 证件号码
     */
    private String idNo;

    /**
     * 手机号码
     */
    private String phone;

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
     * 生日
     * [whh]@return birth_date 生日
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 生日
     * @param birthDate 生日
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 性别
     * [whh]@return gender 性别
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别
     * @param gender 性别
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 真实姓名
     * [whh]@return real_name 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真实姓名
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 证件类型
     * [whh]@return id_type 证件类型
     */
    public Integer getIdType() {
        return idType;
    }

    /**
     * 证件类型
     * @param idType 证件类型
     */
    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    /**
     * 证件号码
     * [whh]@return id_no 证件号码
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * 证件号码
     * @param idNo 证件号码
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * 手机号码
     * [whh]@return phone 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
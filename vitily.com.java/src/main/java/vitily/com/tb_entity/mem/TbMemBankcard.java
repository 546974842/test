package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_mem_bankcard表的实体类
 * @version
 * @author:  Java
 * @创建时间: 2018-01-24
 */
public class TbMemBankcard extends BaseEntity {
    /**
     * 会员ID
     */
    private Integer memberId;

    /**
     * 银行卡表ID
     */
    private Integer bankId;

    /**
     * 开户行地址
     */
    private String branch;

    /**
     * 银行卡号
     */
    private String number;

    /**
     * 备注
     */
    private String memo;

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
     * 会员ID
     * [whh]@return member_id 会员ID
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 会员ID
     * @param memberId 会员ID
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 银行卡表ID
     * [whh]@return bank_id 银行卡表ID
     */
    public Integer getBankId() {
        return bankId;
    }

    /**
     * 银行卡表ID
     * @param bankId 银行卡表ID
     */
    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    /**
     * 开户行地址
     * [whh]@return branch 开户行地址
     */
    public String getBranch() {
        return branch;
    }

    /**
     * 开户行地址
     * @param branch 开户行地址
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * 银行卡号
     * [whh]@return number 银行卡号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 银行卡号
     * @param number 银行卡号
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 备注
     * [whh]@return memo 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 备注
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
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
}
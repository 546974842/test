package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_mem_credit_history表的实体类
 * @version
 * @author:  whh
 * @创建时间: 2018-03-07
 */
public class TbMemCreditHistory extends BaseEntity {
    /**
     * 会员Id
     */
    private Integer memberId;

    /**
     * 记录类型
     */
    private Integer recordType;

    /**
     * 记录值
     */
    private Integer creditValue;

    /**
     * 结余
     */
    private Integer balance;

    /**
     * 备注
     */
    private String memo;

    /**
     * 相关凭证链接(一般是图片/视频/录音等多媒体)
     */
    private String relationLinks;

    /**
     * 后台审核用户
     */
    private Integer admUserId;
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
     * 记录类型
     * [whh]@return record_type 记录类型
     */
    public Integer getRecordType() {
        return recordType;
    }

    /**
     * 记录类型
     * @param recordType 记录类型
     */
    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    /**
     * 记录值
     * [whh]@return credit_value 记录值
     */
    public Integer getCreditValue() {
        return creditValue;
    }

    /**
     * 记录值
     * @param creditValue 记录值
     */
    public void setCreditValue(Integer creditValue) {
        this.creditValue = creditValue;
    }

    /**
     * 结余
     * [whh]@return balance 结余
     */
    public Integer getBalance() {
        return balance;
    }

    /**
     * 结余
     * @param balance 结余
     */
    public void setBalance(Integer balance) {
        this.balance = balance;
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
     * 相关凭证链接(一般是图片/视频/录音等多媒体)
     * [whh]@return relation_links 相关凭证链接(一般是图片/视频/录音等多媒体)
     */
    public String getRelationLinks() {
        return relationLinks;
    }

    /**
     * 相关凭证链接(一般是图片/视频/录音等多媒体)
     * @param relationLinks 相关凭证链接(一般是图片/视频/录音等多媒体)
     */
    public void setRelationLinks(String relationLinks) {
        this.relationLinks = relationLinks;
    }

    /**
     * 后台审核用户
     * [whh]@return adm_user_id 后台审核用户
     */
    public Integer getAdmUserId() {
        return admUserId;
    }

    /**
     * 后台审核用户
     * @param admUserId 后台审核用户
     */
    public void setAdmUserId(Integer admUserId) {
        this.admUserId = admUserId;
    }
}
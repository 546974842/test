package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_mem_creditfile_certify_log表的实体类
 * @version
 * @author:  whh
 * @创建时间: 2018-03-06
 */
public class TbMemCreditfileCertifyLog extends BaseEntity {
    /**
     * 会员Id
     */
    private Integer memberId;

    /**
     * 验证状态
     */
    private Integer creditfileState;

    /**
     * 验证类型
     */
    private Integer creditfileType;

    /**
     * 相关凭证链接(一般是图片/视频/录音等多媒体)
     */
    private String relationLinks;

    /**
     * 描述
     */
    private String description;

    /**
     * 后台操作用户
     */
    private Integer admUserId;

    /**
     * 备注
     */
    private String memo;

    /**
     * ip
     */
    private String ip;
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
     * 验证状态
     * [whh]@return creditfile_state 验证状态
     */
    public Integer getCreditfileState() {
        return creditfileState;
    }

    /**
     * 验证状态
     * @param creditfileState 验证状态
     */
    public void setCreditfileState(Integer creditfileState) {
        this.creditfileState = creditfileState;
    }

    /**
     * 验证类型
     * [whh]@return creditfile_type 验证类型
     */
    public Integer getCreditfileType() {
        return creditfileType;
    }

    /**
     * 验证类型
     * @param creditfileType 验证类型
     */
    public void setCreditfileType(Integer creditfileType) {
        this.creditfileType = creditfileType;
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
     * 描述
     * [whh]@return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 后台操作用户
     * [whh]@return adm_user_id 后台操作用户
     */
    public Integer getAdmUserId() {
        return admUserId;
    }

    /**
     * 后台操作用户
     * @param admUserId 后台操作用户
     */
    public void setAdmUserId(Integer admUserId) {
        this.admUserId = admUserId;
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
     * ip
     * [whh]@return ip ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * ip
     * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
}
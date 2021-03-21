package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_mem_ext_attr表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbMemExtAttr extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 会员Id
     */
    private Integer memberId;

    /**
     * 支付salt
     */
    private String paySalt;

    /**
     * 支付密码
     */
    private String payPassword;

    /**
     * qq token
     */
    private String qqToken;

    /**
     * 新浪token
     */
    private String sinaToken;

    /**
     * 微信token
     */
    private String wechatToken;

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
     * 支付salt
     * [whh]@return pay_salt 支付salt
     */
    public String getPaySalt() {
        return paySalt;
    }

    /**
     * 支付salt
     * @param paySalt 支付salt
     */
    public void setPaySalt(String paySalt) {
        this.paySalt = paySalt;
    }

    /**
     * 支付密码
     * [whh]@return pay_password 支付密码
     */
    public String getPayPassword() {
        return payPassword;
    }

    /**
     * 支付密码
     * @param payPassword 支付密码
     */
    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    /**
     * qq token
     * [whh]@return qq_token qq token
     */
    public String getQqToken() {
        return qqToken;
    }

    /**
     * qq token
     * @param qqToken qq token
     */
    public void setQqToken(String qqToken) {
        this.qqToken = qqToken;
    }

    /**
     * 新浪token
     * [whh]@return sina_token 新浪token
     */
    public String getSinaToken() {
        return sinaToken;
    }

    /**
     * 新浪token
     * @param sinaToken 新浪token
     */
    public void setSinaToken(String sinaToken) {
        this.sinaToken = sinaToken;
    }

    /**
     * 微信token
     * [whh]@return wechat_token 微信token
     */
    public String getWechatToken() {
        return wechatToken;
    }

    /**
     * 微信token
     * @param wechatToken 微信token
     */
    public void setWechatToken(String wechatToken) {
        this.wechatToken = wechatToken;
    }
}
package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:个人用户信息档案表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-12-09
 */
public class TbMemPersonalCertifyinfo extends BaseEntity {
    /**
     * 会员Id
     */
    private Integer memberId;

    /**
     * 身份证号码
     */
    private String idNumber;

    /**
     * 身份证信息urls
     */
    private String idNumberCertifyUrls;

    /**
     * 身份证验证状态
     */
    private Integer idNumberCertifyState;

    /**
     * 淘宝号码
     */
    private String tbNumber;

    /**
     * 淘宝信息urls
     */
    private String tbNumberCertifyUrls;

    /**
     * 淘宝验证状态
     */
    private Integer tbNumberCertifyState;

    /**
     * 支付宝号码
     */
    private String zfbNumber;

    /**
     * 支付宝信息urls
     */
    private String zfbNumberCertifyUrls;

    /**
     * 支付宝验证状态
     */
    private Integer zfbNumberCertifyState;

    /**
     * 支付宝号码
     */
    private String bankcardNumber;

    /**
     * 支付宝信息urls
     */
    private String bankcardNumberCertifyUrls;

    /**
     * 支付宝验证状态
     */
    private Integer bankcardNumberCertifyState;

    /**
     * 微信号码
     */
    private String wxNumber;

    /**
     * 微信信息urls
     */
    private String wxNumberCertifyUrls;

    /**
     * 微信验证状态
     */
    private Integer wxNumberCertifyState;

    /**
     * qq号码
     */
    private String qqNumber;

    /**
     * qq信息urls
     */
    private String qqNumberCertifyUrls;

    /**
     * qq验证状态
     */
    private Integer qqNumberCertifyState;

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
     * 身份证号码
     * [whh]@return id_number 身份证号码
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 身份证号码
     * @param idNumber 身份证号码
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * 身份证信息urls
     * [whh]@return id_number_certify_urls 身份证信息urls
     */
    public String getIdNumberCertifyUrls() {
        return idNumberCertifyUrls;
    }

    /**
     * 身份证信息urls
     * @param idNumberCertifyUrls 身份证信息urls
     */
    public void setIdNumberCertifyUrls(String idNumberCertifyUrls) {
        this.idNumberCertifyUrls = idNumberCertifyUrls;
    }

    /**
     * 身份证验证状态
     * [whh]@return id_number_certify_state 身份证验证状态
     */
    public Integer getIdNumberCertifyState() {
        return idNumberCertifyState;
    }

    /**
     * 身份证验证状态
     * @param idNumberCertifyState 身份证验证状态
     */
    public void setIdNumberCertifyState(Integer idNumberCertifyState) {
        this.idNumberCertifyState = idNumberCertifyState;
    }

    /**
     * 淘宝号码
     * [whh]@return tb_number 淘宝号码
     */
    public String getTbNumber() {
        return tbNumber;
    }

    /**
     * 淘宝号码
     * @param tbNumber 淘宝号码
     */
    public void setTbNumber(String tbNumber) {
        this.tbNumber = tbNumber;
    }

    /**
     * 淘宝信息urls
     * [whh]@return tb_number_certify_urls 淘宝信息urls
     */
    public String getTbNumberCertifyUrls() {
        return tbNumberCertifyUrls;
    }

    /**
     * 淘宝信息urls
     * @param tbNumberCertifyUrls 淘宝信息urls
     */
    public void setTbNumberCertifyUrls(String tbNumberCertifyUrls) {
        this.tbNumberCertifyUrls = tbNumberCertifyUrls;
    }

    /**
     * 淘宝验证状态
     * [whh]@return tb_number_certify_state 淘宝验证状态
     */
    public Integer getTbNumberCertifyState() {
        return tbNumberCertifyState;
    }

    /**
     * 淘宝验证状态
     * @param tbNumberCertifyState 淘宝验证状态
     */
    public void setTbNumberCertifyState(Integer tbNumberCertifyState) {
        this.tbNumberCertifyState = tbNumberCertifyState;
    }

    /**
     * 支付宝号码
     * [whh]@return zfb_number 支付宝号码
     */
    public String getZfbNumber() {
        return zfbNumber;
    }

    /**
     * 支付宝号码
     * @param zfbNumber 支付宝号码
     */
    public void setZfbNumber(String zfbNumber) {
        this.zfbNumber = zfbNumber;
    }

    /**
     * 支付宝信息urls
     * [whh]@return zfb_number_certify_urls 支付宝信息urls
     */
    public String getZfbNumberCertifyUrls() {
        return zfbNumberCertifyUrls;
    }

    /**
     * 支付宝信息urls
     * @param zfbNumberCertifyUrls 支付宝信息urls
     */
    public void setZfbNumberCertifyUrls(String zfbNumberCertifyUrls) {
        this.zfbNumberCertifyUrls = zfbNumberCertifyUrls;
    }

    /**
     * 支付宝验证状态
     * [whh]@return zfb_number_certify_state 支付宝验证状态
     */
    public Integer getZfbNumberCertifyState() {
        return zfbNumberCertifyState;
    }

    /**
     * 支付宝验证状态
     * @param zfbNumberCertifyState 支付宝验证状态
     */
    public void setZfbNumberCertifyState(Integer zfbNumberCertifyState) {
        this.zfbNumberCertifyState = zfbNumberCertifyState;
    }

    /**
     * 支付宝号码
     * [whh]@return bankcard_number 支付宝号码
     */
    public String getBankcardNumber() {
        return bankcardNumber;
    }

    /**
     * 支付宝号码
     * @param bankcardNumber 支付宝号码
     */
    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    /**
     * 支付宝信息urls
     * [whh]@return bankcard_number_certify_urls 支付宝信息urls
     */
    public String getBankcardNumberCertifyUrls() {
        return bankcardNumberCertifyUrls;
    }

    /**
     * 支付宝信息urls
     * @param bankcardNumberCertifyUrls 支付宝信息urls
     */
    public void setBankcardNumberCertifyUrls(String bankcardNumberCertifyUrls) {
        this.bankcardNumberCertifyUrls = bankcardNumberCertifyUrls;
    }

    /**
     * 支付宝验证状态
     * [whh]@return bankcard_number_certify_state 支付宝验证状态
     */
    public Integer getBankcardNumberCertifyState() {
        return bankcardNumberCertifyState;
    }

    /**
     * 支付宝验证状态
     * @param bankcardNumberCertifyState 支付宝验证状态
     */
    public void setBankcardNumberCertifyState(Integer bankcardNumberCertifyState) {
        this.bankcardNumberCertifyState = bankcardNumberCertifyState;
    }

    /**
     * 微信号码
     * [whh]@return wx_number 微信号码
     */
    public String getWxNumber() {
        return wxNumber;
    }

    /**
     * 微信号码
     * @param wxNumber 微信号码
     */
    public void setWxNumber(String wxNumber) {
        this.wxNumber = wxNumber;
    }

    /**
     * 微信信息urls
     * [whh]@return wx_number_certify_urls 微信信息urls
     */
    public String getWxNumberCertifyUrls() {
        return wxNumberCertifyUrls;
    }

    /**
     * 微信信息urls
     * @param wxNumberCertifyUrls 微信信息urls
     */
    public void setWxNumberCertifyUrls(String wxNumberCertifyUrls) {
        this.wxNumberCertifyUrls = wxNumberCertifyUrls;
    }

    /**
     * 微信验证状态
     * [whh]@return wx_number_certify_state 微信验证状态
     */
    public Integer getWxNumberCertifyState() {
        return wxNumberCertifyState;
    }

    /**
     * 微信验证状态
     * @param wxNumberCertifyState 微信验证状态
     */
    public void setWxNumberCertifyState(Integer wxNumberCertifyState) {
        this.wxNumberCertifyState = wxNumberCertifyState;
    }

    /**
     * qq号码
     * [whh]@return qq_number qq号码
     */
    public String getQqNumber() {
        return qqNumber;
    }

    /**
     * qq号码
     * @param qqNumber qq号码
     */
    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    /**
     * qq信息urls
     * [whh]@return qq_number_certify_urls qq信息urls
     */
    public String getQqNumberCertifyUrls() {
        return qqNumberCertifyUrls;
    }

    /**
     * qq信息urls
     * @param qqNumberCertifyUrls qq信息urls
     */
    public void setQqNumberCertifyUrls(String qqNumberCertifyUrls) {
        this.qqNumberCertifyUrls = qqNumberCertifyUrls;
    }

    /**
     * qq验证状态
     * [whh]@return qq_number_certify_state qq验证状态
     */
    public Integer getQqNumberCertifyState() {
        return qqNumberCertifyState;
    }

    /**
     * qq验证状态
     * @param qqNumberCertifyState qq验证状态
     */
    public void setQqNumberCertifyState(Integer qqNumberCertifyState) {
        this.qqNumberCertifyState = qqNumberCertifyState;
    }
}
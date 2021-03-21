package vitily.com.tb_entity.mem;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:会员打款记录表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-06-27
 */
public class TbMemMoneyTransfer extends BaseEntity {
    /**
     * 会员ID
     */
    private Integer memberId;

    /**
     * 账户姓名
     */
    private String accountName;

    /**
     * 联系电话
     */
    private String call;

    /**
     * 打款金额
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long amount;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 打款截图地址
     */
    private String picUrl;

    /**
     * 后台审核用户
     */
    private Integer auditAdmUserId;
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
     * 账户姓名
     * [whh]@return account_name 账户姓名
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 账户姓名
     * @param accountName 账户姓名
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * 联系电话
     * [whh]@return call 联系电话
     */
    public String getCall() {
        return call;
    }

    /**
     * 联系电话
     * @param call 联系电话
     */
    public void setCall(String call) {
        this.call = call;
    }

    /**
     * 打款金额
     * [whh]@return amount 打款金额
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 打款金额
     * @param amount 打款金额
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 订单号
     * [whh]@return order_no 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单号
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 打款截图地址
     * [whh]@return pic_url 打款截图地址
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 打款截图地址
     * @param picUrl 打款截图地址
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 后台审核用户
     * [whh]@return audit_adm_user_id 后台审核用户
     */
    public Integer getAuditAdmUserId() {
        return auditAdmUserId;
    }

    /**
     * 后台审核用户
     * @param auditAdmUserId 后台审核用户
     */
    public void setAuditAdmUserId(Integer auditAdmUserId) {
        this.auditAdmUserId = auditAdmUserId;
    }
}
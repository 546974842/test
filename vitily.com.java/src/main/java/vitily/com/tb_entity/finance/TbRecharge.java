package vitily.com.tb_entity.finance;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:充值表表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-03-24
 */
public class TbRecharge extends BaseEntity {
    /**
     * 充值会员id
     */
    private Integer memberId;

    /**
     * 充值金额(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long applyAmount;

    /**
     * 充值到账金额(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long arrivedAmount;

    /**
     * 充值方式
     */
    private String mode;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 充值平台
     */
    private Integer platform;

    /**
     * 备注
     */
    private String memo;

    /**
     * 后台充值申请用户
     */
    private Integer applyAdmUserId;

    /**
     * 后台充值审核用户
     */
    private Integer auditAdmUserId;
    /**
     * 充值会员id
     * [whh]@return member_id 充值会员id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 充值会员id
     * @param memberId 充值会员id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 充值金额(单位：分)
     * [whh]@return apply_amount 充值金额(单位：分)
     */
    public Long getApplyAmount() {
        return applyAmount;
    }

    /**
     * 充值金额(单位：分)
     * @param applyAmount 充值金额(单位：分)
     */
    public void setApplyAmount(Long applyAmount) {
        this.applyAmount = applyAmount;
    }

    /**
     * 充值到账金额(单位：分)
     * [whh]@return arrived_amount 充值到账金额(单位：分)
     */
    public Long getArrivedAmount() {
        return arrivedAmount;
    }

    /**
     * 充值到账金额(单位：分)
     * @param arrivedAmount 充值到账金额(单位：分)
     */
    public void setArrivedAmount(Long arrivedAmount) {
        this.arrivedAmount = arrivedAmount;
    }

    /**
     * 充值方式
     * [whh]@return mode 充值方式
     */
    public String getMode() {
        return mode;
    }

    /**
     * 充值方式
     * @param mode 充值方式
     */
    public void setMode(String mode) {
        this.mode = mode;
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
     * 充值平台
     * [whh]@return platform 充值平台
     */
    public Integer getPlatform() {
        return platform;
    }

    /**
     * 充值平台
     * @param platform 充值平台
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
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
     * 后台充值申请用户
     * [whh]@return apply_adm_user_id 后台充值申请用户
     */
    public Integer getApplyAdmUserId() {
        return applyAdmUserId;
    }

    /**
     * 后台充值申请用户
     * @param applyAdmUserId 后台充值申请用户
     */
    public void setApplyAdmUserId(Integer applyAdmUserId) {
        this.applyAdmUserId = applyAdmUserId;
    }

    /**
     * 后台充值审核用户
     * [whh]@return audit_adm_user_id 后台充值审核用户
     */
    public Integer getAuditAdmUserId() {
        return auditAdmUserId;
    }

    /**
     * 后台充值审核用户
     * @param auditAdmUserId 后台充值审核用户
     */
    public void setAuditAdmUserId(Integer auditAdmUserId) {
        this.auditAdmUserId = auditAdmUserId;
    }
}
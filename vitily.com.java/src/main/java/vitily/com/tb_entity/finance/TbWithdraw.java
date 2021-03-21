package vitily.com.tb_entity.finance;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:提现表表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-03-24
 */
public class TbWithdraw extends BaseEntity {
    /**
     * 充值会员id
     */
    private Integer memberId;

    /**
     * 提现模式
     */
    private String mode;

    /**
     * 申请提现金额（包含手续费）(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long applyAmount;

    /**
     * 预计手续费(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long expectedFee;

    /**
     * 实际手续费(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long actualFee;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 提现平台
     */
    private Integer platform;

    /**
     * 到账银行卡ID
     */
    private Integer bankcardId;

    /**
     * 备注
     */
    private String memo;

    /**
     * 后台提现申请用户
     */
    private Integer applyAdmUserId;

    /**
     * 提现审核用户
     */
    private Integer auditAdmUserId;
    /**
     * 提现会员id
     * [whh]@return member_id 提现会员id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 提现会员id
     * @param memberId 提现会员id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 提现模式
     * [whh]@return mode 提现模式
     */
    public String getMode() {
        return mode;
    }

    /**
     * 提现模式
     * @param mode 提现模式
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * 申请提现金额（包含手续费）(单位：分)
     * [whh]@return apply_amount 申请提现金额（包含手续费）(单位：分)
     */
    public Long getApplyAmount() {
        return applyAmount;
    }

    /**
     * 申请提现金额（包含手续费）(单位：分)
     * @param applyAmount 申请提现金额（包含手续费）(单位：分)
     */
    public void setApplyAmount(Long applyAmount) {
        this.applyAmount = applyAmount;
    }

    /**
     * 预计手续费(单位：分)
     * [whh]@return expected_fee 预计手续费(单位：分)
     */
    public Long getExpectedFee() {
        return expectedFee;
    }

    /**
     * 预计手续费(单位：分)
     * @param expectedFee 预计手续费(单位：分)
     */
    public void setExpectedFee(Long expectedFee) {
        this.expectedFee = expectedFee;
    }

    /**
     * 实际手续费(单位：分)
     * [whh]@return actual_fee 实际手续费(单位：分)
     */
    public Long getActualFee() {
        return actualFee;
    }

    /**
     * 实际手续费(单位：分)
     * @param actualFee 实际手续费(单位：分)
     */
    public void setActualFee(Long actualFee) {
        this.actualFee = actualFee;
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
     * 提现平台
     * [whh]@return platform 提现平台
     */
    public Integer getPlatform() {
        return platform;
    }

    /**
     * 提现平台
     * @param platform 提现平台
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    /**
     * 到账银行卡ID
     * [whh]@return bankcard_id 到账银行卡ID
     */
    public Integer getBankcardId() {
        return bankcardId;
    }

    /**
     * 到账银行卡ID
     * @param bankcardId 到账银行卡ID
     */
    public void setBankcardId(Integer bankcardId) {
        this.bankcardId = bankcardId;
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
     * 后台提现申请用户
     * [whh]@return apply_adm_user_id 后台提现申请用户
     */
    public Integer getApplyAdmUserId() {
        return applyAdmUserId;
    }

    /**
     * 后台提现申请用户
     * @param applyAdmUserId 后台提现申请用户
     */
    public void setApplyAdmUserId(Integer applyAdmUserId) {
        this.applyAdmUserId = applyAdmUserId;
    }

    /**
     * 提现审核用户
     * [whh]@return audit_adm_user_id 提现审核用户
     */
    public Integer getAuditAdmUserId() {
        return auditAdmUserId;
    }

    /**
     * 提现审核用户
     * @param auditAdmUserId 提现审核用户
     */
    public void setAuditAdmUserId(Integer auditAdmUserId) {
        this.auditAdmUserId = auditAdmUserId;
    }
}
package vitily.com.tb_entity.mem;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:佣金流水表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-12-09
 */
public class TbMemCommissionFlow extends BaseEntity {

    /**
     * 入账会员ID
     */
    private Integer memberId;

    /**
     * 操作金额(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long amount;

    /**
     * 可用结余(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long availableBalance;

    /**
     * 冻结结余(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long freezeBalance;

    /**
     * 资金备注
     */
    private String memo;

    /**
     * 资金类型
     */
    private Integer fundsType;

    /**
     * 关联表ID
     */
    private Integer relationId;

    /**
     * 操作描述
     */
    private String remark;

    /**
     * 0:收入，1:支出,2预授权收入3预授权支出
     */
    private Integer direction;

    /**
     * 入账会员ID
     * [whh]@return member_id 入账会员ID
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 入账会员ID
     * @param memberId 入账会员ID
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 操作金额(单位：分)
     * [whh]@return amount 操作金额(单位：分)
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 操作金额(单位：分)
     * @param amount 操作金额(单位：分)
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 可用结余(单位：分)
     * [whh]@return available_balance 可用结余(单位：分)
     */
    public Long getAvailableBalance() {
        return availableBalance;
    }

    /**
     * 可用结余(单位：分)
     * @param availableBalance 可用结余(单位：分)
     */
    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * 冻结结余(单位：分)
     * [whh]@return freeze_balance 冻结结余(单位：分)
     */
    public Long getFreezeBalance() {
        return freezeBalance;
    }

    /**
     * 冻结结余(单位：分)
     * @param freezeBalance 冻结结余(单位：分)
     */
    public void setFreezeBalance(Long freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    /**
     * 资金备注
     * [whh]@return memo 资金备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 资金备注
     * @param memo 资金备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 资金类型
     * [whh]@return funds_type 资金类型
     */
    public Integer getFundsType() {
        return fundsType;
    }

    /**
     * 资金类型
     * @param fundsType 资金类型
     */
    public void setFundsType(Integer fundsType) {
        this.fundsType = fundsType;
    }

    /**
     * 关联表ID
     * [whh]@return relation_id 关联表ID
     */
    public Integer getRelationId() {
        return relationId;
    }

    /**
     * 关联表ID
     * @param relationId 关联表ID
     */
    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    /**
     * 操作描述
     * [whh]@return remark 操作描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 操作描述
     * @param remark 操作描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 0:收入，1:支出,2预授权收入3预授权支出
     * [whh]@return direction 0:收入，1:支出,2预授权收入3预授权支出
     */
    public Integer getDirection() {
        return direction;
    }

    /**
     * 0:收入，1:支出,2预授权收入3预授权支出
     * @param direction 0:收入，1:支出,2预授权收入3预授权支出
     */
    public void setDirection(Integer direction) {
        this.direction = direction;
    }
}
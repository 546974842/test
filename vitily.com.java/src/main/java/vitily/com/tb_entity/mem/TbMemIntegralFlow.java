package vitily.com.tb_entity.mem;

import java.util.Date;
import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:积分流水表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-12-09
 */
public class TbMemIntegralFlow extends BaseEntity {

    /**
     * 入账会员ID
     */
    private Integer memberId;

    /**
     * 操作积分
     */
    private Integer amount;

    /**
     * 可用结余
     */
    private Integer availableBalance;

    /**
     * 冻结结余
     */
    private Integer freezeBalance;

    /**
     * 积分备注
     */
    private String memo;

    /**
     * 积分类型
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
     * 操作积分
     * [whh]@return amount 操作积分
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 操作积分
     * @param amount 操作积分
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 可用结余
     * [whh]@return available_balance 可用结余
     */
    public Integer getAvailableBalance() {
        return availableBalance;
    }

    /**
     * 可用结余
     * @param availableBalance 可用结余
     */
    public void setAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * 冻结结余
     * [whh]@return freeze_balance 冻结结余
     */
    public Integer getFreezeBalance() {
        return freezeBalance;
    }

    /**
     * 冻结结余
     * @param freezeBalance 冻结结余
     */
    public void setFreezeBalance(Integer freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    /**
     * 积分备注
     * [whh]@return memo 积分备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 积分备注
     * @param memo 积分备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 积分类型
     * [whh]@return funds_type 积分类型
     */
    public Integer getFundsType() {
        return fundsType;
    }

    /**
     * 积分类型
     * @param fundsType 积分类型
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
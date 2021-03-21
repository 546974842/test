package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:积分记录表 表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-12-09
 */
public class TbMemIntegral extends BaseEntity {

    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 可用结余
     */
    private Integer availableBalance;

    /**
     * 冻结结余
     */
    private Integer freezeBalance;
    /**
     * 会员id
     * [whh]@return member_id 会员id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 会员id
     * @param memberId 会员id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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
}
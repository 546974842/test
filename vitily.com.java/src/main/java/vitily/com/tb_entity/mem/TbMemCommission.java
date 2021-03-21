package vitily.com.tb_entity.mem;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:佣金记录表 表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-12-09
 */
public class TbMemCommission extends BaseEntity {

    /**
     * 会员id
     */
    private Integer memberId;

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
}
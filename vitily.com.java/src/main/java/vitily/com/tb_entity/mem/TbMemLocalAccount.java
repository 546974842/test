package vitily.com.tb_entity.mem;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

/**
 * 描述:会员本地账户表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-03-24
 */
public class TbMemLocalAccount extends BaseEntity {
    /**
     * 会员ID
     */
    private Integer memberId;

    /**
     * 冻结金额(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private long freezeAmount;

    /**
     * 可用金额(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private long availableAmount;

    /**
     * 版本号
     */
    private Integer version;
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
     * 冻结金额(单位：分)
     * [whh]@return freeze_amount 冻结金额(单位：分)
     */
    public long getFreezeAmount() {
        return freezeAmount;
    }

    /**
     * 冻结金额(单位：分)
     * @param freezeAmount 冻结金额(单位：分)
     */
    public void setFreezeAmount(long freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    /**
     * 可用金额(单位：分)
     * [whh]@return available_amount 可用金额(单位：分)
     */
    public long getAvailableAmount() {
        return availableAmount;
    }

    /**
     * 可用金额(单位：分)
     * @param availableAmount 可用金额(单位：分)
     */
    public void setAvailableAmount(long availableAmount) {
        this.availableAmount = availableAmount;
    }

    /**
     * 版本号
     * [whh]@return version 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 版本号
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}
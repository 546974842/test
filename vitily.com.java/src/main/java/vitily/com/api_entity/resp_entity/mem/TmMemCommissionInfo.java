package vitily.com.api_entity.resp_entity.mem;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.com.api_entity.resp_entity.base.TmBaseEntity;
import vitily.com.util.CentToYuanSerializer;

public class TmMemCommissionInfo extends TmBaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 今日佣金
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long dayAmount;
    /**
     * 本月累计佣金
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long monthAmount;
    /**
     * 总佣金
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long totalAmount;
    /**
     * 邀请模特个数
     */
    private Integer inviteModels;
    /**
     * 邀请商家个数
     */
    private Integer inviteSellers;

    public Long getDayAmount() {
        return dayAmount;
    }

    public void setDayAmount(Long dayAmount) {
        this.dayAmount = dayAmount;
    }

    public Long getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(Long monthAmount) {
        this.monthAmount = monthAmount;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getInviteModels() {
        return inviteModels;
    }

    public void setInviteModels(Integer inviteModels) {
        this.inviteModels = inviteModels;
    }

    public Integer getInviteSellers() {
        return inviteSellers;
    }

    public void setInviteSellers(Integer inviteSellers) {
        this.inviteSellers = inviteSellers;
    }
}

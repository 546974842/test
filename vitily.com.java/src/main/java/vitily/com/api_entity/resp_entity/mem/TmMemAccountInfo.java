package vitily.com.api_entity.resp_entity.mem;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.com.api_entity.resp_entity.base.TmBaseEntity;
import vitily.com.util.CentToYuanSerializer;

public class TmMemAccountInfo extends TmBaseEntity {
    /**
     * 可用余额
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long availableAmount;
    /**
     * 冻结余额
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long freezeAmount;
    /**
     * 累计总获利
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long cumulativeProfit;
    /**
     * 本月总获利
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long monthProfit;
    /**
     * 总推广获利
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long recommendProfit;

    public Long getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Long availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Long getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(Long freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    public Long getCumulativeProfit() {
        return cumulativeProfit;
    }

    public void setCumulativeProfit(Long cumulativeProfit) {
        this.cumulativeProfit = cumulativeProfit;
    }

    public Long getMonthProfit() {
        return monthProfit;
    }

    public void setMonthProfit(Long monthProfit) {
        this.monthProfit = monthProfit;
    }

    public Long getRecommendProfit() {
        return recommendProfit;
    }

    public void setRecommendProfit(Long recommendProfit) {
        this.recommendProfit = recommendProfit;
    }
}

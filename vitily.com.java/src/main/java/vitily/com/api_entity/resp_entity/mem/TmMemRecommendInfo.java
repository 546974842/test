package vitily.com.api_entity.resp_entity.mem;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.com.api_entity.resp_entity.base.TmBaseEntity;
import vitily.com.util.CentToYuanSerializer;

public class TmMemRecommendInfo extends TmBaseEntity{
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long recommendProfit;
    private Integer recommendCount;
    private Integer recommendVip1Count;
    private Integer recommendVip2Count;
    private Integer recommendVip3Count;

    public Long getRecommendProfit() {
        return recommendProfit;
    }

    public void setRecommendProfit(Long recommendProfit) {
        this.recommendProfit = recommendProfit;
    }

    public Integer getRecommendCount() {
        return recommendCount;
    }

    public void setRecommendCount(Integer recommendCount) {
        this.recommendCount = recommendCount;
    }

    public Integer getRecommendVip1Count() {
        return recommendVip1Count;
    }

    public void setRecommendVip1Count(Integer recommendVip1Count) {
        this.recommendVip1Count = recommendVip1Count;
    }

    public Integer getRecommendVip2Count() {
        return recommendVip2Count;
    }

    public void setRecommendVip2Count(Integer recommendVip2Count) {
        this.recommendVip2Count = recommendVip2Count;
    }

    public Integer getRecommendVip3Count() {
        return recommendVip3Count;
    }

    public void setRecommendVip3Count(Integer recommendVip3Count) {
        this.recommendVip3Count = recommendVip3Count;
    }
}

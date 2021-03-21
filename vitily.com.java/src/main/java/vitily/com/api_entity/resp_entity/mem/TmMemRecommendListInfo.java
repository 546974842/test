package vitily.com.api_entity.resp_entity.mem;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.com.api_entity.resp_entity.base.TmBaseEntity;
import vitily.com.util.CentToYuanSerializer;

import java.util.Date;

public class TmMemRecommendListInfo extends TmBaseEntity{
    @JSONField(format = "yyyy-MM-dd")
    private Date registerDate;
    private String userName;
    private Integer level;
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long recommendProfit;

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getRecommendProfit() {
        return recommendProfit;
    }

    public void setRecommendProfit(Long recommendProfit) {
        this.recommendProfit = recommendProfit;
    }
}

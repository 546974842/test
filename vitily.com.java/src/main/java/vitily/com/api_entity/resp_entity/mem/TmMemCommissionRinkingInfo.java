package vitily.com.api_entity.resp_entity.mem;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.com.api_entity.resp_entity.base.TmBaseEntity;
import vitily.com.util.CentToYuanSerializer;

public class TmMemCommissionRinkingInfo extends TmBaseEntity{
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long rewardMoney;
    private String nickName;
    private String headPortrati;

    public Long getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(Long rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPortrati() {
        return headPortrati;
    }

    public void setHeadPortrati(String headPortrati) {
        this.headPortrati = headPortrati;
    }
}

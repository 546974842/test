package vitily.com.ts_entity.mem;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.mem.TbMemModelInfo;

public class TsMemModelInfo extends BaseSearch<TbMemModelInfo> {

    private String selName;

    public TsMemModelInfo() {
        super( new TbMemModelInfo());
    }

    /**
     * 收藏、体验的商家id
     */
    private Integer experiencedAndHotSellerId;

    public Integer getExperiencedAndHotSellerId() {
        return experiencedAndHotSellerId;
    }

    public void setExperiencedAndHotSellerId(Integer experiencedAndHotSellerId) {
        this.experiencedAndHotSellerId = experiencedAndHotSellerId;
    }

    public String getSelName() {
        return selName;
    }

    public void setSelName(String selName) {
        this.selName = selName;
    }
}
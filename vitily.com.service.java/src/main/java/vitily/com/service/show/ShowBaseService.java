package vitily.com.service.show;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.show.TbShowBase;
import vitily.com.ts_entity.show.TsShowBase;
import vitily.com.tv_entity.show.TvShowBase;

public interface ShowBaseService extends BasicService<TbShowBase,TsShowBase,TvShowBase> {
    void appCancelShowInfo(Integer showId,Integer memberId)throws Exception;
}
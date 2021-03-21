package vitily.com.service.mem;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.mem.TbMemArtist;
import vitily.com.ts_entity.mem.TsMemArtist;
import vitily.com.tv_entity.mem.TvMemArtist;

public interface MemArtistService extends BasicService<TbMemArtist,TsMemArtist,TvMemArtist> {
    void insertOrUpdate(TbMemArtist entity);
}
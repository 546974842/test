package vitily.com.mapper.mem;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.mem.TbMemCompanyCreditfile;
import vitily.com.ts_entity.mem.TsMemCompanyCreditfile;
import vitily.com.tv_entity.mem.TvMemCompanyCreditfile;

public interface MemCompanyCreditfileMapper extends BaseMapper<TbMemCompanyCreditfile,TsMemCompanyCreditfile,TvMemCompanyCreditfile> {
    TbMemCompanyCreditfile selectForUpdate(int id);
}

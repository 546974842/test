package vitily.com.mapper.mem;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.mem.TbMemPersonalCreditfile;
import vitily.com.ts_entity.mem.TsMemPersonalCreditfile;
import vitily.com.tv_entity.mem.TvMemPersonalCreditfile;

public interface MemPersonalCreditfileMapper extends BaseMapper<TbMemPersonalCreditfile,TsMemPersonalCreditfile,TvMemPersonalCreditfile> {
    TbMemPersonalCreditfile selectForUpdate(int id);
}

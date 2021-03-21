package vitily.com.mapper.mem;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.mem.TbMemPersonalCertifyinfo;
import vitily.com.ts_entity.mem.TsMemPersonalCertifyinfo;
import vitily.com.tv_entity.mem.TvMemPersonalCertifyinfo;

public interface MemPersonalCertifyinfoMapper extends BaseMapper<TbMemPersonalCertifyinfo, TsMemPersonalCertifyinfo, TvMemPersonalCertifyinfo> {
    TbMemPersonalCertifyinfo selectForUpdate(int id);
}
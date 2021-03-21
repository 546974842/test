package vitily.com.mapper.mem;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.mem.TbModelHot;
import vitily.com.ts_entity.mem.TsModelHot;
import vitily.com.tv_entity.mem.TvModelHot;

public interface MemModelHotMapper extends BaseMapper<TbModelHot,TsModelHot,TvModelHot> {
	public Integer selectCount(TsModelHot id);
}

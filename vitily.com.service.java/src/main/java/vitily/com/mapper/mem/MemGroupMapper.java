package vitily.com.mapper.mem;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.mem.TbMemGroup;
import vitily.com.ts_entity.mem.TsMemGroup;
import vitily.com.tv_entity.mem.TvMemGroup;

public interface MemGroupMapper extends BaseMapper<TbMemGroup,TsMemGroup,TvMemGroup> {
	void updateByBean(TsMemGroup bean);
}

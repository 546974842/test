package vitily.com.mapper.mem;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.mem.TbMemExtAttr;
import vitily.com.ts_entity.mem.TsMemExtAttr;
import vitily.com.tv_entity.mem.TvMemExtAttr;

public interface MemExtAttrMapper extends BaseMapper<TbMemExtAttr,TsMemExtAttr,TvMemExtAttr> {
	void updateByBean(TsMemExtAttr bean);
}
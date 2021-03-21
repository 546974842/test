package vitily.com.service.mem;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.mem.TbModelHot;
import vitily.com.ts_entity.mem.TsModelHot;
import vitily.com.tv_entity.mem.TvModelHot;


public interface MemModelHotService extends BasicService<TbModelHot,TsModelHot,TvModelHot> {
	
	public Integer selectCount(TsModelHot a);
}
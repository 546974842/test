package vitily.com.mapper.pro;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.pro.TbProBase;
import vitily.com.ts_entity.pro.TsProBase;
import vitily.com.tv_entity.pro.TvProBase;

public interface ProBaseMapper extends BaseMapper<TbProBase,TsProBase,TvProBase> {
	void updateByBean(TsProBase bean);
}

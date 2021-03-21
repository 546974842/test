package vitily.com.mapper.pro;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.pro.TbProDynproVal;
import vitily.com.ts_entity.pro.TsProDynproVal;
import vitily.com.tv_entity.pro.TvProDynproVal;

public interface ProDynproValMapper extends BaseMapper<TbProDynproVal,TsProDynproVal,TvProDynproVal> {
	 void deleteByBean(TsProDynproVal s);
}

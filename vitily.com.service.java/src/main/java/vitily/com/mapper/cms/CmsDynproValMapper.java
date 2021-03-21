package vitily.com.mapper.cms;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.cms.TbCmsDynproVal;
import vitily.com.ts_entity.cms.TsCmsDynproVal;
import vitily.com.tv_entity.cms.TvCmsDynproVal;

public interface CmsDynproValMapper extends BaseMapper<TbCmsDynproVal,TsCmsDynproVal,TvCmsDynproVal> {
	 void deleteByBean(TsCmsDynproVal s);
}

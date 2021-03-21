package vitily.com.service.pro;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.pro.TbProBase;
import vitily.com.tb_entity.pro.TbProDynproVal;
import vitily.com.tb_entity.pro.TbProMemPri;
import vitily.com.ts_entity.pro.TsProBase;
import vitily.com.tv_entity.pro.TvProBase;
import vitily.com.tv_entity.pro.TvProMemPri;
import vitily.com.tv_entity.pro.TvProSpVal;

import java.util.List;

public interface ProBaseService extends BasicService<TbProBase,TsProBase,TvProBase> {
	void updateByBean(TsProBase bean)throws Exception;
}
package vitily.com.service.pro;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.pro.TbProMemPri;
import vitily.com.ts_entity.pro.TsProMemPri;
import vitily.com.tv_entity.pro.TvProMemPri;

import java.util.List;

public interface ProMemPriService extends BasicService<TbProMemPri,TsProMemPri,TvProMemPri> {
	List<TvProMemPri> getListForMemPriByBean(TsProMemPri entity);
}
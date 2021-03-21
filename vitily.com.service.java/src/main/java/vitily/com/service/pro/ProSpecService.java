package vitily.com.service.pro;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.pro.TbProSpec;
import vitily.com.ts_entity.pro.TsProSpec;
import vitily.com.tv_entity.pro.TvProSpec;

import java.util.List;

public interface ProSpecService extends BasicService<TbProSpec,TsProSpec,TvProSpec> {
	List<TvProSpec> getSpecList(Integer typeId)throws Exception;
}
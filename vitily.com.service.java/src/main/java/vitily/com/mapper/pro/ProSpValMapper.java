package vitily.com.mapper.pro;

import java.util.List;
import java.util.Map;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.pro.TbProSpVal;
import vitily.com.ts_entity.pro.TsProSpVal;
import vitily.com.tv_entity.pro.TvProSpVal;

public interface ProSpValMapper extends BaseMapper<TbProSpVal,TsProSpVal,TvProSpVal> {
	void updateByBean(TsProSpVal bean);
	List<TvProSpVal> getShopcarList(Map <String, String> map);
}
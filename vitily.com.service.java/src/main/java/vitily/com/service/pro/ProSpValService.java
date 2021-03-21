package vitily.com.service.pro;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.pro.TbProSpVal;
import vitily.com.ts_entity.pro.TsProSpVal;
import vitily.com.tv_entity.pro.TvProSpVal;

import java.util.List;

public interface ProSpValService extends BasicService<TbProSpVal,TsProSpVal,TvProSpVal> {
    List<TvProSpVal> getShopcarList(String proIds, String specParIds);
}
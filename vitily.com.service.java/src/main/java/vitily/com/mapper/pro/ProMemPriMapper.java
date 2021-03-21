package vitily.com.mapper.pro;

import java.util.List;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.pro.TbProMemPri;
import vitily.com.ts_entity.pro.TsProMemPri;
import vitily.com.tv_entity.pro.TvProMemPri;

public interface ProMemPriMapper extends BaseMapper<TbProMemPri,TsProMemPri,TvProMemPri> {
	void updateByBean(TsProMemPri bean);
	/**
	 * 为了后台编辑会员价格
	 * @param bean 1
	 */
    List<TvProMemPri> getListForMemPriByBean(TsProMemPri bean);
}
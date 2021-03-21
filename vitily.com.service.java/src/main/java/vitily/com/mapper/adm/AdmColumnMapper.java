package vitily.com.mapper.adm;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.adm.TbAdmColumn;
import vitily.com.ts_entity.adm.TsAdmColumn;
import vitily.com.tv_entity.adm.TvAdmColumn;

public interface AdmColumnMapper extends BaseMapper<TbAdmColumn,TsAdmColumn,TvAdmColumn> {
	/**
	 * 通过queryBean更新
	 * @param bean 1
	 */
    void updateByBean(TsAdmColumn bean);
}

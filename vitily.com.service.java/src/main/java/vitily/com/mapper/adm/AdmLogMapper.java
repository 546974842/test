package vitily.com.mapper.adm;

import java.util.List;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.adm.TbAdmLog;
import vitily.com.ts_entity.adm.TsAdmLog;
import vitily.com.tv_entity.adm.TvAdmLog;

public interface AdmLogMapper extends BaseMapper<TbAdmLog,TsAdmLog,TvAdmLog> {
	/**
	 * 批量插入日志
	 * @param list 1
	 */
    void bitInsert(List <TbAdmLog> list);
}

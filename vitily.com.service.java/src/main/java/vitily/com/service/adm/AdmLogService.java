package vitily.com.service.adm;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.adm.TbAdmLog;
import vitily.com.ts_entity.adm.TsAdmLog;
import vitily.com.tv_entity.adm.TvAdmLog;

import java.util.List;

public interface AdmLogService extends BasicService<TbAdmLog,TsAdmLog,TvAdmLog> {

	/**
	 *
	 * @param list 1
	 */
	void bitInsert(List <TbAdmLog> list);
}
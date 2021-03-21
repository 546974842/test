package vitily.com.service.adm;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.adm.TbAdmColumn;
import vitily.com.ts_entity.adm.TsAdmColumn;
import vitily.com.tv_entity.adm.TvAdmColumn;

import java.util.List;

public interface AdmColumnService extends BasicService<TbAdmColumn,TsAdmColumn,TvAdmColumn> {
	/**
	 * 从数据库查询：不过滤权限
	 * @param bean 1
	 * @return 2
	 */
	List<TvAdmColumn> getListByBean(TsAdmColumn bean);
}
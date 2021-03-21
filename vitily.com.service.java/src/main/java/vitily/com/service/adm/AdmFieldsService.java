package vitily.com.service.adm;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.adm.TbAdmFields;
import vitily.com.ts_entity.adm.TsAdmFields;
import vitily.com.tv_entity.adm.TvAdmFields;

import java.util.List;

public interface AdmFieldsService extends BasicService<TbAdmFields,TsAdmFields,TvAdmFields> {
	 List<TvAdmFields> getFieldShowByColumnId(int columnId);
}
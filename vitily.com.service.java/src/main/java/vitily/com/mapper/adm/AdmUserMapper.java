package vitily.com.mapper.adm;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.adm.TbAdmUser;
import vitily.com.ts_entity.adm.TsAdmUser;
import vitily.com.tv_entity.adm.TvAdmUser;

public interface AdmUserMapper extends BaseMapper<TbAdmUser,TsAdmUser,TvAdmUser> {
	TvAdmUser getBySelectiveForTv(TsAdmUser s);
}

package vitily.com.mapper.adm;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.adm.TbAdmMsg;
import vitily.com.ts_entity.adm.TsAdmMsg;
import vitily.com.tv_entity.adm.TvAdmMsg;

public interface AdmMsgMapper extends BaseMapper<TbAdmMsg,TsAdmMsg,TvAdmMsg> {
    void insertByQueryMember(TsAdmMsg bean);
}

package vitily.com.service.adm;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.adm.TbAdmMsg;
import vitily.com.ts_entity.adm.TsAdmMsg;
import vitily.com.tv_entity.adm.TvAdmMsg;

public interface AdmMsgService extends BasicService<TbAdmMsg,TsAdmMsg,TvAdmMsg> {
    void insertByQueryMember(TsAdmMsg bean);
}
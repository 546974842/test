package vitily.com.service.mem;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.mem.TbMemCompanyCreditfile;
import vitily.com.ts_entity.mem.TsMemCompanyCreditfile;
import vitily.com.tv_entity.mem.TvMemCompanyCreditfile;

public interface MemCompanyCreditfileService extends BasicService<TbMemCompanyCreditfile,TsMemCompanyCreditfile,TvMemCompanyCreditfile> {
    /**
     * 审核 企业认证资料
     * @param bean
     */
    void updateForAuditCreditfile(TsMemCompanyCreditfile bean)throws Exception;
}
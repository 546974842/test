package vitily.com.service.mem;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.mem.TbMemPersonalCreditfile;
import vitily.com.ts_entity.mem.TsMemPersonalCreditfile;
import vitily.com.tv_entity.mem.TvMemPersonalCreditfile;

public interface MemPersonalCreditfileService extends BasicService<TbMemPersonalCreditfile,TsMemPersonalCreditfile,TvMemPersonalCreditfile> {
    /**
     * 审核 个人认证资料
     * @param bean
     */
    void updateForAuditCreditfile(TsMemPersonalCreditfile bean)throws Exception;
}
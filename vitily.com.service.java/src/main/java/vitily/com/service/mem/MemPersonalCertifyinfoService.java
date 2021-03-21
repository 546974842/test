package vitily.com.service.mem;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.mem.TbMemPersonalCertifyinfo;
import vitily.com.ts_entity.mem.TsMemPersonalCertifyinfo;
import vitily.com.tv_entity.mem.TvMemPersonalCertifyinfo;

public interface MemPersonalCertifyinfoService extends BasicService<TbMemPersonalCertifyinfo, TsMemPersonalCertifyinfo, TvMemPersonalCertifyinfo> {
    /**
     * 审核 个人认证资料
     * @param bean
     */
    void updateForAuditCreditfile(TsMemPersonalCertifyinfo bean)throws Exception;
}
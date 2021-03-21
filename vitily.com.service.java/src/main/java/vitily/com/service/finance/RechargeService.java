package vitily.com.service.finance;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.finance.TbRecharge;
import vitily.com.ts_entity.finance.TsRecharge;
import vitily.com.tv_entity.finance.TvRecharge;

public interface RechargeService extends BasicService<TbRecharge,TsRecharge,TvRecharge> {
    int updateForAudit(TbRecharge bean)throws Exception;
}
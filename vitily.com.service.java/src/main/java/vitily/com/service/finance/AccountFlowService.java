package vitily.com.service.finance;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.finance.TbAccountFlow;
import vitily.com.ts_entity.finance.TsAccountFlow;
import vitily.com.tv_entity.finance.TvAccountFlow;

public interface AccountFlowService extends BasicService<TbAccountFlow,TsAccountFlow,TvAccountFlow> {
    Long selectSumAmountByBean(TsAccountFlow query);
}
package vitily.com.mapper.finance;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.finance.TbAccountFlow;
import vitily.com.ts_entity.finance.TsAccountFlow;
import vitily.com.tv_entity.finance.TvAccountFlow;

public interface AccountFlowMapper extends BaseMapper<TbAccountFlow,TsAccountFlow,TvAccountFlow> {
    Long selectSumAmountByBean(TsAccountFlow query);
}

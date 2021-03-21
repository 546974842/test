package vitily.com.mapper.finance;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.finance.TbRecharge;
import vitily.com.ts_entity.finance.TsRecharge;
import vitily.com.tv_entity.finance.TvRecharge;

public interface RechargeMapper extends BaseMapper<TbRecharge,TsRecharge,TvRecharge> {
    TvRecharge selectByOrderNoForUpdate(String orderNo);
}

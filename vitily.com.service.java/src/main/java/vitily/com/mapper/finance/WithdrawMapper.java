package vitily.com.mapper.finance;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.finance.TbWithdraw;
import vitily.com.ts_entity.finance.TsWithdraw;
import vitily.com.tv_entity.finance.TvWithdraw;

public interface WithdrawMapper extends BaseMapper<TbWithdraw,TsWithdraw,TvWithdraw> {
    TvWithdraw selectByOrderNoForUpdate(String orderNo);
    int updateByIdAndState(TsWithdraw bean);
}

package vitily.com.service.finance;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.finance.TbWithdraw;
import vitily.com.ts_entity.finance.TsWithdraw;
import vitily.com.tv_entity.finance.TvWithdraw;

public interface WithdrawService extends BasicService<TbWithdraw,TsWithdraw,TvWithdraw> {
    int updateForAudit(TbWithdraw bean)throws Exception;
}
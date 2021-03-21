package vitily.com.service.mem;

import vitily.com.api_entity.resp_entity.mem.TmMemAccountInfo;
import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.mem.TbMemLocalAccount;
import vitily.com.ts_entity.mem.TsMemLocalAccount;
import vitily.com.tv_entity.mem.TvMemLocalAccount;

public interface MemLocalAccountService extends BasicService<TbMemLocalAccount,TsMemLocalAccount,TvMemLocalAccount> {
    TmMemAccountInfo selectAmountInfo(Integer memberId);
}
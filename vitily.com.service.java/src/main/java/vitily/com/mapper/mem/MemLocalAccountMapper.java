package vitily.com.mapper.mem;

import vitily.com.api_entity.resp_entity.mem.TmMemAccountInfo;
import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.mem.TbMemLocalAccount;
import vitily.com.ts_entity.mem.TsMemLocalAccount;
import vitily.com.tv_entity.mem.TvMemLocalAccount;

public interface MemLocalAccountMapper extends BaseMapper<TbMemLocalAccount,TsMemLocalAccount,TvMemLocalAccount> {
    TbMemLocalAccount selectByMemberIdForUpdate(int memberId);
    int updateByTs(TsMemLocalAccount bean);
    TmMemAccountInfo selectAmountInfo(Integer memberId);
}

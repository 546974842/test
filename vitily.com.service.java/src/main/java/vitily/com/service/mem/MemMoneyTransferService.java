package vitily.com.service.mem;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.mem.TbMemMoneyTransfer;
import vitily.com.ts_entity.mem.TsMemMoneyTransfer;
import vitily.com.tv_entity.mem.TvMemMoneyTransfer;

public interface MemMoneyTransferService extends BasicService<TbMemMoneyTransfer,TsMemMoneyTransfer,TvMemMoneyTransfer> {
    /**
     * 审核打款
     * @param e
     * @return
     */
    boolean updateForAudit(TvMemMoneyTransfer e)throws Exception;
}
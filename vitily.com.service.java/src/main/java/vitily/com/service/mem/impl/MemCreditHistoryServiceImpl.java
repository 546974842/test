package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.tb_entity.mem.TbMemCreditHistory;
import vitily.com.mapper.mem.MemCreditHistoryMapper;
import vitily.com.service.mem.MemCreditHistoryService;
import vitily.com.ts_entity.mem.TsMemCreditHistory;
import vitily.com.tv_entity.mem.TvMemCreditHistory;

@Component
public class MemCreditHistoryServiceImpl extends BasicServiceImpl<TbMemCreditHistory,TsMemCreditHistory,TvMemCreditHistory> implements MemCreditHistoryService {

	final MemCreditHistoryMapper memCreditHistoryMapper;

	@Autowired()
	public MemCreditHistoryServiceImpl(MemCreditHistoryMapper memCreditHistoryMapper) {
		this.memCreditHistoryMapper = memCreditHistoryMapper;
		super.setBaseMapper(memCreditHistoryMapper);
	}
}
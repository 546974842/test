package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.api_entity.resp_entity.mem.TmMemAccountInfo;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.tb_entity.mem.TbMemLocalAccount;
import vitily.com.mapper.mem.MemLocalAccountMapper;
import vitily.com.service.mem.MemLocalAccountService;
import vitily.com.ts_entity.mem.TsMemLocalAccount;
import vitily.com.tv_entity.mem.TvMemLocalAccount;

@Component
public class MemLocalAccountServiceImpl extends BasicServiceImpl<TbMemLocalAccount,TsMemLocalAccount,TvMemLocalAccount> implements MemLocalAccountService {

	final MemLocalAccountMapper memLocalAccountMapper;
	@Autowired()
	public MemLocalAccountServiceImpl(MemLocalAccountMapper memLocalAccountMapper) {
		this.memLocalAccountMapper = memLocalAccountMapper;
		super.setBaseMapper(memLocalAccountMapper);
	}
	@Override
	public TmMemAccountInfo selectAmountInfo(Integer memberId){
		return memLocalAccountMapper.selectAmountInfo(memberId);
	}
}
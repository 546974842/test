package vitily.com.service.finance.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.tb_entity.finance.TbAccountFlow;
import vitily.com.mapper.finance.AccountFlowMapper;
import vitily.com.service.finance.AccountFlowService;
import vitily.com.ts_entity.finance.TsAccountFlow;
import vitily.com.tv_entity.finance.TvAccountFlow;

@Component
public class AccountFlowServiceImpl extends BasicServiceImpl<TbAccountFlow,TsAccountFlow,TvAccountFlow> implements AccountFlowService {

	final
	AccountFlowMapper accountFlowMapper;

	@Autowired()
	public AccountFlowServiceImpl(AccountFlowMapper accountFlowMapper) {
		this.accountFlowMapper = accountFlowMapper;
		super.setBaseMapper(accountFlowMapper);
	}
	@Override
	public Long selectSumAmountByBean(TsAccountFlow query){
		return accountFlowMapper.selectSumAmountByBean(query);
	}
}
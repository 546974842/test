package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.tb_entity.comm.TbAvailableBank;
import vitily.com.mapper.comm.AvailableBankMapper;
import vitily.com.service.comm.AvailableBankService;
import vitily.com.ts_entity.comm.TsAvailableBank;
import vitily.com.tv_entity.comm.TvAvailableBank;

@Component
public class AvailableBankServiceImpl extends BasicServiceImpl<TbAvailableBank,TsAvailableBank,TvAvailableBank> implements AvailableBankService {
	final
	AvailableBankMapper availableBankMapper;
	@Autowired()
	public AvailableBankServiceImpl(AvailableBankMapper availableBankMapper) {
		this.availableBankMapper = availableBankMapper;
		super.setBaseMapper(availableBankMapper);
	}
}

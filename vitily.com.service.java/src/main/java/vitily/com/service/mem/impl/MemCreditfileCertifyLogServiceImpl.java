package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.tb_entity.mem.TbMemCreditfileCertifyLog;
import vitily.com.mapper.mem.MemCreditfileCertifyLogMapper;
import vitily.com.service.mem.MemCreditfileCertifyLogService;
import vitily.com.ts_entity.mem.TsMemCreditfileCertifyLog;
import vitily.com.tv_entity.mem.TvMemCreditfileCertifyLog;

@Component
public class MemCreditfileCertifyLogServiceImpl extends BasicServiceImpl<TbMemCreditfileCertifyLog,TsMemCreditfileCertifyLog,TvMemCreditfileCertifyLog> implements MemCreditfileCertifyLogService {

	final MemCreditfileCertifyLogMapper memCreditfileCertifyLogMapper;

	@Autowired()
	public MemCreditfileCertifyLogServiceImpl(MemCreditfileCertifyLogMapper memCreditfileCertifyLogMapper) {
		this.memCreditfileCertifyLogMapper = memCreditfileCertifyLogMapper;
		super.setBaseMapper(memCreditfileCertifyLogMapper);
	}
}
package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vitily.com.tb_entity.mem.TbModelHot;
import vitily.com.mapper.mem.MemModelHotMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemModelHotService;
import vitily.com.ts_entity.mem.TsModelHot;
import vitily.com.tv_entity.mem.TvModelHot;

@Component
public class MemModelHotServiceImpl extends BasicServiceImpl<TbModelHot,TsModelHot,TvModelHot> implements MemModelHotService {
	
	final MemModelHotMapper memModelHotMapper;
	
	@Autowired()
	public MemModelHotServiceImpl(MemModelHotMapper memModelHotMapper) {
		this.memModelHotMapper = memModelHotMapper;
		super.setBaseMapper(memModelHotMapper);
	}

	@Override
	public Integer selectCount(TsModelHot id) {
		return memModelHotMapper.selectCount(id);
	}
}
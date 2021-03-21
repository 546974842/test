package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vitily.com.tb_entity.mem.TbModelInfo;
import vitily.com.mapper.mem.MemModelMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemModelService;
import vitily.com.ts_entity.mem.TsModelInfo;
import vitily.com.tv_entity.mem.TvModelInfo;

@Component
public class MemModelServiceImpl extends BasicServiceImpl<TbModelInfo,TsModelInfo,TvModelInfo> implements MemModelService {
	
	final MemModelMapper memModelMapper;
	
	@Autowired()
	public MemModelServiceImpl(MemModelMapper memModelMapper) {
		this.memModelMapper = memModelMapper;
		super.setBaseMapper(memModelMapper);
	}
}
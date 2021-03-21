package vitily.com.service.show.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.mapper.show.ShowTimeMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.show.ShowTimeService;
import vitily.com.tb_entity.show.TbShowTime;
import vitily.com.ts_entity.show.TsShowTime;
import vitily.com.tv_entity.show.TvShowTime;

@Component
public class ShowTimeServiceImpl extends BasicServiceImpl<TbShowTime,TsShowTime,TvShowTime> implements ShowTimeService {

	final
	ShowTimeMapper ShowTimeMapper;

	@Autowired()
	public ShowTimeServiceImpl(ShowTimeMapper ShowTimeMapper) {
		this.ShowTimeMapper = ShowTimeMapper;
		super.setBaseMapper(ShowTimeMapper);
	}
}

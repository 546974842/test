package vitily.com.service.show.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.mapper.show.ShowCateMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.show.ShowCateService;
import vitily.com.tb_entity.show.TbShowCate;
import vitily.com.ts_entity.show.TsShowCate;
import vitily.com.tv_entity.show.TvShowCate;

@Component
public class ShowCateServiceImpl extends BasicServiceImpl<TbShowCate,TsShowCate,TvShowCate> implements ShowCateService {

	final
	ShowCateMapper ShowCateMapper;

	@Autowired()
	public ShowCateServiceImpl(ShowCateMapper ShowCateMapper) {
		this.ShowCateMapper = ShowCateMapper;
		super.setBaseMapper(ShowCateMapper);
	}
}

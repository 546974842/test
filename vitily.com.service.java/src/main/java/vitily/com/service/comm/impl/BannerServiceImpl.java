package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbBanner;
import vitily.com.mapper.comm.BannerMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.BannerService;
import vitily.com.ts_entity.comm.TsBanner;
import vitily.com.tv_entity.comm.TvBanner;

@Component
public class BannerServiceImpl extends BasicServiceImpl<TbBanner,TsBanner,TvBanner> implements BannerService {

	final
	BannerMapper bannerMapper;

	@Autowired()
	public BannerServiceImpl(BannerMapper bannerMapper) {
		this.bannerMapper = bannerMapper;
		super.setBaseMapper(bannerMapper);
	}

}

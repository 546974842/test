package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbAdvertise;
import vitily.com.mapper.comm.AdvertiseMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.AdvertiseService;
import vitily.com.ts_entity.comm.TsAdvertise;
import vitily.com.tv_entity.comm.TvAdvertise;

@Component
public class AdvertiseServiceImpl extends BasicServiceImpl<TbAdvertise,TsAdvertise,TvAdvertise> implements AdvertiseService {

	final
    AdvertiseMapper advertiseMapper;

	@Autowired()
	public AdvertiseServiceImpl(AdvertiseMapper advertiseMapper) {
		this.advertiseMapper = advertiseMapper;
		super.setBaseMapper(advertiseMapper);
	}
}

package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vitily.com.tb_entity.comm.TbChenkin;
import vitily.com.mapper.comm.ChenkinMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.ChenkinService;
import vitily.com.ts_entity.comm.TsChenkin;
import vitily.com.tv_entity.comm.TvChenkin;

@Component
public class ChenkinServiceImpl extends BasicServiceImpl<TbChenkin,TsChenkin,TvChenkin> implements ChenkinService {

	final
	ChenkinMapper chenkinMapper;

	@Autowired()
	public ChenkinServiceImpl(ChenkinMapper chenkinMapper) {
		this.chenkinMapper = chenkinMapper;
		super.setBaseMapper(chenkinMapper);
	}

}

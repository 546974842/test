package vitily.com.service.pro.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.pro.TbProMemPri;
import vitily.com.mapper.pro.ProMemPriMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.pro.ProMemPriService;
import vitily.com.ts_entity.pro.TsProMemPri;
import vitily.com.tv_entity.pro.TvProMemPri;

@Component
public class ProMemPriServiceImpl extends BasicServiceImpl<TbProMemPri,TsProMemPri,TvProMemPri> implements ProMemPriService {

	final
    ProMemPriMapper proMemPriMapper;

	@Autowired()
	public ProMemPriServiceImpl(ProMemPriMapper proMemPriMapper) {
		this.proMemPriMapper = proMemPriMapper;
		super.setBaseMapper(proMemPriMapper);
	}
	
	public List<TvProMemPri> getListForMemPriByBean(TsProMemPri entity){
		return proMemPriMapper.getListForMemPriByBean(entity);
	}
}
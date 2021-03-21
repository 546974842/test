package vitily.com.service.pro.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.pro.TbProDynproVal;
import vitily.com.mapper.pro.ProDynproValMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.pro.ProDynproValService;
import vitily.com.ts_entity.pro.TsProDynproVal;
import vitily.com.tv_entity.pro.TvProDynproVal;

@Component
public class ProDynproValServiceImpl extends BasicServiceImpl<TbProDynproVal,TsProDynproVal,TvProDynproVal> implements ProDynproValService {

	final
    ProDynproValMapper proDynproValMapper;

	@Autowired()
	public ProDynproValServiceImpl(ProDynproValMapper proDynproValMapper) {
		this.proDynproValMapper = proDynproValMapper;
		super.setBaseMapper(proDynproValMapper);
	}
}

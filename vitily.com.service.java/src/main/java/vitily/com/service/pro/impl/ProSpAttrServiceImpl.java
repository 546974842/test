package vitily.com.service.pro.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.pro.TbProSpAttr;
import vitily.com.mapper.pro.ProSpAttrMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.pro.ProSpAttrService;
import vitily.com.ts_entity.pro.TsProSpAttr;
import vitily.com.tv_entity.pro.TvProSpAttr;

@Component
public class ProSpAttrServiceImpl extends BasicServiceImpl<TbProSpAttr,TsProSpAttr,TvProSpAttr> implements ProSpAttrService {

	final ProSpAttrMapper proSpAttrMapper;

	@Autowired()
	public ProSpAttrServiceImpl(ProSpAttrMapper proSpAttrMapper) {
		this.proSpAttrMapper = proSpAttrMapper;
		super.setBaseMapper(proSpAttrMapper);
	}
}

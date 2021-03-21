package vitily.com.service.pro.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.pro.TbProSpVal;
import vitily.com.mapper.pro.ProSpValMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.pro.ProSpValService;
import vitily.com.ts_entity.pro.TsProSpVal;
import vitily.com.tv_entity.pro.TvProSpVal;
import vitily.com.util.CommonUtil;

@Component
public class ProSpValServiceImpl extends BasicServiceImpl<TbProSpVal,TsProSpVal,TvProSpVal> implements ProSpValService {

	final
	ProSpValMapper proSpValMapper;

	@Autowired()
	public ProSpValServiceImpl(ProSpValMapper proSpValMapper) {
		this.proSpValMapper = proSpValMapper;
		super.setBaseMapper(proSpValMapper);
	}
	/**
	 * 获取购物车产品
	 * @return 2
	 */
	public List<TvProSpVal> getShopcarList(String proIds, String specParIds){
		if(!CommonUtil.isNumOrD(proIds)){
			proIds = "0";
		}
		if(!CommonUtil.isNumOrD(specParIds)){
			specParIds = "0";
		}
		Map<String, String> map=new HashMap<>();
		map.put("proIds", proIds);
		map.put("specParIds", specParIds);
		return proSpValMapper.getShopcarList(map);
	}
}
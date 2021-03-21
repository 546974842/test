package vitily.com.service.pro.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.pro.TbProBrand;
import vitily.com.mapper.pro.ProBrandMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.pro.ProBrandService;
import vitily.com.ts_entity.pro.TsProBrand;
import vitily.com.tv_entity.pro.TvProBrand;
import vitily.com.util.CommonUtil;

@Component
public class ProBrandServiceImpl extends BasicServiceImpl<TbProBrand,TsProBrand,TvProBrand> implements ProBrandService {

	final
	ProBrandMapper proBrandMapper;

	@Autowired()
	public ProBrandServiceImpl(ProBrandMapper proBrandMapper) {
		this.proBrandMapper = proBrandMapper;
		super.setBaseMapper(proBrandMapper);
	}

	@Override
	public int insert(TsProBrand bean) throws Exception{
		if(proBrandMapper.isExists(bean)){
			throw new DuplicateDataException("品牌名字重复");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return proBrandMapper.insertSelective(bean.getEntity());
	}
	/**
	 * 修改：检查是否存在
	 * @param entity 1
	 * @throws Exception 2
	 */
	@Override
	public int update(TsProBrand bean) throws Exception{
		if(proBrandMapper.isExists(bean)){
			throw new DuplicateDataException("品牌名字重复");
		}
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		return proBrandMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
}
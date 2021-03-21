package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.tb_entity.comm.TbRegion;
import vitily.com.mapper.comm.RegionMapper;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.comm.RegionService;
import vitily.com.ts_entity.comm.TsRegion;
import vitily.com.tv_entity.comm.TvRegion;
import vitily.com.util.CommonUtil;

@Component
public class RegionServiceImpl extends BasicServiceImpl<TbRegion,TsRegion,TvRegion> implements RegionService {

	final
	RegionMapper regionMapper;

	@Autowired()
	public RegionServiceImpl(RegionMapper regionMapper) {
		this.regionMapper = regionMapper;
		super.setBaseMapper(regionMapper);
	}

	@Override
	public int insert(TsRegion bean) throws Exception{
		if(regionMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的地区名！");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return regionMapper.insertSelective(bean.getEntity());
	}
	@Override
	public int update(TsRegion bean) throws Exception{
		if(regionMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的地区名！");
		}
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		return regionMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
}
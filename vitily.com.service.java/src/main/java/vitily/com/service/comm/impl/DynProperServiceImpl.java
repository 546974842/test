package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbDynProper;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.ts_entity.comm.TsDynProper;
import vitily.com.tv_entity.comm.TvDynProper;
import vitily.com.mapper.comm.DynProperMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.DynProperService;
import vitily.com.util.CommonUtil;

@Component
public class DynProperServiceImpl extends BasicServiceImpl<TbDynProper,TsDynProper,TvDynProper> implements DynProperService {

	final
	DynProperMapper dynProperMapper;

	@Autowired()
	public DynProperServiceImpl(DynProperMapper dynProperMapper) {
		this.dynProperMapper = dynProperMapper;
		super.setBaseMapper(dynProperMapper);
	}
	@Override
	public int insert(TsDynProper bean) throws Exception{
		if(dynProperMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的属性！");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return dynProperMapper.insertSelective(bean.getEntity());
	}
	@Override
	public int update(TsDynProper bean) throws Exception{
		if(dynProperMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的属性！");
		}
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		return dynProperMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
}

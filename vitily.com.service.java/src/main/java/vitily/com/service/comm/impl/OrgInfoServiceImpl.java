package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbOrgInfo;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.ts_entity.comm.TsOrgInfo;
import vitily.com.tv_entity.comm.TvOrgInfo;
import vitily.com.mapper.comm.OrgInfoMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.OrgInfoService;
import vitily.com.util.CommonUtil;

@Component
public class OrgInfoServiceImpl extends BasicServiceImpl<TbOrgInfo,TsOrgInfo,TvOrgInfo> implements OrgInfoService {

	final
	OrgInfoMapper orgInfoMapper;

	@Autowired()
	public OrgInfoServiceImpl(OrgInfoMapper orgInfoMapper) {
		this.orgInfoMapper = orgInfoMapper;
		super.setBaseMapper(orgInfoMapper);
	}

	@Override
	public int insert(TsOrgInfo bean) throws Exception{
		if(orgInfoMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的机构！");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return orgInfoMapper.insertSelective(bean.getEntity());
	}
	@Override
	public int update(TsOrgInfo bean) throws Exception{
		if(orgInfoMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的机构！");
		}
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		return orgInfoMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
}

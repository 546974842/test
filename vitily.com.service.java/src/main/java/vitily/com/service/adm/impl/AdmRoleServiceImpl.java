package vitily.com.service.adm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.adm.TbAdmRole;
import vitily.com.mapper.adm.AdmRoleMapper;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.adm.AdmRoleService;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.ts_entity.adm.TsAdmRole;
import vitily.com.tv_entity.adm.TvAdmRole;
import vitily.com.util.CommonUtil;

@Component
public class AdmRoleServiceImpl extends BasicServiceImpl<TbAdmRole,TsAdmRole,TvAdmRole> implements AdmRoleService {

	final
	AdmRoleMapper admRoleMapper;

	@Autowired()
	public AdmRoleServiceImpl(AdmRoleMapper admRoleMapper) {
		this.admRoleMapper = admRoleMapper;
		super.setBaseMapper(admRoleMapper);
	}

	@Override
	public int insert(TsAdmRole bean) throws Exception{
		if(admRoleMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的角色！");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return admRoleMapper.insertSelective(bean.getEntity());
	}
	@Override
	public int update(TsAdmRole bean) throws Exception{
		if(admRoleMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的角色！");
		}
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		return admRoleMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
}

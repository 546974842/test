package vitily.test.service.adm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.tb_entity.adm.TbAdmRole;
import vitily.com.mapper.adm.AdmRoleMapper;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.ts_entity.adm.TsAdmRole;
import vitily.com.tv_entity.adm.TvAdmRole;
import vitily.test.service.adm.TestAdmRoleService;
import vitily.test.service.base.impl.BasicServiceImpl;

@Component
public class TestAdmRoleServiceImpl extends BasicServiceImpl<TbAdmRole,TsAdmRole,TvAdmRole> implements TestAdmRoleService {

	final
	AdmRoleMapper admRoleMapper;

	@Autowired()
	public TestAdmRoleServiceImpl(AdmRoleMapper admRoleMapper) {
		this.admRoleMapper = admRoleMapper;
		super.setBaseMapper(admRoleMapper);
	}

	@Override
	public int insert(TsAdmRole bean) throws Exception{
		if(admRoleMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的角色！");
		}
		return super.insertSelective(bean.getEntity());
	}
	@Override
	public int update(TsAdmRole bean) throws Exception{
		super.updateByPrimaryKeySelective(bean.getEntity());
		if(admRoleMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的角色！");
		}
		return super.updateByPrimaryKeySelective(bean.getEntity());
	}
}

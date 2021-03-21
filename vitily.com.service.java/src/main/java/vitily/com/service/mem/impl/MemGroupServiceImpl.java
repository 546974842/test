package vitily.com.service.mem.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.consts.DefaultDesc;
import vitily.com.consts.DelTagDesc;
import vitily.com.tb_entity.mem.TbMemGroup;
import vitily.com.mapper.mem.MemGroupMapper;
import vitily.com.mapper.pro.ProMemPriMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.mem.MemGroupService;
import vitily.com.ts_entity.mem.TsMemGroup;
import vitily.com.ts_entity.pro.TsProMemPri;
import vitily.com.tv_entity.mem.TvMemGroup;
import vitily.com.util.CommonUtil;

@Component
public class MemGroupServiceImpl extends BasicServiceImpl<TbMemGroup,TsMemGroup,TvMemGroup> implements MemGroupService {

	final
	MemGroupMapper memGroupMapperoup;
	final
	ProMemPriMapper proMemPriMapper;

	@Autowired()
	public MemGroupServiceImpl(MemGroupMapper memGroupMapperoup,
							   ProMemPriMapper proMemPriMapper) {
		this.memGroupMapperoup = memGroupMapperoup;
		this.proMemPriMapper = proMemPriMapper;
		super.setBaseMapper(memGroupMapperoup);
	}

	@Override
	public int insert(TsMemGroup bean) throws Exception{
		if(memGroupMapperoup.isExists(bean)){
			throw new DuplicateDataException("会员分组名字重复");
		}
		updateOtherByCheck(bean.getEntity());
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return memGroupMapperoup.insertSelective(bean.getEntity());
	}
	@Override
	public int update(TsMemGroup bean) throws Exception{
		if(memGroupMapperoup.isExists(bean)){
			throw new DuplicateDataException("会员分组名字重复");
		}
		updateOtherByCheck(bean.getEntity());
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		return memGroupMapperoup.updateByPrimaryKeySelective(bean.getEntity());
	}
	@Override
	public void updateDeltag(TbMemGroup bean,List<Integer> ids,int delTag)throws Exception{
		for (Integer id : ids) {
			bean.setId(id);
			bean.setDeltag(delTag);
			bean.setState(null);
			bean.setUpdateDate(new Date());
			getBaseMapper().updateByPrimaryKeySelective(bean);
			TsProMemPri delProMemPri = new TsProMemPri();
			delProMemPri.getEntity().setUpdateDate(new Date());
			delProMemPri.getEntity().setDeltag(DelTagDesc.已删除.getValue());
			delProMemPri.getEntity().setGroupId(bean.getId());
			proMemPriMapper.updateByBean(delProMemPri);
		}
	}

	protected void updateOtherByCheck(TbMemGroup entity)throws Exception{
		//如果是默认的则更新其他默认组为非默认组
		TsMemGroup upOtherBean = new TsMemGroup();
		if(CommonUtil.isEqual(DefaultDesc.是.getValue(), entity.getIsDefault())){
			upOtherBean.getEntity().setName(null);
			upOtherBean.getEntity().setDeltag(null);
			upOtherBean.getEntity().setId(0);
			upOtherBean.setDefaultStr(String.valueOf(DefaultDesc.是.getValue()));
			upOtherBean.getEntity().setIsDefault(DefaultDesc.否.getValue());
			memGroupMapperoup.updateByBean(upOtherBean);
		}
	}

}
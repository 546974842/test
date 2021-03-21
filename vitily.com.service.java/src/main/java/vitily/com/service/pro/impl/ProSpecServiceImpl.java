package vitily.com.service.pro.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.consts.DelTagDesc;
import vitily.com.consts.StateDesc;
import vitily.com.tb_entity.comm.TbType;
import vitily.com.tb_entity.pro.TbProSpAttr;
import vitily.com.tb_entity.pro.TbProSpec;
import vitily.com.mapper.comm.TypeMapper;
import vitily.com.mapper.pro.ProSpAttrMapper;
import vitily.com.mapper.pro.ProSpecMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.pro.ProSpecService;
import vitily.com.ts_entity.pro.TsProSpAttr;
import vitily.com.ts_entity.pro.TsProSpec;
import vitily.com.tv_entity.pro.TvProSpec;
import vitily.com.util.CommonUtil;

@Component
public class ProSpecServiceImpl extends BasicServiceImpl<TbProSpec,TsProSpec,TvProSpec> implements ProSpecService {

	final
	ProSpecMapper proSpecMapper;
	final
	ProSpAttrMapper proSpAttrMapper;
	final
	TypeMapper typeMapper;

	@Autowired()
	public ProSpecServiceImpl(ProSpecMapper proSpecMapper,
							  ProSpAttrMapper proSpAttrMapper,
							  TypeMapper typeMapper) {
		this.proSpecMapper = proSpecMapper;
		this.proSpAttrMapper = proSpAttrMapper;
		this.typeMapper = typeMapper;
		super.setBaseMapper(proSpecMapper);
	}

	@SuppressWarnings("unchecked")
	@Override
	public TvProSpec selectByPrimaryKeyForTv(int id){
		TvProSpec tvSpec=proSpecMapper.selectByPrimaryKeyForTv(id);
		TsProSpAttr searchPar=new TsProSpAttr();
		searchPar.getEntity().setSpecId(id);
		List<TbProSpAttr> pars=(List<TbProSpAttr>)proSpAttrMapper.getListByBean(searchPar);
		tvSpec.setPars(pars);
		return tvSpec;
	}
	@Override
	public int insert(TsProSpec bean) throws Exception{
		TbProSpec entity = bean.getEntity();
		entity.setName(entity.getName().replaceAll("[,|]", "-"));
		TsProSpec queryEntity=new TsProSpec();
		queryEntity.getEntity().setName(entity.getName());
		if(proSpecMapper.isExists(queryEntity)){
			throw new DuplicateDataException("名字重复");
		}
		Date now=new Date();
		entity.setCreateDate(now);
		entity.setUpdateDate(now);
		int cal=proSpecMapper.insertSelective(entity);
		//添加参数
		if(!CommonUtil.isNull(bean.getPars())){
			for(TbProSpAttr item:bean.getPars()){
				item.setSpecId(entity.getId());
				item.setCreateDate(now);
				item.setUpdateDate(now);
				item.setName(item.getName().replaceAll("[,|]", "-"));
				item.setState(StateDesc.正常.getValue());
				item.setDeltag(DelTagDesc.正常.getValue());
				proSpAttrMapper.insertSelective(item);
			}
		}
		return cal;
	}
	/**
	 * 修改：检查是否存在
	 * @param entity 1
	 * @throws Exception 3
	 */
	@Override
	public int update(TsProSpec bean) throws Exception{
		Date now=new Date();
		TbProSpec entity = bean.getEntity();
		bean.getEntity().setName(bean.getEntity().getName().replaceAll("[,|]", "-"));
		if(proSpecMapper.isExists(bean)){
			throw new DuplicateDataException("名字重复");
		}
		
		/* 有则更新无则增加 */
		if(!CommonUtil.isNull(bean.getPars())){
			for(TbProSpAttr item:bean.getPars()){
				item.setSpecId(entity.getId());
				item.setUpdateDate(now);
				item.setName(item.getName().replaceAll("[,|]", "-"));
				if(item.getId() > 0){
					proSpAttrMapper.updateByPrimaryKeySelective(item);
				}else{
					item.setState(StateDesc.正常.getValue());
					item.setDeltag(DelTagDesc.正常.getValue());
					item.setCreateDate(now);
					proSpAttrMapper.insertSelective(item);
				}
			}
		}
		
		//删除的specParIds
		if(CommonUtil.isNumOrD(bean.getDelParIds())){
			String[] parIds=bean.getDelParIds().split(",");
			for(String item:parIds){
				TbProSpAttr par=new TbProSpAttr();
				par.setId(Integer.parseInt(item));
				par.setUpdateDate(now);
				par.setDeltag(DelTagDesc.已删除.getValue());
				proSpAttrMapper.updateByPrimaryKeySelective(par);
			}
		}
		entity.setUpdateDate(now);
		return proSpecMapper.updateByPrimaryKeySelective(entity);
	}

	public List<TvProSpec> getSpecList(Integer typeId)throws Exception{

		TsProSpec searchEntity=new TsProSpec();
		if(!CommonUtil.isNull(typeId)){
			TbType type=typeMapper.selectByPrimaryKey(typeId);
			if(!CommonUtil.isNull(type)){
				if(type.getSpecIds().length() > 0){
					searchEntity.setIdStr(type.getSpecIds());
				}else{
					searchEntity.setIdStr("0");//米有
				}
			}
		}
		searchEntity.getEntity().setState(StateDesc.正常.getValue());
		@SuppressWarnings("unchecked")
		List<TvProSpec> list=(List<TvProSpec>)proSpecMapper.getListByBean(searchEntity);
		for(TvProSpec item:list){
			TsProSpAttr searchPar=new TsProSpAttr();
			searchPar.getEntity().setSpecId(item.getId());
			@SuppressWarnings("unchecked")
			List<TbProSpAttr> pars=(List<TbProSpAttr>)proSpAttrMapper.getListByBean(searchPar);
			item.setPars(pars);
		}
		return list;
	}
}

package vitily.com.service.comm.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbDynProper;
import vitily.com.tb_entity.comm.TbType;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.ts_entity.comm.TsDynProper;
import vitily.com.ts_entity.comm.TsType;
import vitily.com.tv_entity.comm.TvType;
import vitily.com.consts.DelTagDesc;
import vitily.com.mapper.comm.DynProperMapper;
import vitily.com.mapper.comm.TypeMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.TypeService;
import vitily.com.util.CommonUtil;

@Component
public class TypeServiceImpl extends BasicServiceImpl<TbType,TsType,TvType> implements TypeService {

    final
    TypeMapper typeMapper;
	final
    DynProperMapper dynProperMapper;

    @Autowired
    public TypeServiceImpl(TypeMapper typeMapper,
                           DynProperMapper dynProperMapper) {
        this.typeMapper = typeMapper;
        this.dynProperMapper = dynProperMapper;
        super.setBaseMapper(typeMapper);
    }

	@Override
    public TvType selectByPrimaryKeyForTv(int id){
        TvType entity=typeMapper.selectByPrimaryKeyForTv(id);
        if(CommonUtil.isNull(entity)){
        	return null;
        }
        TsDynProper searchDyn=new TsDynProper();
        searchDyn.getEntity().setTypeId(id);
        List<TbDynProper> dyns=(List<TbDynProper>)dynProperMapper.getListByBean(searchDyn);
        entity.setDyns(dyns);
        return entity;
    }

    @Override
    public int insert(TsType bean)throws Exception{
        if(typeMapper.isExists(bean)){
            throw new DuplicateDataException("已存在相同名字的类型！");
        }
        Date now=new Date();
        CommonUtil.formartInsertEnntity(bean.getEntity());
        int cal=typeMapper.insertSelective(bean.getEntity());
        //添加参数
        if(!CommonUtil.isNull(bean.getDyns())){
            for(TbDynProper item:bean.getDyns()){
                item.setTypeId(bean.getEntity().getId());
                item.setCreateDate(now);
                item.setUpdateDate(now);
                item.setDeltag(DelTagDesc.正常.getValue());
                dynProperMapper.insertSelective(item);
            }
        }
        return cal;
    }
    @Override
	public int update(TsType bean) throws Exception{
		if(typeMapper.isExists(bean)){
            throw new DuplicateDataException("已存在相同名字的类型！");
		}
		Date now=new Date();
        bean.getEntity().setUpdateDate(now);
        int res = typeMapper.updateByPrimaryKeySelective(bean.getEntity());

        //有则更新无则增加
        if(!CommonUtil.isNull(bean.getDyns())){
            for(TbDynProper item:bean.getDyns()){
                item.setTypeId(bean.getEntity().getId());
                item.setUpdateDate(now);
                if(item.getId() > 0){
                    dynProperMapper.updateByPrimaryKeySelective(item);
                }else{
                    item.setCreateDate(now);
                    item.setDeltag(DelTagDesc.正常.getValue());
                    dynProperMapper.insertSelective(item);
                }
            }
        }
        //删除的 delDynIds
        if(CommonUtil.isNumOrD(bean.getDelDynIds())){
            String[] dynIds=bean.getDelDynIds().split(",");
            TbDynProper dyn=new TbDynProper();
            for(String item:dynIds){
                dyn.setId(Integer.parseInt(item));
                dyn.setUpdateDate(now);
                dyn.setDeltag(DelTagDesc.已删除.getValue());
                dynProperMapper.updateByPrimaryKeySelective(dyn);
            }
        }
        return res;
	}
}
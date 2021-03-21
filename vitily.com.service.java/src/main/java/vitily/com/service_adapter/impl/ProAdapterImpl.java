package vitily.com.service_adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.consts.DelTagDesc;
import vitily.com.consts.StateDesc;
import vitily.com.mapper.comm.DynProperMapper;
import vitily.com.tb_entity.pro.TbProDynproVal;
import vitily.com.tb_entity.pro.TbProMemPri;
import vitily.com.mapper.pro.ProDynproValMapper;
import vitily.com.mapper.pro.ProMemPriMapper;
import vitily.com.service_adapter.ProAdapter;
import vitily.com.ts_entity.comm.TsDynProper;
import vitily.com.tv_entity.comm.TvDynProper;
import vitily.com.tv_entity.pro.TvProMemPri;
import vitily.com.util.CommonUtil;

import java.util.Date;
import java.util.List;

@Component
public class ProAdapterImpl implements ProAdapter{
    @Autowired
    DynProperMapper dynProperMapper;
    @Autowired
    ProDynproValMapper proDynproValMapper;
    @Autowired
    ProMemPriMapper proMemPriMapper;
    @Override
    public void bitInsertProDynproVals(Integer typeId,Integer productId,Date now,String guid,List<TbProDynproVal> gens){
        TsDynProper searchBean=new TsDynProper();
        searchBean.getEntity().setTypeId(typeId);
        @SuppressWarnings("unchecked")
        List<TvDynProper> list=(List<TvDynProper>)dynProperMapper.getListByBean(searchBean);
        if(list.size() != gens.size()){
            return;
        }
        for(int i = 0;i<gens.size();++i){
            TbProDynproVal item = gens.get(i);
            TvDynProper e = list.get(i);
            item.setState(StateDesc.正常.getValue());
            item.setDeltag(DelTagDesc.正常.getValue());
            item.setSort(e.getSort());
            item.setProperName(e.getName());
            item.setProductId(productId);
            item.setCreateDate(now);
            item.setProperId(e.getId());
            item.setGuid(guid);
            proDynproValMapper.insertSelective(item);
        }
    }
    @Override
    public void bitInsertProMemPris(Integer productId,String guid,Date now,Integer specParProId,String specParIds,List<TvProMemPri> pmps)throws Exception{
        for(TbProMemPri item:pmps){
            item.setProductId(productId);
            item.setCreateDate(now);
            item.setGuid(guid);
            item.setDeltag(DelTagDesc.正常.getValue());
            item.setState(StateDesc.正常.getValue());
            item.setSort(0.0D);
            if(CommonUtil.isNotNull(specParProId)){
                item.setSpecParProId(specParProId);
            }
            if(CommonUtil.isNotNull(specParIds)){
                item.setSpecParIds(specParIds);
            }
            proMemPriMapper.insertSelective(item);
        }
    }
}

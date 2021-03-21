package vitily.com.service_adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.consts.DelTagDesc;
import vitily.com.consts.StateDesc;
import vitily.com.tb_entity.cms.TbCmsDynproVal;
import vitily.com.mapper.cms.CmsDynproValMapper;
import vitily.com.mapper.comm.DynProperMapper;
import vitily.com.service_adapter.CmsNewsAdapter;
import vitily.com.ts_entity.comm.TsDynProper;
import vitily.com.tv_entity.comm.TvDynProper;

import java.util.Date;
import java.util.List;

@Component
public class CmsNewsAdapterImpl implements CmsNewsAdapter {
    @Autowired
    DynProperMapper dynProperMapper;
    @Autowired
    CmsDynproValMapper cmsDynproValMapper;
    @Override
    public void bitInsertCmsDynproVals(Integer typeId,Integer newsId,String guid,List<TbCmsDynproVal> gens)throws Exception{
        TsDynProper searchBean=new TsDynProper();
        searchBean.getEntity().setTypeId(typeId);
        @SuppressWarnings("unchecked")
        List<TvDynProper> list=(List<TvDynProper>)dynProperMapper.getListByBean(searchBean);
        if(list.size() != gens.size()){
            return;
        }
        for(int i = 0;i<gens.size();++i){
            TbCmsDynproVal item = gens.get(i);
            TvDynProper e = list.get(i);
            item.setState(StateDesc.正常.getValue());
            item.setDeltag(DelTagDesc.正常.getValue());
            item.setSort(e.getSort());
            item.setProperName(e.getName());
            item.setNewsId(newsId);
            item.setCreateDate(new Date());
            item.setProperId(e.getId());
            item.setGuid(guid);
            cmsDynproValMapper.insertSelective(item);
        }
    }
}

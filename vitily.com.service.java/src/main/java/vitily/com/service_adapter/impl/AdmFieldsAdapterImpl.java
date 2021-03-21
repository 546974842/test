package vitily.com.service_adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.base.ts_entity.PageInfo;
import vitily.com.consts.Const;
import vitily.com.consts.StateDesc;
import vitily.com.mapper.adm.AdmFieldsMapper;
import vitily.com.service_adapter.AdmFieldsAdapter;
import vitily.com.ts_entity.adm.TsAdmFields;
import vitily.com.tv_entity.adm.TvAdmFields;
import vitily.com.util.CommonUtil;

import java.util.List;

@Component
public class AdmFieldsAdapterImpl implements AdmFieldsAdapter {
    private static List<TvAdmFields> cacheFields;
    @Autowired
    AdmFieldsMapper admFieldsMapper;
    /**
     * 获取缓存
     * @return 1
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TvAdmFields> getCacheFieldShows(){
        if(CommonUtil.isNull(cacheFields) || cacheFields.size() < 1){
            TsAdmFields queryEntity = new TsAdmFields();
            queryEntity.setPageInfo(new PageInfo());
            queryEntity.getEntity().setState(StateDesc.正常.getValue());
            queryEntity.getPageInfo().setSortField("e.sort");
            queryEntity.getPageInfo().setSortDistanct("asc");
            queryEntity.getPageInfo().setPageSize(Const.COMMON_MAX_PAGESIZE);
            cacheFields = (List <TvAdmFields>) admFieldsMapper.getListByBean(queryEntity);
        }
        return cacheFields;
    }
}

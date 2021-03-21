package vitily.com.service.adm.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.adm.TbAdmFields;
import vitily.com.mapper.adm.AdmFieldsMapper;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.adm.AdmFieldsService;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service_adapter.AdmFieldsAdapter;
import vitily.com.ts_entity.adm.TsAdmFields;
import vitily.com.tv_entity.adm.TvAdmFields;
import vitily.com.util.CommonUtil;

@Component
public class AdmFieldsServiceImpl extends BasicServiceImpl<TbAdmFields,TsAdmFields,TvAdmFields> implements AdmFieldsService {

	final AdmFieldsMapper admFieldsMapper;
	final AdmFieldsAdapter admFieldsAdapter;

	@Autowired()
	public AdmFieldsServiceImpl(AdmFieldsMapper admFieldsMapper,AdmFieldsAdapter admFieldsAdapter) {
		this.admFieldsMapper = admFieldsMapper;
		this.admFieldsAdapter = admFieldsAdapter;
		super.setBaseMapper(admFieldsMapper);
	}
	
	@Override
	public int insert(TsAdmFields bean) throws Exception{
		if(admFieldsMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的字段！");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return admFieldsMapper.insertSelective(bean.getEntity());
	}
	@Override
	public int update(TsAdmFields bean) throws Exception{
		if(admFieldsMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的字段！");
		}
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		return admFieldsMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
    /**
     * 根据栏目id列出内容
     * @param columnId 1
     * @return 2
     */
    public List<TvAdmFields> getFieldShowByColumnId(int columnId){
        List<TvAdmFields> fieldShows=new ArrayList<>();
        List<TvAdmFields> _caches = admFieldsAdapter.getCacheFieldShows();
        for(TvAdmFields item:_caches){
        	if(CommonUtil.isEqual(item.getColumnId(), columnId) || CommonUtil.isEqual(item.getColumnId(), 0)){
        		fieldShows.add(item);
        	}
        }
        return fieldShows;
    }
}

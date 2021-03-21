package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.cache.DictionaryCache;
import vitily.com.tb_entity.comm.TbDictionary;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.ts_entity.comm.TsDictionary;
import vitily.com.tv_entity.comm.TvDictionary;
import vitily.com.mapper.comm.DictionaryMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.DictionaryService;
import vitily.com.util.CommonUtil;

@Component
public class DictionaryServiceImpl extends BasicServiceImpl<TbDictionary,TsDictionary,TvDictionary> implements DictionaryService {


	final
	DictionaryMapper dictionaryMapper;
	final
	DictionaryCache dictionaryCache;

	@Autowired()
	public DictionaryServiceImpl(DictionaryMapper dictionaryMapper,
                              DictionaryCache dictionaryCache
	) {
		this.dictionaryCache = dictionaryCache;
		this.dictionaryMapper = dictionaryMapper;
		super.setBaseMapper(dictionaryMapper);
	}

	@Override
	public int insert(TsDictionary bean) throws Exception{
		if(dictionaryMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的字典！");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		int res = dictionaryMapper.insertSelective(bean.getEntity());
		if(res > 0 ){
			dictionaryCache.setDictionary(bean.getEntity());
		}
		return res;
	}
	@Override
	public int update(TsDictionary bean) throws Exception{
		if(dictionaryMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的字典！");
		}
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		int res = dictionaryMapper.updateByPrimaryKeySelective(bean.getEntity());
		if(res > 0 ){
			//dictionaryCache.setDictionary(bean.getEntity());
		}
		return res;
	}
	public void updateByDicKey(TbDictionary entity){
		dictionaryMapper.updateByDicKey(entity);
	}
}
package vitily.com.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.cache.CommonServiceCache;
import vitily.com.cache.DictionaryCache;
import vitily.com.consts.DictionaryKey;
import vitily.com.util.CommonUtil;
import vitily.com.util.cache.ViyBasicCache;

import java.util.HashMap;

/**
 * 公共缓存：判断是否存在的依据
 * @author lether
 *
 */
@Component
public class CommonServiceCacheImpl extends BaseCacheImpl implements CommonServiceCache{

	private static HashMap<DictionaryKey.Keys, CommonServiceCache> cacheMap=new HashMap<>();

	DictionaryCache dictionaryCache;
	ViyBasicCache viyCache;
	public CommonServiceCache getInstance(DictionaryKey.Keys key){
		CommonServiceCache cache=cacheMap.get(key);
		if(CommonUtil.isNull(cache)){
			cache = new CommonServiceCacheImpl(key,dictionaryCache,viyCache);
			cacheMap.put(key, cache);
		}
		return cache;
	}
	@Autowired
	public CommonServiceCacheImpl(DictionaryCache dictionaryCache, ViyBasicCache viyBasicCache){
		super(DictionaryKey.Keys.其他.getValue(),null,dictionaryCache,viyBasicCache);
		this.dictionaryCache = dictionaryCache;
		this.viyCache = viyBasicCache;
	}
	/**
	 * 单一
	 */
	public CommonServiceCacheImpl(DictionaryKey.Keys key,DictionaryCache dictionaryCache,ViyBasicCache viyBasicCache){
		super(key.getValue(),null,dictionaryCache,viyBasicCache);
		this.dictionaryCache=dictionaryCache;
		this.viyCache=viyBasicCache;
	}
}

package vitily.com.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.cache.ComServiceFrequentCache;
import vitily.com.cache.CommonServiceCache;
import vitily.com.consts.DictionaryKey;
import vitily.com.util.CommonUtil;
import vitily.com.util.NumberUtil;

/**
 * 公共缓存保存次数
 * 
 * @author lether
 *
 */
@Component
public final class ComServiceFrequentCacheImpl implements ComServiceFrequentCache{

	CommonServiceCache commonServiceCache;
	private static volatile boolean init;

	@Autowired
	public ComServiceFrequentCacheImpl(CommonServiceCache commonServiceCache) {
		if(init){
			this.commonServiceCache = commonServiceCache;
		}else{
			init = true;
			this.commonServiceCache = commonServiceCache.getInstance(DictionaryKey.Keys.公共缓存次数保存时长);
		}

	}
	public ComServiceFrequentCache decorate(DictionaryKey.Keys k){
		return new ComServiceFrequentCacheImpl(commonServiceCache.getInstance(k));
	}
	private String getLastKey(DictionaryKey.MemServiceKeyType type,String key){
		return type.getValue() + "_count_" + key;
	}
	/**
	 *
	 */
	public void setToServer(DictionaryKey.MemServiceKeyType type,String key)throws Exception{
		String lastKey=getLastKey(type,key);
		Integer count=NumberUtil.toInteger(this.commonServiceCache.getFromServer(lastKey));
		if(CommonUtil.isNull(count)){
			count = 0;
		}
		++count;
		this.commonServiceCache.setToServer(lastKey, count);
	}
	public int getCache(DictionaryKey.MemServiceKeyType type,String key)throws Exception{
		String lastKey=getLastKey(type,key);
		Integer count=NumberUtil.toInteger(this.commonServiceCache.getFromServer(lastKey));
		if(CommonUtil.isNull(count)){
			count = 0;
		}
		return count;
	}
	public void removeFromServer(DictionaryKey.MemServiceKeyType type,String key)throws Exception{
		String lastKey=getLastKey(type,key);
		this.commonServiceCache.removeFromServer(lastKey);
	}
}

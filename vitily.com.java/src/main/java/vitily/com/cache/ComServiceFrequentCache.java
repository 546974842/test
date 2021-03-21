package vitily.com.cache;

import vitily.com.consts.DictionaryKey;

/**
 * 公共缓存保存次数
 * 注意这里不继承
 * 
 * @author lether
 *
 */
public interface ComServiceFrequentCache{

	void setToServer(DictionaryKey.MemServiceKeyType type, String key)throws Exception;
	int getCache(DictionaryKey.MemServiceKeyType type, String key)throws Exception;
	void removeFromServer(DictionaryKey.MemServiceKeyType type, String key)throws Exception;
	ComServiceFrequentCache decorate(DictionaryKey.Keys k);
}

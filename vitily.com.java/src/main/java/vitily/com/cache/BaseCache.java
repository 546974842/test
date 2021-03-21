package vitily.com.cache;


import java.util.List;
import java.util.Map;

/**
 * 通用缓存
 * @author lether
 *
 */
public interface BaseCache {
	Integer getSeconds();
	void setToServer(String key, Object value)throws Exception;
	void setToServer(String key, Object value, Integer seconds)throws Exception;
	Object getFromServer(String key)throws Exception;
	/**
	 * 只更新值，不更新失效时间
	 * @param key
	 * @param value
	 */
	void upToServer(String key,Object value)throws Exception;
	void removeFromServer(String key)throws Exception;
	boolean existsInServer(String key);
	/**
	 * 入列队
	 * @param key 1
	 * @param value 2
	 */
	void lpush(String key, Object value)throws Exception;
	/**
	 * 出列队
	 * @param key 1
	 * @return 2
	 */
	Object rpop(String key)throws Exception;
//=====================map操作=============================//
	Long hset(String key, String field, Object value)throws Exception;
	String hmset(String key, Map <String, ?> map)throws Exception;
	Object hget(String key, String field)throws Exception;
	List<Object> hmget(String key, String... fileds)throws Exception;
	Map<String, ?> hgetAll(String key)throws Exception;
	Long hdel(String key, String field)throws Exception;
}

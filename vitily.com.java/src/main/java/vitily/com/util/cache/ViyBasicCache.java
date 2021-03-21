package vitily.com.util.cache;

import java.util.List;
import java.util.Map;

public interface ViyBasicCache {
    boolean put(String key,Object value,boolean isLock)throws Exception;
    boolean put(String key,Object value,int seconds,boolean isLock)throws Exception;
    Object get(String key)throws Exception;
    long ttl(String key)throws Exception;
    boolean update(String key,Object value,boolean isLock)throws Exception;
    boolean remove(String key)throws Exception;
    boolean exists(String key)throws Exception;
    Long lpush(String key,Object value)throws Exception;
    Object rpop(String key)throws Exception;
    Long hset(String key,String field,Object value)throws Exception;
    String hmset(String key,Map<String,?> map)throws Exception;
    Object hget(String key,String field)throws Exception;
    List<Object> hmget(String key, String...fields)throws Exception;
    Map<String,?> hgetAll(String key)throws Exception;
    Long hdel(String key,String field)throws Exception;
}

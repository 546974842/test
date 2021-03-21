package vitily.com.util.cache.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
import vitily.com.other_entity.NoExistsException;
import vitily.com.util.CommonUtil;
import vitily.com.util.PropertyConfigure;
import vitily.com.util.cache.ViyBasicCache;
import vitily.com.util.log.LogAdapter;
import net.sf.ehcache.Element;

/**
 * Created by whh 
 */
public final class EhcacheImpl implements ViyBasicCache{
	static public LogAdapter logger= LogAdapter.getLogAdapter(EhcacheImpl.class);

    private Cache cache;
    private static volatile ViyBasicCache ehcacheUtil;
    EhcacheImpl(PropertyConfigure configure) {
		cache = new Cache(
				configure.getProperty("spring.ehcache.name"),
				Integer.valueOf(configure.getProperty("spring.ehcache.maxElementsInMemory")),
				MemoryStoreEvictionPolicy.fromString("spring.ehcache.memoryStoreEvictionPolicy"),
				true,
				null,
				false,
				Long.valueOf(configure.getProperty("spring.ehcache.timeToLiveSeconds")),
				Long.valueOf(configure.getProperty("spring.ehcache.timeToIdleSeconds")),
				false,
				Long.valueOf(configure.getProperty("spring.ehcache.diskExpiryThreadIntervalSeconds")),
				null
				);
        CacheManager manager = CacheManager.create();
        manager.addCache(cache);
    }

    public static ViyBasicCache getInstance(PropertyConfigure propertyConfigure) {
        if(CommonUtil.isNull(ehcacheUtil)){
            ehcacheUtil = new EhcacheImpl(propertyConfigure);
        }
        return ehcacheUtil;
    }
    public boolean put(String key,Object value,boolean isLock)throws Exception{
		if(CommonUtil.isNull(key) || CommonUtil.isNull(value)){
			return false;
		}
		Element element = new Element(key,value);
		element.setTimeToLive(60*60*24*365*10);
		cache.put(element);
		return true;
	}
	/**
	 *加入缓存对象:本地缓存
	 *存在更新
	 *注意，已验证:
	 *1,保存的如果是对象那么ehcache存的是对象的引用：
	 *2,但是如果是string等内置类型的话就是保存string了
	 * @param key
	 * @param value
	 * @param second 秒数
	 */
	public boolean put(String key,Object value,int second,boolean isLock)throws Exception{
		if(CommonUtil.isNull(key) || CommonUtil.isNull(value)){
			return false;
		}
		Element element = new Element(key,value);
		element.setTimeToLive(second);
		cache.put(element);
		return true;
	}

	/**
	 * 获取缓存对象
	 *
	 * @param key
	 * @return
	 */
	public Object get(String key)throws Exception{
		if(CommonUtil.isNull(key)){
			return null;
		}
		Element element = cache.get(key);
		return CommonUtil.isNotNull(element) ? element.getValue() : null;
	}
	public long ttl(String key)throws Exception{
		return 0;
	}

    public boolean update(String key,Object value,boolean isLock)throws Exception{
		if(CommonUtil.isNull(key) || CommonUtil.isNull(value)){
			return false;
		}
		Element element = cache.get(key);
		if(CommonUtil.isNull(element)){
			return false;
		}
		Element upEle = new Element(key,value);
		upEle.setTimeToLive(element.getTimeToLive());
		cache.remove(key);//先删
		cache.put(upEle);
		return true;
	}

    //删除缓存对象
    public boolean remove(String key)throws Exception{
		if(CommonUtil.isNull(key)){
            return false;
        }
        logger.debug("删除缓存对象 key : "+key );
        return cache.remove(key);
    }
    public boolean exists(String key)throws Exception{
		return CommonUtil.isNotNull(get(key));
	}
    /**
     * 左边入队
     * @param key
     */
    public Long lpush(String key,Object value)throws Exception{
    	BlockingDeque<Object> queue = (BlockingDeque<Object>)get(key);
		if(CommonUtil.isNull(queue)){
    		queue = new LinkedBlockingDeque<>();
        	put(key, queue, 60*60*24*365*10,true);//10年
    	}
    	queue.addFirst(value);
		return 1L;
    }
    /**
     * 右出队
     * @param key
     * @return
     */
    public Object rpop(String key)throws Exception{
    	BlockingDeque<Object> queue = (BlockingDeque<Object>)get(key);
		if(CommonUtil.isNotNull(queue)){
    		return queue.pollLast();
    	}
    	return null;
    }
    /**
     * hset ：map
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Long hset(String key,String field,Object value)throws Exception{
		Map<String, Object> map= (Map<String, Object>)get(key);
		if(CommonUtil.isNull(map)){
			map = new ConcurrentHashMap<>();
			put(key, map, 60*60*24*365*10,true);//10年
		}
		map.put(field, value);
    	return 1L;
    }
    public String hmset(String key,Map<String, ?> map)throws Exception{
		put(key, map, 60*60*24*365*10,true);//10年
    	return "1";
    }
	public Object hget(String key,String field)throws Exception{
		Map<String, Object> map= (Map<String, Object>)get(key);
		if(CommonUtil.isNotNull(map)){
			return map.get(field);
		}
		return null;
	}
	public List<Object> hmget(String key,String...fileds)throws Exception{
    	Map<String, Object> map= (Map<String, Object>)get(key);
    	List<Object> list= new ArrayList<>();
        if(CommonUtil.isNotNull(map)){
    		for(String s:fileds){
                Object e = map.get(s);
                if(CommonUtil.isNotNull(e)){
    				list.add(e);
    			}
    		}
    	}
    	return list;
	}
	public Map<String,?> hgetAll(String key)throws Exception{
		return (Map<String,?>)get(key);
	}
	public Long hdel(String key,String field)throws Exception{
		Map<String, Object> map= (Map<String, Object>)get(key);
		if(CommonUtil.isNull(map)){
			throw new NoExistsException("无map在缓存中");
		}
		Object e = map.remove(field);
		return CommonUtil.isNotNull(e) ? 1L : 0L;
	}

}


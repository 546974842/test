package vitily.com.util.cache.impl;

import redis.clients.jedis.*;
import vitily.com.util.CommonUtil;
import vitily.com.util.PropertyConfigure;
import vitily.com.util.SerializeUtil;
import vitily.com.util.cache.ViyBasicCache;

import java.util.*;

/**
 * jedis 操作 redis 类：集群模式
 * @author lether
 *
 */
public class JedisPoolImpl implements ViyBasicCache{
	private JedisPool pool;
    private static volatile ViyBasicCache viyBasicCache;
	JedisPoolImpl(PropertyConfigure configure){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(Integer.valueOf(configure.getProperty("spring.redis.pool.max-active")));
        poolConfig.setMaxIdle(Integer.valueOf(configure.getProperty("spring.redis.pool.max-idle")));
        poolConfig.setMinIdle(Integer.valueOf(configure.getProperty("spring.redis.pool.min-idle")));
        poolConfig.setMaxWaitMillis(Long.valueOf(configure.getProperty("spring.redis.pool.max-wait")));
        poolConfig.setTestOnBorrow(true);
        pool = new JedisPool(poolConfig,
                configure.getProperty("spring.redis.host"),
                Integer.valueOf(configure.getProperty("spring.redis.port")),
                Integer.valueOf(configure.getProperty("spring.redis.cluster.soTimeout")),
                configure.getProperty("spring.redis.password")
        );
    }
    public static ViyBasicCache getInstance(PropertyConfigure propertyConfigure){
        if(CommonUtil.isNull(viyBasicCache)){
            viyBasicCache = new JedisPoolImpl(propertyConfigure);
        }
        return viyBasicCache;
    }
	/**
	 * 上锁的话不用分布式锁，只在一台机子上锁
	 * @param key
	 * @param value
	 * @param isLock
	 * @return
	 */
	public boolean put(String key,Object value,boolean isLock)throws Exception {
		if(CommonUtil.isNull(value)){
			return false;
		}
		byte[] btKey =  key.getBytes();
		byte[] btValue = SerializeUtil.serialize(value);
        try(Jedis jedis = pool.getResource()) {
            if (isLock) {
                jedis.setnx(btKey, btValue);
            } else {
                jedis.set(btKey, btValue);
            }
        }
		return true;
	}
    /**
     * 配置缓存数据
     * @param key
     * @param value: 如果不是string，必须是可以序列化的,不允许存储null
     * @param endTime
     */
    public boolean put(String key,Object value,int seconds,boolean isLock)throws Exception{
        if(CommonUtil.isNull(value)){
            return false;
        }
        byte[] btKey =  key.getBytes();
        byte[] btValue = SerializeUtil.serialize(value);
        try(Jedis jedis = pool.getResource()) {
            jedis.setex(btKey, seconds, btValue);
        }
        return true;
    }
    /**
     * 获取缓存中数据
     * @param key
     * @return
     */
    public Object get(String key)throws Exception{
        byte[] value;
        try(Jedis jedis = pool.getResource()) {
            value = jedis.get(key.getBytes());
        }
        Object target = null;
        if(CommonUtil.isNotNull(value) && value.length > 0){
            target = SerializeUtil. unserialize(value);
        }
        return target;
    }
	public long ttl(String key)throws Exception{
        long exp;
        byte[] btKey =  key.getBytes();
        try(Jedis jedis = pool.getResource()) {
            exp = jedis.ttl(btKey);
        }
        return exp;
    }
    public boolean update(String key,Object value,boolean isLock)throws Exception{
        if(CommonUtil.isNull(value)){
            return false;
        }
        byte[] btKey =  key.getBytes();
        byte[] btValue = SerializeUtil.serialize(value);
        try(Jedis jedis = pool.getResource()) {
            long seconds =  jedis.ttl(btKey);
            if(seconds < -1){
                return false;
            }
            jedis.setex(btKey, (int)seconds, btValue);
        }
        return true;
    }
	public boolean remove(String key)throws Exception{
        boolean ok = false;
        try(Jedis jedis = pool.getResource()) {
            ok = jedis.del(key.getBytes()) > 0;
        }
        return ok;
	}
	public boolean exists(String key)throws Exception{
	    boolean ex;
        try(Jedis jedis = pool.getResource()){
            ex = jedis.exists(key.getBytes());
        }
        return ex;
	}
	public Long lpush(String key,Object value)throws Exception{
	    long res = 0L;
		if(CommonUtil.isNotNull(value)){
            try(Jedis jedis = pool.getResource()) {
                res = jedis.lpush(key.getBytes(), SerializeUtil.serialize(value));
            }
		}
		return res;
	}
	public Object rpop(String key)throws Exception{
        byte[] value;
        try(Jedis jedis = pool.getResource()) {
            value = jedis.rpop(key.getBytes());
        }
        Object target = null;
        if(CommonUtil.isNotNull(value) && value.length > 0){
			target = SerializeUtil. unserialize(value);
		}
        return target;
	}
	public Long hset(String key,String field,Object value)throws Exception{
	    long res;
        try(Jedis jedis = pool.getResource()) {
            res = jedis.hset(key.getBytes(), field.getBytes(), SerializeUtil.serialize(value));
        }
        return res;
	}
	public String hmset(String key,Map<String,?> map)throws Exception{
		Map<byte[],byte[]> bmap = new HashMap<>();
		for(Map.Entry<String, ?> item:map.entrySet()){
			bmap.put(item.getKey().getBytes(), SerializeUtil.serialize(item.getValue()));
		}
        try(Jedis jedis = pool.getResource()) {
            return jedis.hmset(key.getBytes(),bmap);
        }
	}
	public Object hget(String key,String field)throws Exception{
        byte[] bts;
        try(Jedis jedis = pool.getResource()) {
            bts = jedis.hget(key.getBytes(), field.getBytes());
        }
        return SerializeUtil.unserialize(bts);
	}
	public List<Object> hmget(String key,String...fields)throws Exception{
		byte[][] bts= new byte[fields.length][];
		for(int i=0;i<fields.length;++i){
			bts[i] = fields[i].getBytes();
		}
        List <byte[]> blist;
        try(Jedis jedis = pool.getResource()){
            blist = jedis.hmget(key.getBytes(), bts);
        }
        List<Object> olist = new ArrayList<>();
		for(byte[] bt:blist){
			olist.add(SerializeUtil.unserialize(bt));
		}
		return olist;
	}
	public Map<String,?> hgetAll(String key)throws Exception{
        Map <byte[], byte[]> map;
        try(Jedis jedis = pool.getResource()){
            map = jedis.hgetAll(key.getBytes());
        }
        Map<String,Object> rmap = new HashMap<>();
		for(Map.Entry<byte[], byte[]> item:map.entrySet()){
			rmap.put(new String(item.getKey()), SerializeUtil.unserialize(item.getValue()));
		}
		return rmap;
	}
	public Long hdel(String key,String field)throws Exception{
        try(Jedis jedis = pool.getResource()){
            return jedis.hdel(key.getBytes(),field.getBytes());
        }
	}
}

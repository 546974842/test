package vitily.com.util;

import java.util.*;
import redis.clients.jedis.*;

/**
 * jedis 操作 redis 类：集群模式
 * @author lether
 *
 */
public class JedisUtil {
	private static JedisCluster jedisCluster;
	private static JedisPool pool;
	private static boolean useCluster;
	static{
		@SuppressWarnings("resource")
		PropertyConfigure configure = SpringContextUtil.getBean("propertyConfigure");
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(Integer.valueOf(configure.getProperty("spring.redis.pool.max-active")));
		poolConfig.setMaxIdle(Integer.valueOf(configure.getProperty("spring.redis.pool.max-idle")));
		poolConfig.setMinIdle(Integer.valueOf(configure.getProperty("spring.redis.pool.min-idle")));
		poolConfig.setMaxWaitMillis(Long.valueOf(configure.getProperty("spring.redis.pool.max-wait")));
		poolConfig.setTestOnBorrow(true);
		useCluster = Boolean.valueOf(configure.getProperty("spring.redis.userCluster"));
		if(useCluster){
			Set<HostAndPort> haps = new HashSet<>();
			String[] nodes = configure.getProperty("spring.redis.cluster.jedisClusterNodes").split(",");
			for (String node : nodes) {
				String[] arr = node.split(":");
				haps.add(new HostAndPort(arr[0], Integer.valueOf(arr[1])));
			}
			jedisCluster = new JedisCluster(haps,
					Integer.valueOf(configure.getProperty("spring.redis.cluster.connectionTimeout")),
					Integer.valueOf(configure.getProperty("spring.redis.cluster.soTimeout")),
					Integer.valueOf(configure.getProperty("spring.redis.cluster.maxRedirections")),
					poolConfig);
		}else{
			pool = new JedisPool(poolConfig,
					configure.getProperty("spring.redis.host"),
					Integer.valueOf(configure.getProperty("spring.redis.port")));
		}
	}
	/**
	 * 上锁的话不用分布式锁，只在一台机子上锁
	 * @param key
	 * @param value
	 * @param isLock
	 * @return
	 */
	public static boolean put(String key,Object value,boolean isLock)throws Exception {
		if(value == null){
			return false;
		}
		byte[] btKey =  key.getBytes();
		byte[] btValue = SerializeUtil.serialize(value);
		if(useCluster) {
			if(isLock) {
				jedisCluster.setnx(btKey, btValue);
			}else{
				jedisCluster.set(btKey, btValue);
			}
		}else{
		    try(Jedis jedis = pool.getResource()) {
                if (isLock) {
                    jedis.setnx(btKey, btValue);
                } else {
                    jedis.set(btKey, btValue);
                }
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
    public static boolean put(String key,Object value,int seconds,boolean isLock)throws Exception{
        if(value == null){
            return false;
        }
        byte[] btKey =  key.getBytes();
        byte[] btValue = SerializeUtil.serialize(value);
        if(useCluster) {
            jedisCluster.setex(btKey, seconds, btValue);
        }else{
            try(Jedis jedis = pool.getResource()) {
                jedis.setex(btKey, seconds, btValue);
            }
        }
        return true;
    }
    /**
     * 获取缓存中数据
     * @param key
     * @return
     */
    public static Object get(String key)throws Exception{
        byte[] value;
        if(useCluster){
            value = jedisCluster.get(key.getBytes());
        }else{
            try(Jedis jedis = pool.getResource()) {
                value = jedis.get(key.getBytes());
            }
        }
        Object target = null;
        if(value != null && value.length > 0){
            target = SerializeUtil. unserialize(value);
        }
        return target;
    }
	public long ttl(String key)throws Exception{
        long exp;
        byte[] btKey =  key.getBytes();
        if(useCluster) {
            exp = jedisCluster.ttl(btKey);
        }else{
            try(Jedis jedis = pool.getResource()) {
                exp = jedis.ttl(btKey);
            }
        }
        return exp;
    }
    public static boolean update(String key,Object value,boolean isLock)throws Exception{
        if(value == null){
            return false;
        }
        byte[] btKey =  key.getBytes();
        byte[] btValue = SerializeUtil.serialize(value);
        if(useCluster) {
            long seconds =  jedisCluster.ttl(btKey);
            if(seconds < -1){
                return false;
            }
            jedisCluster.setex(btKey, (int)seconds, btValue);
        }else{
            try(Jedis jedis = pool.getResource()) {
                long seconds =  jedis.ttl(btKey);
                if(seconds < -1){
                    return false;
                }
                jedis.setex(btKey, (int)seconds, btValue);
            }
        }
        return true;
    }
	public static void remove(String key)throws Exception{
		if(useCluster){
			jedisCluster.del(key.getBytes());
		}else{
            try(Jedis jedis = pool.getResource()) {
                jedis.del(key.getBytes());
            }
		}
	}
	public static boolean exists(String key)throws Exception{
	    boolean ex;
	    if(useCluster){
            ex = jedisCluster.exists(key.getBytes());
        }else{
            try(Jedis jedis = pool.getResource()){
                ex = jedis.exists(key.getBytes());
            }
        }
        return ex;
	}
	public static Long lpush(String key,Object value)throws Exception{
	    long res = 0L;
		if(value != null){
		    if(useCluster){
                res = jedisCluster.lpush(key.getBytes(), SerializeUtil.serialize(value));
            }else{
                try(Jedis jedis = pool.getResource()) {
                    res = jedis.lpush(key.getBytes(), SerializeUtil.serialize(value));
                }
            }
		}
		return res;
	}
	public static Object rpop(String key)throws Exception{
        byte[] value;
        if(useCluster){
            value = jedisCluster.rpop(key.getBytes());
        }else{
            try(Jedis jedis = pool.getResource()) {
                value = jedis.rpop(key.getBytes());
            }
        }
        Object target = null;
        if(value != null && value.length > 0){
			target = SerializeUtil. unserialize(value);
		}
        return target;
	}
	//=================map===================//
	public static Long hset(String key,String field,Object value)throws Exception{
	    long res;
	    if(useCluster){
            res = jedisCluster.hset(key.getBytes(), field.getBytes(), SerializeUtil.serialize(value));
        }else{
            try(Jedis jedis = pool.getResource()) {
                res = jedis.hset(key.getBytes(), field.getBytes(), SerializeUtil.serialize(value));
            }
        }
        return res;
	}
	public static String hmset(String key,Map<String,?> map)throws Exception{
		Map<byte[],byte[]> bmap = new HashMap<>();
		for(Map.Entry<String, ?> item:map.entrySet()){
			bmap.put(item.getKey().getBytes(), SerializeUtil.serialize(item.getValue()));
		}
		if(useCluster){
            return jedisCluster.hmset(key.getBytes(),bmap);
        }else{
            try(Jedis jedis = pool.getResource()) {
                return jedis.hmset(key.getBytes(),bmap);
            }
        }
	}
	public static Object hget(String key,String field)throws Exception{
        byte[] bts;
        if(useCluster){
            bts = jedisCluster.hget(key.getBytes(), field.getBytes());
        }else{
            try(Jedis jedis = pool.getResource()) {
                bts = jedis.hget(key.getBytes(), field.getBytes());
            }
        }
        return SerializeUtil.unserialize(bts);
	}
	public static List<Object> hmget(String key,String...fields)throws Exception{
		byte[][] bts= new byte[fields.length][];
		for(int i=0;i<fields.length;++i){
			bts[i] = fields[i].getBytes();
		}
        List <byte[]> blist;
		if(useCluster){
            blist = jedisCluster.hmget(key.getBytes(), bts);
        }else{
            try(Jedis jedis = pool.getResource()){
                blist = jedis.hmget(key.getBytes(), bts);
            }
        }
        List<Object> olist = new ArrayList<>();
		for(byte[] bt:blist){
			olist.add(SerializeUtil.unserialize(bt));
		}
		return olist;
	}
	public static Map<String,?> hgetAll(String key)throws Exception{
        Map <byte[], byte[]> map;
        if(useCluster){
            map = jedisCluster.hgetAll(key.getBytes());
        }else{
            try(Jedis jedis = pool.getResource()){
                map = jedis.hgetAll(key.getBytes());
            }
        }
        Map<String,Object> rmap = new HashMap<>();
		for(Map.Entry<byte[], byte[]> item:map.entrySet()){
			rmap.put(new String(item.getKey()), SerializeUtil.unserialize(item.getValue()));
		}
		return rmap;
	}
	public static Long hdel(String key,String field)throws Exception{
	    if(useCluster){
            return jedisCluster.hdel(key.getBytes(),field.getBytes());
        }else{
            try(Jedis jedis = pool.getResource()){
                return jedis.hdel(key.getBytes(),field.getBytes());
            }
        }
	}
}

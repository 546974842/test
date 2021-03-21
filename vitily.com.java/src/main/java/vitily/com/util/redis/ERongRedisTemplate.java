package vitily.com.util.redis;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * ERongRedisTemplate
 * add by HanXiong
 */
public class ERongRedisTemplate {

    private static final Logger log = LoggerFactory.getLogger(ERongRedisTemplate.class);
    private static ERongRedisPool eRongRedisPool; // redisPool
    private static String prefix = "gw_server"; // 缓存前缀（用于区分缓存，防止缓存键值重复）

    private static final String KEY_SPLIT = ":"; //用于隔开缓存前缀与缓存键值

    /**
     * 设置缓存
     *
     * @param key   缓存key
     * @param value 缓存value
     */
    public static void set(String key, String value) {
        log.info("RedisUtil:set cache key=" + prefix + KEY_SPLIT + key + ",value=" + value);
        ERongRedisTemplate.setToGlobal(prefix + KEY_SPLIT + key, value);
    }

    /**
     * 设置全局缓存
     *
     * @param key   缓存key
     * @param value 缓存value
     */
    public static void setToGlobal(String key, String value) {
        log.info("RedisUtil:set cache key=" + key + ",value=" + value);
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static String get(String key) {
        return ERongRedisTemplate.getFromGlobal(prefix + KEY_SPLIT + key);
    }

    /**
     * 从全局获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static String getFromGlobal(String key) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            value = jedis.get(key);
            value = !StringUtils.isEmpty(value) && !"nil".equalsIgnoreCase(value) ? value : null;
        } catch (Exception e) {
            log.error("get {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static Object getObject(String key) {
        if (key == null) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        Object value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(getBytesKey(key))) {
                value = toObject(jedis.get(getBytesKey(key)));
                log.debug("getObject {} = {}", key, value);
            }
        } catch (Exception e) {
            log.warn("getObject {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 设置缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间(秒)，0为不超时
     * @return
     */
    public static String set(String key, String value, int cacheSeconds) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.set(key, value);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            log.debug("set {} = {}", key, value);
        } catch (Exception e) {
            log.warn("set {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }
    
    /**
     * 设置缓存,存json
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间(秒)，0为不超时
     * @return
     */
    public static String setJSONString(String key, Object value, int cacheSeconds) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            String str=JSON.toJSONString(value);
            result = jedis.set(key, str);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            log.debug("set {} = {}", key, value);
        } catch (Exception e) {
            log.warn("set {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }
    
    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static Object getJSONObject(String key) {
        if (key == null) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        Object object = null;
        Jedis jedis = null;
        String value=null;
        try {
            jedis = getJedis();
            value = jedis.get(key);
            if (!StringUtils.isEmpty(value) && !"nil".equalsIgnoreCase(value)) {
            	object=JSON.parse(value);
			} 
        } catch (Exception e) {
            log.warn("getObject {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return object;
    }
    
    
    

    /**
     * 设置缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间(秒)，0为不超时
     * @return
     */
    public static String setObject(String key, Object value, int cacheSeconds) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.set(getBytesKey(key), toBytes(value));
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            log.debug("setObject {} = {}", key, value);
        } catch (Exception e) {
            log.warn("setObject {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 获取List缓存
     *
     * @param key 键
     * @return 值
     */
    public static List<String> getList(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        List<String> value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(key)) {
                value = jedis.lrange(key, 0, -1);
                log.debug("getList {} = {}", key, value);
            }
        } catch (Exception e) {
            log.warn("getList {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 获取List缓存
     *
     * @param key 键
     * @return 值
     */
    public static List<Object> getObjectList(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        List<Object> value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(getBytesKey(key))) {
                List<byte[]> list = jedis.lrange(getBytesKey(key), 0, -1);
                value = new ArrayList<>();
                for (byte[] bs : list) {
                    value.add(toObject(bs));
                }
                log.debug("getObjectList {} = {}", key, value);
            }
        } catch (Exception e) {
            log.warn("getObjectList {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 设置List缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long setList(String key, List<String> value) {
        return setList(key, value, 0);
    }

    /**
     * 
     * @Description: 设置缓存时间
     * @param key
     * @param cacheSeconds
     * @return long
     * @throws
     */
    public static long setExpire(String key, int cacheSeconds) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(key) && cacheSeconds > 0) {
                jedis.expire(key, cacheSeconds);
            }
            log.debug("setExpire {} = {}", key, cacheSeconds);
        } catch (Exception e) {
            log.warn("setExpire {} = {}", new Object[] { key, cacheSeconds, e });
        } finally {
            returnResource(jedis);
        }
        return result;
    }
    
    /**
     * 设置List缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间(秒)，0为不超时
     * @return
     */
    public static long setList(String key, List<String> value, int cacheSeconds) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(key)) {
                jedis.del(key);
            }
            String[] arr = new String[value.size()];
            result = jedis.rpush(key, value.toArray(arr));
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            log.debug("setList {} = {}", key, value);
        } catch (Exception e) {
            log.warn("setList {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 设置List缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间(秒)，0为不超时
     * @return
     */
    public static long setObjectList(String key, List<Object> value, int cacheSeconds) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(getBytesKey(key))) {
                jedis.del(key);
            }
            List<byte[]> list = new ArrayList<>();
            for (Object o : value) {
                list.add(toBytes(o));
            }
            result = jedis.rpush(getBytesKey(key), (byte[][]) list.toArray());
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            log.debug("setObjectList {} = {}", key, value);
        } catch (Exception e) {
            log.warn("setObjectList {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 向List缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long listAdd(String key, String... value) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.rpush(key, value);
            log.debug("listAdd {} = {}", key, value);
        } catch (Exception e) {
            log.warn("listAdd {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 向List缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long listObjectAdd(String key, Object... value) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            List<byte[]> list = new ArrayList<>();
            for (Object o : value) {
                list.add(toBytes(o));
            }
            result = jedis.rpush(getBytesKey(key), (byte[][]) list.toArray());
            log.debug("listObjectAdd {} = {}", key, value);
        } catch (Exception e) {
            log.warn("listObjectAdd {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static Set<String> getSet(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        Set<String> value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(key)) {
                value = jedis.smembers(key);
                log.debug("getSet {} = {}", key, value);
            }
        } catch (Exception e) {
            log.warn("getSet {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 值
     */
    public static Set<Object> getObjectSet(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        Set<Object> value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(getBytesKey(key))) {
                value = new HashSet<>();
                Set<byte[]> set = jedis.smembers(getBytesKey(key));
                for (byte[] bs : set) {
                    value.add(toObject(bs));
                }
                log.debug("getObjectSet {} = {}", key, value);
            }
        } catch (Exception e) {
            log.warn("getObjectSet {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 设置Set缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间(秒)，0为不超时
     * @return
     */
    public static long setSet(String key, Set<String> value, int cacheSeconds) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(key)) {
                jedis.del(key);
            }
            result = jedis.sadd(key, (String[]) value.toArray());
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            log.debug("setSet {} = {}", key, value);
        } catch (Exception e) {
            log.warn("setSet {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 设置Set缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间(秒)，0为不超时
     * @return
     */
    public static long setObjectSet(String key, Set<Object> value, int cacheSeconds) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(getBytesKey(key))) {
                jedis.del(key);
            }
            Set<byte[]> set = new HashSet<>();
            for (Object o : value) {
                set.add(toBytes(o));
            }
            result = jedis.sadd(getBytesKey(key), (byte[][]) set.toArray());
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            log.debug("setObjectSet {} = {}", key, value);
        } catch (Exception e) {
            log.warn("setObjectSet {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 向Set缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long setSetAdd(String key, String... value) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.sadd(key, value);
            log.debug("setSetAdd {} = {}", key, value);
        } catch (Exception e) {
            log.warn("setSetAdd {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 向Set缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long setSetObjectAdd(String key, Object... value) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            Set<byte[]> set = new HashSet<>();
            for (Object o : value) {
                set.add(toBytes(o));
            }
            result = jedis.rpush(getBytesKey(key), (byte[][]) set.toArray());
            log.debug("setSetObjectAdd {} = {}", key, value);
        } catch (Exception e) {
            log.warn("setSetObjectAdd {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 获取Map缓存
     *
     * @param key 键
     * @return 值
     */
    public static Map<String, String> getMap(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        Map<String, String> value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(key)) {
                value = jedis.hgetAll(key);
                log.debug("getMap {} = {}", key, value);
            }
        } catch (Exception e) {
            log.warn("getMap {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 获取Map缓存
     *
     * @param key 键
     * @return 值
     */
    public static Map<String, Object> getObjectMap(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        Map<String, Object> value = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(getBytesKey(key))) {
                value = new HashMap<>();
                Map<byte[], byte[]> map = jedis.hgetAll(getBytesKey(key));
                for (Map.Entry<byte[], byte[]> e : map.entrySet()) {
                    // TODO
                    value.put(toObject(e.getKey()).toString(), toObject(e.getValue()));
                }
                log.debug("getObjectMap {} = {}", key, value);
            }
        } catch (Exception e) {
            log.warn("getObjectMap {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return value;
    }

    /**
     * 设置Map缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间(秒)，0为不超时
     * @return
     */
    public static String setMap(String key, Map<String, String> value, int cacheSeconds) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(key)) {
                jedis.del(key);
            }
            result = jedis.hmset(key, value);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            log.debug("setMap {} = {}", key, value);
        } catch (Exception e) {
            log.warn("setMap {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 设置Map缓存
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间(秒)，0为不超时
     * @return
     */
    public static String setObjectMap(String key, Map<String, Object> value, int cacheSeconds) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(getBytesKey(key))) {
                jedis.del(key);
            }
            Map<byte[], byte[]> map = new HashMap<>();
            for (Map.Entry<String, Object> e : value.entrySet()) {
                map.put(getBytesKey(e.getKey()), toBytes(e.getValue()));
            }
            result = jedis.hmset(getBytesKey(key), map);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            log.debug("setObjectMap {} = {}", key, value);
        } catch (Exception e) {
            log.warn("setObjectMap {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 向Map缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static String mapPut(String key, Map<String, String> value) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hmset(key, value);
            log.debug("mapPut {} = {}", key, value);
        } catch (Exception e) {
            log.warn("mapPut {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 向Map缓存中添加值
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static String mapObjectPut(String key, Map<String, Object> value) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        key = prefix + KEY_SPLIT + key;
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            Map<byte[], byte[]> map = new HashMap<>();
            for (Map.Entry<String, Object> e : value.entrySet()) {
                map.put(getBytesKey(e.getKey()), toBytes(e.getValue()));
            }
            result = jedis.hmset(getBytesKey(key), map);
            log.debug("mapObjectPut {} = {}", key, value);
        } catch (Exception e) {
            log.warn("mapObjectPut {} = {}", new Object[]{key, value, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 移除Map缓存中的值
     *
     * @param key 键
     * @return
     */
    public static long mapRemove(String key, String mapKey) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hdel(key, mapKey);
            log.debug("mapRemove {}  {}", key, mapKey);
        } catch (Exception e) {
            log.warn("mapRemove {}  {}",new Object[]{ key, mapKey, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 移除Map缓存中的值
     *
     * @param key 键
     * @return
     */
    public static long mapObjectRemove(String key, String mapKey) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hdel(getBytesKey(key), getBytesKey(mapKey));
            log.debug("mapObjectRemove {}  {}", key, mapKey);
        } catch (Exception e) {
            log.warn("mapObjectRemove {}  {}",new Object[]{ key, mapKey, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 判断Map缓存中的Key是否存在
     *
     * @param key    键
     * @param mapKey 值
     * @return
     */
    public static boolean mapExists(String key, String mapKey) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        key = prefix + KEY_SPLIT + key;
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hexists(key, mapKey);
            log.debug("mapExists {}  {}", key, mapKey);
        } catch (Exception e) {
            log.warn("mapExists {}  {}",new Object[]{ key, mapKey, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 判断Map缓存中的Key是否存在
     *
     * @param key    键
     * @param mapKey 值
     * @return
     */
    public static boolean mapObjectExists(String key, String mapKey) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        key = prefix + KEY_SPLIT + key;
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hexists(getBytesKey(key), getBytesKey(mapKey));
            log.debug("mapObjectExists {}  {}", key, mapKey);
        } catch (Exception e) {
            log.warn("mapObjectExists {}  {}",new Object[]{ key, mapKey, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    public static Long incr(String key) {
    	if (StringUtils.isEmpty(key)) {
            return 0L;
        }
        key = prefix + KEY_SPLIT + key;
        Long result = 0L;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.incr(key);
            log.debug("jedis incr {}  {}", key, result);
        } catch (Exception e) {
            log.warn("jedis incr {}  {}",new Object[]{key, result, e});
        } finally {
            returnResource(jedis);
        }
        return result;
    }
    /**
     * 删除缓存
     *
     * @param key 键
     * @return
     */
    public static long del(String key) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(key)) {
                result = jedis.del(key);
                log.debug("del {}", key);
            } else {
                log.debug("del {} not exists", key);
            }
        } catch (Exception e) {
            log.warn("del {}", key, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 删除缓存
     *
     * @param key 键
     * @return
     */
    public static long delObject(String key) {
        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        key = prefix + KEY_SPLIT + key;
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.exists(getBytesKey(key))) {
                result = jedis.del(getBytesKey(key));
                log.debug("delObject {}", key);
            } else {
                log.debug("delObject {} not exists", key);
            }
        } catch (Exception e) {
            log.warn("delObject {}", key, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 缓存是否存在
     *
     * @param key 键
     * @return
     */
    public static boolean exists(String key) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        key = prefix + KEY_SPLIT + key;
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.exists(key);
            log.debug("exists {}", key);
        } catch (Exception e) {
            log.warn("exists {}", key, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 缓存是否存在
     *
     * @param key 键
     * @return
     */
    public static boolean existsObject(String key) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        key = prefix + KEY_SPLIT + key;
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.exists(getBytesKey(key));
            log.debug("existsObject {}", key);
        } catch (Exception e) {
            log.warn("existsObject {}", key, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 
     * @Description: 是否重复
     * @param key
     * @param millisecond
     * @return boolean
     * @throws
     */
    public static boolean isRepeated(String key, Long millisecond) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        key = prefix + KEY_SPLIT + key;
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            String reply = jedis.set(key, "1", "NX", "PX", millisecond);
            return !"OK".equalsIgnoreCase(reply);
        } catch (Exception e) {
            log.warn("isRepeated {}", key, e);
        } finally {
            returnResource(jedis);
        }
        return result;
    }
    
    /**
     * 获取byte[]类型Key
     *
     * @param object
     * @return
     */
    private static byte[] getBytesKey(Object object) {
        return SerializationUtils.serialize(object);
    }

    /**
     * Object转换byte[]类型
     *
     * @param object
     * @return
     */
    private static byte[] toBytes(Object object) {
        return SerializationUtils.serialize(object);
    }

    /**
     * byte[]型转换Object
     *
     * @param bytes
     * @return
     */
    private static Object toObject(byte[] bytes) {
        return SerializationUtils.unSerialize(bytes);
    }

    private static void returnResource(Jedis jedis) {
        if (eRongRedisPool != null) {
        	log.debug("eRongRedisPool return resource");
            eRongRedisPool.returnResource(jedis);
        }

    }

    private static Jedis getJedis() {
        if (eRongRedisPool == null) {
            eRongRedisPool = SpringUtils.getBean(ERongRedisPool.class);
            prefix = eRongRedisPool.getPrefix();
        }
        return eRongRedisPool.getJedis();
    }


}

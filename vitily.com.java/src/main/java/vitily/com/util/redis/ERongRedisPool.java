package vitily.com.util.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * redis链接池
 *
 * @author hanxiong
 * @date 2018-05-15
 */
@Component
public class ERongRedisPool {

    private static final Logger log = LoggerFactory.getLogger(ERongRedisPool.class);
    private static JedisPool jedisPool = null; // 静态池子
    private String prefix = "gw_server"; // 缓存前缀（用于区分缓存，防止缓存键值重复）

    private static RedisProperties redisProperties; // redis配置

    public List<MasterListener> masterListeners = new ArrayList<>(); // 监听器list，用于后续动态跟踪扩展

    /**
     * 初始化连接池
     */
    private void initPool() {
        if (redisProperties == null) {
            redisProperties = SpringUtils.getBean(RedisProperties.class);
            log.info("redis init properties:{}{}{}{}{}", new Object [] {
            		redisProperties.getSentinels(),
            		redisProperties.getMasterName(),
            		redisProperties.getMaxIdle(),
            		redisProperties.getMaxTotal(),
            		redisProperties.getMaxWaitMillis()
            });
        }
        Set<String> sentinels = infoSentinels();
        HostAndPort master = ERongRedisPool.initSentinels(sentinels, redisProperties.getMasterName());
        initPoolDo(master);
        for (String sentinel : sentinels) {
            final HostAndPort hap = strToHostAndPort(sentinel);
            if (hap == null) {
                continue;
            }
            MasterListener masterListener = new MasterListener(redisProperties.getMasterName(), hap.getHost(), hap.getPort());
            // whether MasterListener threads are alive or not, process can be stopped
            masterListener.setDaemon(true);
            masterListeners.add(masterListener);
            masterListener.start();
        }
    }

    /**
     * 初始化哨兵配置 initSentinels
     *
     * @return
     */
    private Set<String> infoSentinels() {
        Set<String> sentinels = new HashSet<>();
        String sentinelsStr = redisProperties.getSentinels();
        if (sentinelsStr == null) {
            return sentinels;
        }
        String[] sentinelsAry = sentinelsStr.split(",");
        for (String sentinel : sentinelsAry) {
            sentinels.add(sentinel);
        }
        return sentinels;
    }


    /**
     * 连接池初始化DO
     *
     * @param hostAndPort
     */
    public static void initPoolDo(HostAndPort hostAndPort) {
        if (redisProperties == null) {
            redisProperties = SpringUtils.getBean(RedisProperties.class);
        }
        log.debug("initPool" + hostAndPort.getHost() + ": " + hostAndPort.getPort());
        JedisPoolConfig config = new JedisPoolConfig();
        //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        config.setMaxTotal(redisProperties.getMaxTotal());
        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(redisProperties.getMaxIdle());
        //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；默认1000 * 100
        config.setMaxWaitMillis(redisProperties.getMaxWaitMillis());
        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnBorrow(redisProperties.isTestOnBorrow());
        //redis如果设置了密码：
            /*jedisPool = new JedisPool(config, JRedisPoolConfig.REDIS_IP,
            		JRedisPoolConfig.REDIS_PORT,
            		10000,JRedisPoolConfig.REDIS_PASSWORD);    */

        //redis未设置了密码：
        jedisPool = new JedisPool(config, hostAndPort.getHost(), hostAndPort.getPort());
    }

    /**
     * 从jedis连接池中获取获取jedis对象
     *
     * @return
     */
    public Jedis getJedis() {
        if (jedisPool == null) {
            initPool();
        }
        return jedisPool.getResource();
    }

    /**
     * 根据哨兵，过去当前主Rdis
     *
     * @param sentinels
     * @param masterName
     * @return
     */
    private static HostAndPort initSentinels(Set<String> sentinels, final String masterName) {
        HostAndPort master = null;
        boolean sentinelAvailable = false;
        log.info("Trying to find master from available Sentinels...");

        for (String sentinel : sentinels) {
            final HostAndPort hap = strToHostAndPort(sentinel);
            if (hap == null) {
                continue;
            }
            // final HostAndPort hap = HostAndPort.parseString(sentinel);
            log.info("Connecting to Sentinel " + hap);
            Jedis jedis = null;
            try {
                jedis = new Jedis(hap.getHost(), hap.getPort());
                List<String> masterAddr = jedis.sentinelGetMasterAddrByName(masterName);
                // connected to sentinel...
                sentinelAvailable = true;
                master = toHostAndPort(masterAddr);
                log.info("Found Redis master at " + master);
                break;
            } catch (JedisException e) {
                log.error(e.getLocalizedMessage());
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
            }
        }
        if (master == null) {
            if (sentinelAvailable) {
                // can connect to sentinel, but master name seems to not monitored
                throw new JedisException("Can connect to sentinel, but " + masterName + " seems to be not monitored...");
            } else {
                throw new JedisConnectionException("All sentinels down, cannot determine where is " + masterName + " master is running...");
            }
        }
        log.info("Redis master running at " + master + ", starting Sentinel listeners...");
        return master;
    }

    /**
     * 根据主Redis地址，获取HsotAndPort
     *
     * @param masterAddr
     * @return
     * @throws JedisException
     */
    public static HostAndPort toHostAndPort(List<String> masterAddr) throws JedisException {
        if (masterAddr == null || masterAddr.size() != 2) {
            return null;
        }
        return strToHostAndPort(masterAddr.get(0) + ":" + masterAddr.get(1));
    }

    /**
     * IP字符串转HostAndPort
     *
     * @param str
     * @return
     */
    public static HostAndPort strToHostAndPort(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        String[] hpAry = str.split(":");
        if (hpAry == null || hpAry.length != 2 || !pattern.matcher(hpAry[1]).matches()) {
            return null;
        }
        return new HostAndPort(hpAry[0], Integer.parseInt(hpAry[1]));
    }


    /**
     * 资源释放
     *
     * @param jedis
     */
    public void returnResource(Jedis jedis) {
        // TODO
        // Jedis 3.0 this method will not be exposed. Resource cleanup should
        // be done using @see {@link redis.clients.jedis.Jedis#close()}
        if(jedis!= null){
            jedis.close();
        }
    }

    public String getPrefix() {
        return prefix;
    }
}

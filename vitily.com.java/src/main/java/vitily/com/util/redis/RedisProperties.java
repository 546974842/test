package vitily.com.util.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * RedisProperties
 */
@Configuration
@PropertySource(value= {"classpath:spring_config.properties"})
public class RedisProperties {
    /**
     * redis哨兵节点
     */
	@Value("${spring.redis.sentinel.nodes}")
    private String sentinels;
    /**
     * masterName
     */
	@Value("${spring.redis.sentinel.master}")
    private String masterName;

    /**
     * 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
     * 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，
     * 则此时pool的状态为exhausted(耗尽)
     */
	@Value("${spring.redis.jedis.pool.max-active}")
    private Integer maxTotal;
    /**
     * 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例
     */
	@Value("${spring.redis.jedis.pool.max-idle}")
    private Integer maxIdle;
    /**
     * 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException
     */
	@Value("${spring.redis.jedis.pool.max-wait}")
    private Integer maxWaitMillis;

    /**
     * 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
     */
    private Boolean testOnBorrow;

    public String getSentinels() {
        return sentinels;
    }

    public void setSentinels(String sentinels) {
        this.sentinels = sentinels;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public Integer getMaxTotal() {
        return maxTotal == null ? 500 : maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle == null ? 5 : maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMaxWaitMillis() {
        return maxWaitMillis == null ? 100000 : maxWaitMillis;
    }

    public void setMaxWaitMillis(Integer maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public Boolean isTestOnBorrow() {
        return testOnBorrow == null ? true : testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }
}

package vitily.com.util.jediscluster.spring;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import vitily.com.util.CommonUtil;
import vitily.com.util.StringUtil;

/**
 * jedis对redis集群以及线程池的配置
 * 作用：该类是spring配置jedis操作redis缓存的一些基本信息：如连接超时时间、集群ip/端口等。
 * 缘由：使用配置并且对源码进行扩展不仅可以较好的自定义配置还可以将属性分离到properties文件中。
 * @author lether 2016年06月27日09:52:14
 *
 */
public class JedisClusterFactory implements FactoryBean<JedisCluster>,InitializingBean {
	private GenericObjectPoolConfig genericObjectPoolConfig;
    private JedisCluster jedisCluster;  
    private int connectionTimeout = 2000;  
    private int soTimeout = 3000;  
    private int maxRedirections = 5;  
    private String jedisClusterNodes;  
  
    private static JedisClusterFactory jcf = null;
    public static JedisClusterFactory getInstance(){
    	if(CommonUtil.isNull(jcf)){
    		jcf = new JedisClusterFactory();
    	}
    	return jcf;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtil.isEmpty(jedisClusterNodes)) {
            throw new NullPointerException("jedisClusterNodes is null.");  
        }
        Set<HostAndPort> haps = new HashSet<>();
        String[] nodes = jedisClusterNodes.split(",");
        for (String node : nodes) {
            String[] arr = node.split(":");  
            if (arr.length != 2) {  
                throw new ParseException("node address error !",node.length()-1);  
            }  
            haps.add(new HostAndPort(arr[0], Integer.valueOf(arr[1])));  
        }  
        jedisCluster = new JedisCluster(haps, connectionTimeout, soTimeout, maxRedirections, genericObjectPoolConfig);  
    }  
  
    @Override  
    public JedisCluster getObject() throws Exception {  
        return jedisCluster;  
    }  
  
    @Override  
    public Class<?> getObjectType() {  
        return (CommonUtil.isNull(this.jedisCluster) ? JedisCluster.class : this.jedisCluster.getClass());
    }  
  
    @Override  
    public boolean isSingleton() {  
        return true;  
    }  
  
    public GenericObjectPoolConfig getGenericObjectPoolConfig() {  
        return genericObjectPoolConfig;  
    }  
  
    public void setGenericObjectPoolConfig(GenericObjectPoolConfig genericObjectPoolConfig) {  
        this.genericObjectPoolConfig = genericObjectPoolConfig;  
    }  
  
    public JedisCluster getJedisCluster() {  
        return jedisCluster;  
    }  
  
    public void setJedisCluster(JedisCluster jedisCluster) {  
        this.jedisCluster = jedisCluster;  
    }  
  
    public int getConnectionTimeout() {  
        return connectionTimeout;  
    }  
  
    public void setConnectionTimeout(int connectionTimeout) {  
        this.connectionTimeout = connectionTimeout;  
    }  
  
    public int getSoTimeout() {  
        return soTimeout;  
    }  
  
    public void setSoTimeout(int soTimeout) {  
        this.soTimeout = soTimeout;  
    }  
  
    public int getMaxRedirections() {  
        return maxRedirections;  
    }  
  
    public void setMaxRedirections(int maxRedirections) {  
        this.maxRedirections = maxRedirections;  
    }  
  
    public String getJedisClusterNodes() {  
        return jedisClusterNodes;  
    }  
  
    public void setJedisClusterNodes(String jedisClusterNodes) {  
        this.jedisClusterNodes = jedisClusterNodes;  
    } 
}

package vitily.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import vitily.com.util.CommonUtil;
import vitily.com.util.PropertyConfigure;
import vitily.com.util.SpringContextUtil;
import vitily.com.util.cache.ViyBasicCache;
import vitily.com.util.cache.impl.EhcacheImpl;
import vitily.com.util.cache.impl.JedisPoolImpl;
import vitily.com.util.log.LogAdapter;

import java.util.Locale;

@Configuration()
@EnableTransactionManagement
@EnableAsync
@EnableAspectJAutoProxy
@ComponentScan({"vitily.config","vitily.com.service","vitily.com.payment","vitily.com.service_adapter","vitily.test.service","vitily.com.cache"})
//@PropertySource(value = "classpath:${env}/application.properties")
/**************adapter无法被事务捕捉，可以用作辅助类，有数据库操作的不应直接被使用*******************/
public class AppConfiguration {
    public static LogAdapter logger = LogAdapter.getLogAdapter(AppConfiguration.class);
    public AppConfiguration(){
        logger.info("[Initialize application]");
        Locale.setDefault(Locale.US);
    }
    @Bean
    public SpringContextUtil springContextUtil(){
        return new SpringContextUtil();
    }
    @Bean
    public static PropertyConfigure propertyConfigure(){
        return new PropertyConfigure();
    }
    @Bean
    public ViyBasicCache viyBasicCache(@Qualifier("propertyConfigure") PropertyConfigure propertyConfigure){
        return CommonUtil.isEqual("redis", propertyConfigure.getProperty("server.cacheFrame")) ? JedisPoolImpl.getInstance(propertyConfigure) : EhcacheImpl.getInstance(propertyConfigure);
    }
}

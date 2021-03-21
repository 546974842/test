package vitily.com.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;
import vitily.com.util.log.LogAdapter;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class DataSourceFac {
    static LogAdapter logger = LogAdapter.getLogAdapter(DataSourceFac.class);
    public static DataSource getC3p0DataSource(PropertyConfigure configure, String prefix){
        ComboPooledDataSource ds =  new ComboPooledDataSource();
        try{
            String dot = ".";
            ds.setJdbcUrl(configure.getProperty(prefix+dot+"jdbcUrl"));
            ds.setUser(configure.getProperty(prefix+dot+"user"));
            ds.setPassword(configure.getProperty(prefix+dot+"password"));
            ds.setDriverClass(configure.getProperty(prefix+dot+"driverClass"));
            ds.setMinPoolSize(Integer.parseInt(configure.getProperty(prefix+dot+"minPoolSize")));
            ds.setMaxPoolSize(Integer.parseInt(configure.getProperty(prefix+dot+"maxPoolSize")));
            ds.setMaxIdleTime(Integer.parseInt(configure.getProperty(prefix+dot+"maxIdleTime")));
            ds.setAcquireIncrement(Integer.parseInt(configure.getProperty(prefix+dot+"acquireIncrement")));
            ds.setMaxStatements(Integer.parseInt(configure.getProperty(prefix+dot+"maxStatements")));
            ds.setInitialPoolSize(Integer.parseInt(configure.getProperty(prefix+dot+"initialPoolSize")));
            ds.setIdleConnectionTestPeriod(Integer.parseInt(configure.getProperty(prefix+dot+"idleConnectionTestPeriod")));
            ds.setAcquireRetryAttempts(Integer.parseInt(configure.getProperty(prefix+dot+"acquireRetryAttempts")));
            ds.setAcquireRetryDelay(Integer.parseInt(configure.getProperty(prefix+dot+"acquireRetryDelay")));
            ds.setBreakAfterAcquireFailure(Boolean.parseBoolean(configure.getProperty(prefix+dot+"breakAfterAcquireFailure")));
            ds.setTestConnectionOnCheckout(Boolean.parseBoolean(configure.getProperty(prefix+dot+"testConnectionOnCheckout")));
        }catch(Exception e){
            logger.error("数据库链接异常", e);
        }
        return ds;
    }
    public static DataSource getDruidDataSource(PropertyConfigure configure, String prefix){
        DruidDataSource ds =  new DruidDataSource();
        try{
            String dot = ".";
            ds.setUrl(configure.getProperty(prefix+dot+"url"));
            ds.setUsername(configure.getProperty(prefix+dot+"username"));
            ds.setPassword(configure.getProperty(prefix+dot+"password"));
            ds.setInitialSize(Integer.parseInt(configure.getProperty(prefix+dot+"initialSize")));
            ds.setMaxActive(Integer.parseInt(configure.getProperty(prefix+dot+"maxActive")));

            ds.setMinIdle(Integer.parseInt(configure.getProperty(prefix+dot+"minIdle")));
            ds.setMaxWait(Long.parseLong(configure.getProperty(prefix+dot+"maxWait")));
            ds.setValidationQuery(configure.getProperty(prefix+dot+"validationQuery"));
            ds.setTestOnBorrow(Boolean.parseBoolean(configure.getProperty(prefix+dot+"testOnBorrow")));
            ds.setTestOnReturn(Boolean.parseBoolean(configure.getProperty(prefix+dot+"testOnReturn")));

            ds.setTestWhileIdle(Boolean.parseBoolean(configure.getProperty(prefix+dot+"testWhileIdle")));
            ds.setTimeBetweenEvictionRunsMillis(Long.parseLong(configure.getProperty(prefix+dot+"timeBetweenEvictionRunsMillis")));
            ds.setMinEvictableIdleTimeMillis(Long.parseLong(configure.getProperty(prefix+dot+"minEvictableIdleTimeMillis")));
            ds.setRemoveAbandoned(Boolean.parseBoolean(configure.getProperty(prefix+dot+"removeAbandoned")));
            ds.setRemoveAbandonedTimeout(Integer.parseInt(configure.getProperty(prefix+dot+"removeAbandonedTimeout")));

            ds.setLogAbandoned(Boolean.parseBoolean(configure.getProperty(prefix+dot+"logAbandoned")));
            ds.setFilters(configure.getProperty(prefix+dot+"filters"));
        }catch(Exception e){
            logger.error("数据库链接失败", e);
        }
        return ds;
    }

    private static final int TX_METHOD_TIMEOUT = 5;
    public static TransactionInterceptor getTxAdvice(PlatformTransactionManager transactionManager,PropertyConfigure configure, String prefix) {
        logger.info("---------txAdvice----------");
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        /*只读事务，不做更新操作*/
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED );
        /*当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务*/
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
        requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredTx.setTimeout(TX_METHOD_TIMEOUT);
        Map<String, TransactionAttribute> txMap = new HashMap<>();
        String dot = ".";
        String[] rollBackAttrs = configure.getProperty(prefix+dot+"rollBackTransactionAttribute").split(",");
        for(String s:rollBackAttrs){
            txMap.put(s, requiredTx);
        }
        String[] readOnlyAttrs = configure.getProperty(prefix+dot+"readOnlyTransactionAttribute").split(",");
        for(String s:readOnlyAttrs){
            txMap.put(s, readOnlyTx);
        }
        source.setNameMap(txMap);
        return new TransactionInterceptor(transactionManager, source);
    }
    public static DefaultPointcutAdvisor testAdviceAdvisor(String pattern,TransactionInterceptor transactionInterceptor) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(pattern);
        return new DefaultPointcutAdvisor(pointcut, transactionInterceptor);
    }
    public static SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource,String pattern){
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setDataSource(dataSource);
        try {
            bean.setMapperLocations(resolver.getResources(pattern));
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
}

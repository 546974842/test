package vitily.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import vitily.com.util.DataSourceFac;
import vitily.com.util.MultipleDataSource;
import vitily.com.util.PropertyConfigure;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

////
@Component
@MapperScan(basePackages = "vitily.com.mapper")
public class DataSourceConfiguration {
	private final static Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

	@Resource
	PropertyConfigure propertyConfigure;
	@Bean(name = "c3p0DataSource")
	@Primary
	public DataSource c3p0DataSource(){
		return DataSourceFac.getC3p0DataSource(propertyConfigure,"datasource0.c3p0");
	}
	@Bean(name = "druidDataSource")
	public DataSource druidDataSource(){
		return DataSourceFac.getDruidDataSource(propertyConfigure,"datasource1.druid");
	}

	@Bean(name = "multipleDataSource")
	public MultipleDataSource multipleDataSource(@Qualifier("c3p0DataSource") DataSource c3p0DataSource,@Qualifier("druidDataSource") DataSource druidDataSource){
		MultipleDataSource multipleDataSource = new MultipleDataSource();
		multipleDataSource.setDefaultTargetDataSource(c3p0DataSource);
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("c3p0DataSource",c3p0DataSource);
		targetDataSources.put("druidDataSource",druidDataSource);
		multipleDataSource.setTargetDataSources(targetDataSources);
		return multipleDataSource;
	}
	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("multipleDataSource") MultipleDataSource multipleDataSource) {
		return new DataSourceTransactionManager(multipleDataSource);
	}
	@Bean(name="tranIntor")
	public TransactionInterceptor tranIntor(@Qualifier("transactionManager") PlatformTransactionManager transactionManager) {
		return DataSourceFac.getTxAdvice(transactionManager,propertyConfigure,"datasource");
	}

	@Bean(name="primaryAdviceAdvisor")
	public Advisor primaryAdviceAdvisor(@Qualifier("tranIntor") TransactionInterceptor transactionInterceptor) {
		DefaultPointcutAdvisor advisor = DataSourceFac.testAdviceAdvisor("execution (* vitily.com.service.*.impl.*.*(..))",transactionInterceptor);
		advisor.setOrder(2);
		return advisor;
	}
	@Bean(name="testAdviceAdvisor")
	public Advisor testAdviceAdvisor(@Qualifier("tranIntor") TransactionInterceptor transactionInterceptor) {
		DefaultPointcutAdvisor advisor = DataSourceFac.testAdviceAdvisor("execution (* vitily.test.service.*.impl.*.*(..))",transactionInterceptor);
		advisor.setOrder(2);
		return advisor;
	}
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("multipleDataSource") MultipleDataSource multipleDataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(multipleDataSource);
		return sessionFactory.getObject();
	}
}

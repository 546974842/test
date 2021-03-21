package vitily.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import vitily.com.util.MultipleDataSource;

@Component
@Aspect
@Order(1)
public class MultipleDataSourceAspectAdvice {
    private final static Logger logger = LoggerFactory.getLogger(MultipleDataSourceAspectAdvice.class);
    @Around("execution(* vitily.com.service.*.impl.*.*(..))")
    public Object comAround(ProceedingJoinPoint jp) throws Throwable {
        logger.debug("----use c3p0DataSource------");
        MultipleDataSource.setDataSourceKey("c3p0DataSource");
        return jp.proceed();
    }

    @Around("execution(* vitily.test.service.*.impl.*.*(..))")
    public Object testAround(ProceedingJoinPoint jp) throws Throwable {
        logger.debug("----use druidDataSource------");
        MultipleDataSource.setDataSourceKey("druidDataSource");
        return jp.proceed();
    }
}

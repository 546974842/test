package vitily.com.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件日志系统，方便调试、日常行为异常分析
 * 作用：对 logback 日志框架进行封装，当其他别的地方使用到 logback 的时候请使用该类。
 * 缘由：容易控制 logback 是否输出的配置。
 * @author lether 2016年03月16日10:37:35
 *
 */
public final class LogAdapter {
	/**
	 * 使用log4j 记录 日志，如果后期更改其他日志，更改此类，无需在其他地方更新了
	 */
	private Logger logger;
	public static LogAdapter getLogAdapter(Class<?> cls){
		return new LogAdapter(cls);
	}
	private LogAdapter(Class<?> cls){
		logger = LoggerFactory.getLogger(cls.getName());
	}
	public void debug(String message){
		logger.debug(message);
	}
	public void debug(String message,Throwable th){
		logger.debug(message, th);
	}
	public void info(String message){
		logger.info(message);
	}
	public void info(String message,Throwable th){
		logger.info(message,th);
	}
	public void warn(String message){
		logger.warn(message);
	}
	public void warn(String message,Throwable th){
		logger.warn(message, th);
	}
	public void error(String message){
		logger.error(message);
	}
	public void error(String message,Throwable th){
		logger.error(message, th);
	}

	public void trace(String message){
		logger.trace(message);
	}
	public void trace(String message,Throwable th){
		logger.trace(message,th);
	}
	
}

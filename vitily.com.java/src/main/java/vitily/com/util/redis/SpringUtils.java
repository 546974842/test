/*
 * Copyright (C) 2011-2016 ShenZhen erong Information Technology Co.,Ltd.
 * 
 * All right reserved.
 * 
 * This software is the confidential and proprietary
 * information of erong Company of China. 
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement 
 * you entered into with erong inc.
 *
 */
package vitily.com.util.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *  Spring帮助
 * @author: yanhui.wang
 * @since: 2016年05月05日  
 *
 */
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationCtontext = null;

    private static String applicationModuleName;

    private static Logger logger = LoggerFactory.getLogger(SpringUtils.class);

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("inject applicationContext:{}", applicationContext.getApplicationName());
        if (applicationContext != null) {
            logger.info("ApplicationContext is overide, old ApplicationContext:" + applicationContext.getApplicationName());
        }

        SpringUtils.applicationCtontext = applicationContext;
    }

    /**
     * getApplicationContext:获取当前运行的Spring容器
     * 
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationCtontext;
    }

    /**
     * 
     * getBean:根据类型从容器中获取bean对象
     * @author 钟煜
     * @param name
     * @param requiredType
     * @return
     * @since JDK 1.6
     */
    public static <T> T getBean(String name, Class<T> requiredType) {
        return getApplicationContext().getBean(name, requiredType);
    }

    /**
     * 
     * getBean:根据类型从容器中获取bean对象
     * @author 钟煜
     * @param name
     * @param requiredType
     * @return
     * @since JDK 1.6
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 
     * getBean:根据类型从容器中获取bean对象
     * @author 钟煜
     * @param name
     * @param requiredType
     * @return
     * @since JDK 1.6
     */
    public static <T> T getBean(Class<T> requiredType) {
        return getApplicationContext().getBean(requiredType);
    }

    public static ApplicationContext getApplicationCtontext() {
        return applicationCtontext;
    }

    public static void setApplicationCtontext(ApplicationContext applicationCtontext) {
        SpringUtils.applicationCtontext = applicationCtontext;
    }

   /* public static String getApplicationModuleName() {
        String moduleName = StringUtils.isBlank(applicationModuleName) && applicationCtontext != null ? applicationCtontext.getApplicationName() : applicationModuleName;
        if (StringUtils.isNotBlank(moduleName) && moduleName.startsWith("/")) {
            moduleName = moduleName.replaceFirst("/", "");
        }
        return moduleName;
    }*/

    public static void setApplicationModuleName(String applicationModuleName) {
        SpringUtils.applicationModuleName = applicationModuleName;
    }
}

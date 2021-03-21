package vitily.com.util;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.InputStream;
import java.util.Properties;

public class PropertyConfigure extends PropertyPlaceholderConfigurer {
    private static Properties props;       // 存取properties配置文件key-value结果
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties properties) {
        InputStream configInputStream = PropertyConfigure.class.getClassLoader().getResourceAsStream(PropertiesFileUtil.SYSTEM_PROPERTIES);
        properties = new Properties();
        try {
            properties.load(configInputStream);
        }catch (Exception e){
            logger.error(e);
        }
        super.processProperties(beanFactoryToProcess, properties);
        props = properties;
    }

    public String getProperty(String key){
        return props.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public Object setProperty(String key, String value) {
        return props.setProperty(key, value);
    }
}
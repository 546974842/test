package vitily.com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * 属性相关操作
 * @author lether
 *
 */
public class PropertiesFileUtil {
    static Properties congifProperties = null;
    public static final String SYSTEM_PROPERTIES = "application.properties";
    static {
        try {

            InputStream configInputStream = PropertiesFileUtil.class.getClassLoader().getResourceAsStream(SYSTEM_PROPERTIES);
            congifProperties = new Properties();
            congifProperties.load(configInputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String getPropertiesPath() {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        if (File.separatorChar == '\\') {
            //windows 系统样式：/D:/work/，要去掉开头的 /
            path = path.substring(1);
        }
        return path + SYSTEM_PROPERTIES;
    }

    public static String readValue(String key) {
        Properties props = new Properties();
        String path = getPropertiesPath();
        FileInputStream fis = null;
        try {

            fis = new FileInputStream(path);
            props.load(fis);
            String value = props.getProperty(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

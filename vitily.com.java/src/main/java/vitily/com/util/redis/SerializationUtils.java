package vitily.com.util.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 序列化工具
 *
 * @author: wangyanhui
 * @since: 2016年03月25日  
 *
 */
public class SerializationUtils {

    private static Logger logger = LoggerFactory.getLogger(SerializationUtils.class);

    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            logger.error("object serialize error!", e);
        } finally {
            try {

                if (null != oos) {
                    oos.close();
                }

                if (null != baos) {
                    baos.close();
                }
            } catch (Exception e) {
                logger.error("close output stream  error!", e);
            }

        }
        return null;
    }

    public static Object unSerialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);

            return ois.readObject();
        } catch (Exception e) {
            logger.error("object unSerialize error!", e);
        } finally {
            try {

                if (null != ois) {
                    ois.close();
                }

                if (null != bais) {
                    bais.close();
                }
            } catch (Exception e) {
                logger.error("close input stream  error!", e);
            }

        }
        return null;
    }
}

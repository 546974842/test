package vitily.com.util.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.exceptions.JedisException;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 主监听器
 */

public class MasterListener extends Thread {

    private static final Logger log = LoggerFactory.getLogger(MasterListener.class);

    protected String masterName;
    protected String host;
    protected int port;
    protected volatile Jedis jedis;
    protected AtomicBoolean running = new AtomicBoolean(false);

    protected MasterListener() {
    }

    public MasterListener(String masterName, String host, int port) {
        super(String.format("MasterListener-%s-[%s:%d]", masterName, host, port));
        this.masterName = masterName;
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            jedis = new Jedis(host, port);
            try {
                // double check that it is not being shutdown
                if (!running.get()) {
                    break;
                }
                jedis.subscribe(new JedisPubSub() {
                    @Override
                    public void onMessage(String channel, String message) {
                        log.info("Sentinel " + host + ":" + port + " published: " + message + ".");
                        String[] switchMasterMsg = message.split(" ");
                        if (switchMasterMsg.length > 3) {
                            if (masterName.equals(switchMasterMsg[0])) {
                                ERongRedisPool.initPoolDo(ERongRedisPool.toHostAndPort(Arrays.asList(switchMasterMsg[3], switchMasterMsg[4])));
                            } else {
                                log.info("Ignoring message on +switch-master for master name " + switchMasterMsg[0] + ", our master name is " + masterName);
                            }
                        } else {
                            log.info("Invalid message received on Sentinel " + host + ":" + port + " on channel +switch-master: " + message);
                        }
                    }
                }, "+switch-master");
            } catch (JedisException e) {
            } finally {
                jedis.close();
            }
        }
    }

}

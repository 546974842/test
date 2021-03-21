package vitily.com.util;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import vitily.com.util.log.LogAdapter;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZooKeeperUtil {
    static public LogAdapter logger= LogAdapter.getLogAdapter(ZooKeeperUtil.class);
    protected CountDownLatch countDownLatch = new CountDownLatch(1);
    private static Object waiter = new Object();
    private static volatile ZooKeeper zooKeeper;
    public static ZooKeeper getZookepper(){
        if(CommonUtil.isNull(zooKeeper)){
            connect();
        }
        return zooKeeper;
    }
    /**
     * 监控所有被触发的事件
     */
    public void process(WatchedEvent event) {
        logger.info("收到事件通知：" + event.getState() );
        if(CommonUtil.isEqual(event.getState().getIntValue(),Watcher.Event.KeeperState.SyncConnected.getIntValue())){
            countDownLatch.countDown();
        }

    }
    /**
     * <p>连接Zookeeper</p>
     * 启动zk服务 本实例基于自动重连策略,如果zk连接没有建立成功或者在运行时断开,将会自动重连.
     * @param connectString  Zookeeper服务地址
     * @param sessionTimeout Zookeeper连接超时时间
     */
    public static void connect(){
        try {
            synchronized (waiter) {
                PropertyConfigure configure = SpringContextUtil.getBean("propertyConfigure");
                zooKeeper = new ZooKeeper(configure.getProperty("zookeeper.url"), 50, new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        // 如果是“数据变更”事件
                        if (event.getType() != Event.EventType.None) {
                            return;
                        }
                        synchronized (waiter){
                            switch(event.getState()) {
                                case SyncConnected:
                                    //zk连接建立成功,或者重连成功
                                    waiter.notifyAll();
                                    logger.info("Connected...");
                                    break;
                                case Expired:
                                    // session过期,这是个非常严重的问题,有可能client端出现了问题,也有可能zk环境故障
                                    // 此处仅仅是重新实例化zk client
                                    logger.info("Expired(重连)...");
                                    connect();
                                    break;
                                case Disconnected:
                                    logger.info("链接断开，或session迁移....");
                                    break;
                                case AuthFailed:
                                    close();
                                    throw new RuntimeException("ZK Connection auth failed...");
                                default:
                                    break;
                            }
                        }
                    }
                });
            }
        } catch (IOException e) {
            logger.error("连接创建异常，发生 InterruptedException , e " + e.getMessage(), e);
        }
    }
    /**
     * 关闭连接
     */
    public static void close(){
        try {
            synchronized (waiter) {
                if(zooKeeper != null){
                    zooKeeper.close();
                }
                waiter.notifyAll();
            }
        } catch (InterruptedException e) {
            logger.error("release connection error ," + e.getMessage() ,e);
        }
    }
}

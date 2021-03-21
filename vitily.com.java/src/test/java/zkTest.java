import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.*;
import vitily.com.util.CommonUtil;

public class zkTest {
    static ZooKeeper zooKeeper;
    static {
        try{
            CommonUtil.SystemPrintln("begin");
            zooKeeper = new ZooKeeper("127.0.0.1:2181", 50000, new Watcher(){
                // 监控所有被触发的事件
                public void process(WatchedEvent e){
                    CommonUtil.SystemPrintln("change");
                    CommonUtil.SystemPrintln(JSON.toJSONString(e));
                    try{
                        zkExistsData();
                    }catch (Exception ee){
                        ee.printStackTrace();
                    }
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void zkExistsData()throws Exception{
        zooKeeper.exists("/vitily.com/dictionary",true);
        CommonUtil.SystemPrintln("tmp");
    }
    protected static Integer mutex = 0;
    public static void main(String[] args){
        try{
            CommonUtil.SystemPrintln("a");
            String e = zooKeeper.create("/aaaaa","0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            CommonUtil.SystemPrintln("e:"+e);
            synchronized (mutex) {
                mutex.wait();
            }
            CommonUtil.SystemPrintln("b");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

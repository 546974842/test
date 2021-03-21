package vitily.com.cache.impl;

import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.cache.DictionaryCache;
import vitily.com.consts.DelTagDesc;
import vitily.com.consts.DictionaryKey;
import vitily.com.consts.StateDesc;
import vitily.com.tb_entity.comm.TbDictionary;
import vitily.com.tv_entity.comm.TvDictionary;
import vitily.com.util.CommonUtil;
import vitily.com.util.ZooKeeperUtil;
import vitily.com.util.cache.ViyBasicCache;
import vitily.com.util.log.LogAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统字典：全局字典配置全部存在于zookeeper中，方便集群和分布管理
 *
 * @author lether
 *
 */
@Component
public final class DictionaryCacheImpl extends BaseCacheImpl implements DictionaryCache{
	public static LogAdapter logger=LogAdapter.getLogAdapter(DictionaryCacheImpl.class);
	private static volatile Map<String,String> dics = new HashMap <>();
	@Autowired
	private DictionaryCacheImpl(ViyBasicCache viyBasicCache){
		//第三个参数必须为null
		super(DictionaryKey.Keys.系统字典_NOSQL.getValue(),60 * 60 * 24 * 30 * 12,null,viyBasicCache);
	}

	/**
	 * 后台跟api服务器redis一个集群：下直接从集群中获取
	 */
	@Override
	public HashMap<String, String> getPubDicHashMap() {
		HashMap <String, String> m = new HashMap(dics);
		return m;
	}

	/**
	 * 客户端设置
	 */
	@Override
	public String setDictionary(TbDictionary entity)throws Exception {
		Stat s = ZooKeeperUtil.getZookepper().setData(lockPath,JSON.toJSONBytes(entity),-1);
		return JSON.toJSONString(s);
	}

	/**
	 * 本地监听更新
	 */
	@Override
	public String ListenDictionary(Map<String, String> map)throws Exception {
		CommonUtil.SystemPrintln("update-dictionary.....begin");
		Stat s=ZooKeeperUtil.getZookepper().exists(lockPath, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				try{
					if(CommonUtil.isEqual(Watcher.Event.EventType.NodeDataChanged.getIntValue(),event.getType().getIntValue())){
						ListenDictionary(null);
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		if(!CommonUtil.isNull(s)){
			byte[] bytes = ZooKeeperUtil.getZookepper().getData(lockPath,false,s);
			TbDictionary dictionary = JSON.parseObject(bytes,TbDictionary.class);
			if(!CommonUtil.isNull(dictionary)){
				if(CommonUtil.isEqual(DelTagDesc.正常.getValue(),dictionary.getDeltag()) && CommonUtil.isEqual(StateDesc.正常.getValue(),dictionary.getState())){
					logger.info("update or add dictionary.");
					dics.put(dictionary.getKey(),dictionary.getValue());
				}else{
					logger.info("delete dictionary.");
					dics.remove(dictionary.getKey());
				}
			}
		}
		logger.info("update-dictionary.....end");
		return "1";
	}

	/**
	 * 后台跟api服务器redis一个集群：下直接从集群中获取
	 */
	@Override
	public String getValue(String dictionaryKey) {
		return dics.get(dictionaryKey);
	}

	/**
	 * 删除一个字典：客户端无权限
	 * @param dicianaryKey 3
	 * @return 1
	 * @throws Exception 2
	 */
	public String removeKey(String dicianaryKey) {
		dics.remove(dicianaryKey);
		return "ok";
	}

	static final String lockPath = "/vitily.com/dictionary/listen";
	/**
	 * 初始化，每次初始化将本地的dics重新定位
	 * @param list 1
	 * @throws Exception
	 */
	@Override
	public void init(List<TvDictionary> list)throws Exception {
		dics = new HashMap <>();
        for(TvDictionary item : list){
            dics.put(item.getKey(), item.getValue());
        }
        try {
            ZooKeeper zk = ZooKeeperUtil.getZookepper();
            Stat stat = zk.exists(lockPath, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    try {
                        //监听更新时间，因为每次更改字典值的时候就改本地map
                        CommonUtil.SystemPrintln("event.type:" + event.getType());
                        if(CommonUtil.isEqual(Watcher.Event.EventType.NodeDataChanged.getIntValue(),event.getType().getIntValue())){
                            ListenDictionary(null);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });//监听变化，每次变化就将
            if (CommonUtil.isNull(stat)) {
                zk.create(lockPath, "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        }catch (Exception e){
            logger.warn("zookeeper error!");
        }
	}
}

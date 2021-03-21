package vitily.com.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.cache.ApiTokenCache;
import vitily.com.cache.ComServiceFrequentCache;
import vitily.com.cache.DictionaryCache;
import vitily.com.consts.DictionaryKey;
import vitily.com.consts.ResultStatus;
import vitily.com.other_entity.CustomerException;
import vitily.com.util.CommonUtil;
import vitily.com.util.MD5;
import vitily.com.util.NumberUtil;
import vitily.com.util.cache.ViyBasicCache;
import vitily.com.util.log.LogAdapter;

/**
 * 商户token每次请求都延长x分钟，当x分钟不获取自动取消
 * @author lether
 *
 */
@Component
public final class ApiTokenCacheImpl extends BaseCacheImpl implements ApiTokenCache {
	static public LogAdapter logger= LogAdapter.getLogAdapter(ApiTokenCacheImpl.class);


	private ComServiceFrequentCache comServiceFrequentCache;
	@Autowired
	private ApiTokenCacheImpl(DictionaryCache dictionaryCache, ComServiceFrequentCache comServiceFrequentCache, ViyBasicCache viyBasicCache){
		//null使用字典缓存里的时长
		super(DictionaryKey.Keys.APIToken保存时长.getValue(),null,dictionaryCache,viyBasicCache);
		this.comServiceFrequentCache = comServiceFrequentCache.decorate(DictionaryKey.Keys.APIToken保存时长);
	}
	/**
	 * 获取apitoken：所有接口必须先获取token，然后每次调用接口都需要请求token方可进行调用。
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getApiToken(String ip)throws Exception{
		String token = null;
		if(CommonUtil.isNotNull(ip)){
			logger.info("req ip:"+ip);
			String hip = MD5.getMD5(ip);
			int perIpMaxCount = NumberUtil.toInteger(getDicCache().getValue(DictionaryKey.Keys.每个IP最多可以同时存在TOKEN数.getValue()));
			int count=comServiceFrequentCache.getCache(DictionaryKey.MemServiceKeyType.每个IP最多可以同时存在TOKEN数,hip);
			if(count >=perIpMaxCount){
				throw new CustomerException("该IP在同一时间内请求次数过多token，请使用以前有效的token", ResultStatus.请求次数过多);
			}
			//设置次数
			comServiceFrequentCache.setToServer(DictionaryKey.MemServiceKeyType.每个IP最多可以同时存在TOKEN数,hip);
			token = MD5.getMD5(System.currentTimeMillis()+CommonUtil.ranStr(16));
			super.setToServer(token,ip);
		}
		return token;
	}
	@Override
	public boolean isValidAuthToken(String apiToken)throws Exception {
		return super.existsInServer(apiToken);
	}
}

package vitily.com.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.cache.DictionaryCache;
import vitily.com.cache.SMSVerifyFrequentCache;
import vitily.com.consts.DictionaryKey;
import vitily.com.other_entity.SMSVerifyCodeFrequent;
import vitily.com.util.cache.ViyBasicCache;

/**
 * 手机验证码频繁缓存
 * 5分钟一次：由于时间较短，只在服务器本地做(ehcache)
 * 
 * @author lether
 *
 */
@Component
public final class SMSVerifyFrequentCacheImpl extends BaseCacheImpl implements SMSVerifyFrequentCache{

	@Autowired
	private SMSVerifyFrequentCacheImpl(DictionaryCache dictionaryCache, ViyBasicCache viyBasicCache){
		//存一天:以最有一次为保存标准
		super(DictionaryKey.Keys.会员每天可发送短信次数.getValue(),60 * 60 * 24,dictionaryCache,viyBasicCache);
	}
	/**
	 * 更新调用次数至本机：客户端无权限
	 * 否则依次叠加
	 * @param key 1
	 * @param content :短信内容：每次都会改的
	 */
	public void setToServer(String key,String content)throws Exception{
		SMSVerifyCodeFrequent entity=(SMSVerifyCodeFrequent)getFromServer(key);
		if(entity == null){//说明还没调用过
			entity = new SMSVerifyCodeFrequent();
		}
		entity.setCount(entity.getCount() + 1);
		entity.setMillTime(System.currentTimeMillis());//
		entity.setContent(content);
		setToServer(key, entity);
	}
	/**
	 * 更新错误次数 ＋1：客户端无权限
	 * @param key 1
	 * @throws Exception 2
	 */
	public void upErrorCount(String key)throws Exception{
//		SMSVerifyCodeFrequent tb_entity=(SMSVerifyCodeFrequent)getFromServer(key);
//		if(tb_entity == null){//说明还没调用过
//			throw new CustomerException("手机验证码不存在！");
//		}
//		tb_entity.setErrorCount(tb_entity.getErrorCount() + 1);
//		setToServer(key, tb_entity);
	}
}

package vitily.com.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.cache.ComServiceFrequentCache;
import vitily.com.cache.DictionaryCache;
import vitily.com.cache.SessionCache;
import vitily.com.consts.DictionaryKey;
import vitily.com.util.StringUtil;
import vitily.com.util.cache.ViyBasicCache;

/**
 * creator : whh-lether
 * date    : 2019/2/22 18:20
 * desc    :
 **/
@Component
public class SessionCacheImpl extends BaseCacheImpl implements SessionCache {

    @Autowired
    private SessionCacheImpl(DictionaryCache dictionaryCache,ViyBasicCache viyBasicCache){
        //null使用字典缓存里的时长
        super(DictionaryKey.Keys.SESSION保存时长.getValue(),null,dictionaryCache,viyBasicCache);
    }

    @Override
    public Object getSession(String sessionKey) {
        if(StringUtil.isEmpty(sessionKey)){
            return null;
        }
        Object result = null;
        try{
            result = super.getFromServer(sessionKey);
        }catch (Exception e){
            logger.warn(e.getMessage(),e);
        }
        return result;
    }

    @Override
    public boolean setSession(String sessionKey,Object value) {
        if(StringUtil.isEmpty(sessionKey)){
            return false;
        }
        try{
            super.setToServer(sessionKey,value);
        }catch (Exception e){
            logger.warn(e.getMessage(),e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeSession(String sessionKey) {
        try{
            super.removeFromServer(sessionKey);
        }catch (Exception e){
            logger.warn(e.getMessage(),e);
            return false;
        }
        return true;
    }
}

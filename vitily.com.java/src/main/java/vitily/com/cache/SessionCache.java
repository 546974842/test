package vitily.com.cache;

/**
 * creator : whh-lether
 * date    : 2019/2/22 18:19
 * desc    :
 **/
public interface SessionCache extends BaseCache {
    Object getSession(String sessionKey);
    boolean setSession(String sessionKey, Object value);
    boolean removeSession(String sessionKey);
}

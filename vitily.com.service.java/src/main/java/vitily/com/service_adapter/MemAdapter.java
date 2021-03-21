package vitily.com.service_adapter;

import vitily.com.tv_entity.mem.TvMemBase;

public interface MemAdapter {
    boolean isIdentityVerify(TvMemBase entity);
    boolean isLogined(String token);
    /**
     * 如果没登陆，已经报异常了，不需要再次判断
     * @param token 1
     * @return 2
     * @throws Exception 3
     */
    Integer getMemberIdByToken(String token)throws Exception;
    void checkMemberName(String name,String phone,String email)throws Exception;
}

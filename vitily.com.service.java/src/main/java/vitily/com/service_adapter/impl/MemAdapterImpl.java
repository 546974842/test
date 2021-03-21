package vitily.com.service_adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.cache.CommonServiceCache;
import vitily.com.consts.DictionaryKey;
import vitily.com.consts.ResultStatus;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.NoLoginException;
import vitily.com.service_adapter.MemAdapter;
import vitily.com.tv_entity.mem.TvMemBase;
import vitily.com.util.CommonUtil;
import vitily.com.util.MemberUtil;
import vitily.com.util.StringUtil;

@Component
public class MemAdapterImpl implements MemAdapter{
    @Autowired
    CommonServiceCache commonServiceCache;
    /**
     * 判断会员身份校验是否还有效
     * @param member 2
     * @return 1
     */
    @Override
    public boolean isIdentityVerify(TvMemBase member){
        CommonServiceCache identityCache = commonServiceCache.getInstance(DictionaryKey.Keys.身份校验通过有效期);
        return  identityCache.existsInServer(MemberUtil.getMemberEToken(member));
    }
    /**
     * 是否登陆：
     */
    @Override
    public boolean isLogined(String token){
        return !StringUtil.isEmpty(token) && commonServiceCache.getInstance(DictionaryKey.Keys.会员Token).existsInServer(token);
    }
    /**
     * 通过token获取当前登陆的会员Id
     */
    @Override
    public Integer getMemberIdByToken(String token)throws Exception{
        if(StringUtil.isEmpty(token)){
            throw new NoLoginException("会员token无效，请重新登录.");
        }
        CommonServiceCache memCache=commonServiceCache.getInstance(DictionaryKey.Keys.会员Token);
        Integer id = (Integer) memCache.getFromServer(token);
        if(CommonUtil.isNull(id)){
            throw new NoLoginException("会员token无效，请重新登录.");
        }
        return id;
    }
    /**
     * 检查用户名是手机号码或者email
     * @param name
     * @param phone
     * @param email
     */
    @Override
    public void checkMemberName(String name,String phone,String email)throws Exception{
        if(CommonUtil.isPhone(name) && !StringUtil.isEmpty(phone) && !CommonUtil.isEqual(name, phone)){
            throw new CustomerException("登录名为手机号但是跟用户手机号不一致",ResultStatus.参数不符合要求);
        }else if(CommonUtil.isEmail(name) && !StringUtil.isEmpty(email) && !CommonUtil.isEqual(name, email)){
            throw new CustomerException("登录名为Email但是跟用户Email不一致",ResultStatus.参数不符合要求);
        }
    }
}

package vitily.com.service_adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.api_entity.req_entity.other.TqUserLogin;
import vitily.com.cache.ComServiceFrequentCache;
import vitily.com.cache.CommonServiceCache;
import vitily.com.cache.DictionaryCache;
import vitily.com.consts.DelTagDesc;
import vitily.com.consts.DictionaryKey;
import vitily.com.consts.ResultStatus;
import vitily.com.consts.StateDesc;
import vitily.com.tb_entity.adm.TbAdmUser;
import vitily.com.mapper.adm.AdmUserMapper;
import vitily.com.other_entity.CustomerException;
import vitily.com.service_adapter.AdmUserAdapter;
import vitily.com.ts_entity.adm.TsAdmUser;
import vitily.com.tv_entity.adm.TvAdmUser;
import vitily.com.util.*;

import java.util.Date;
@Component
public class AdmUserAdapterImpl implements AdmUserAdapter {
    @Autowired
    CommonServiceCache commonServiceCache;
    @Autowired
    AdmUserMapper admUserMapper;
    @Autowired
    DictionaryCache dictionaryCache;
    @Autowired
    ComServiceFrequentCache comServiceFrequentCache;
    /**
     * logout
     * @param req token
     */
    @Override
    public void logout(TqUserLogin req)throws Exception{
        if(CommonUtil.isNull(req)){
            return;
        }
        commonServiceCache.getInstance(DictionaryKey.Keys.后台用户Token).removeFromServer(req.getToken());
    }
    @Override
    public void checkAdmin(TvAdmUser admin)throws Exception{
        if(CommonUtil.isNull(admin)){
            throw new CustomerException("该用户不存在", ResultStatus.查询不存在);
        }
        //后台用户是否删除
        if(!admin.getDeltag().equals(DelTagDesc.正常.getValue())){
            throw new CustomerException("该用户已删除",ResultStatus.查询不存在);
        }
        //后台用户是否被冻结
        if(!CommonUtil.isEqual(admin.getState(), StateDesc.正常.getValue())){
            throw new CustomerException("该用户被冻结",ResultStatus.用户不存在);
        }
        //密码是否过期？:null的话强制过期
        if(CommonUtil.isNull(admin.getPasswordExpiration()) || DateUtil.difference(new Date(), admin.getPasswordExpiration()) < 0){
            throw new CustomerException("密码已经过期，请联系超级管理员",ResultStatus.Token无效);
        }
    }
    /**
     * 密码服务端加密:tb_entity:从外部过来
     * @param entity 1
     * @return 2
     */
    @Override
    public String encryPassword(TbAdmUser entity, String customerPassword){
        return MD5.getMD5(customerPassword+entity.getSalt());
    }


    /**
     * 加密token：
     * @param entity 1
     * @return 2
     */
    @Override
    public String encryToken(TbAdmUser entity){
        return MD5.getMD5(entity.getSalt()+entity.getId()+entity.getAuthToken());
    }
    @Override
    public String getTotalPermissionStr(TvAdmUser admin){
        StringBuilder sb=new StringBuilder();
        if(!StringUtil.isEmpty(admin.getPermissionStr())){
            sb.append(admin.getPermissionStr());
        }
        sb.append(",");
        if(!CommonUtil.isNull(admin.getRolePermissionStr())){
            sb.append(admin.getRolePermissionStr());
        }
        return sb.toString();
    }
    /**
     * 根据cookie登陆
     * 该方法不对外
     * @param req 1
     * @return 2
     */
    @Override
    public TvAdmUser getTvAdminByToken(TqUserLogin req)throws Exception{
        TvAdmUser admin=admUserMapper.selectByPrimaryKeyForTv(req.getId());
        checkAdmin(admin);
        if(!CommonUtil.isEqual(req.getToken(),encryToken(admin))){
            throw new CustomerException("token过期",ResultStatus.Token无效);
        }
        return admin;
    }
    /**
     * 根据用户名密码登陆
     * 该方法不对外
     * @param req 1
     * @return 2
     * @throws CustomerException 3
     * @throws Exception 4
     */
    @Override
    public TvAdmUser getTvAdminByUserName(TqUserLogin req)throws Exception{

        //判断登陆次数是否已经达到极限
        Integer maxErrorCount= NumberUtil.toInteger(dictionaryCache.getValue(DictionaryKey.Keys.后台最大登陆尝试次数.getValue()));

        int errCount=comServiceFrequentCache.getCache(DictionaryKey.MemServiceKeyType.后台用户登陆尝试次数,req.getUserName());

        if(CommonUtil.isNull(maxErrorCount) ||maxErrorCount.compareTo(errCount) <= 0){
            maxErrorCount = 10;
        }

        int left = maxErrorCount-errCount;
        if(left <= 0){
            throw new CustomerException("登录信息错误，您今日已经尝试登陆次数过多，请明天此时再尝试].",ResultStatus.操作异常);
        }
        TsAdmUser queryEntity = new TsAdmUser();
        queryEntity.getEntity().setUserName(req.getUserName());
        TvAdmUser entity = admUserMapper.getBySelectiveForTv(queryEntity);
        checkAdmin(entity);
        //加密密码对比
        String secPassword=encryPassword(entity, req.getPassword());
        if(!CommonUtil.isEqual(secPassword, entity.getPassword())){
            comServiceFrequentCache.setToServer(DictionaryKey.MemServiceKeyType.后台用户登陆尝试次数,req.getUserName());
            throw new CustomerException("登陆信息错误，用户密码不正确[还可以试"+left+"次].",ResultStatus.操作异常);
        }

        //登陆成功，清除错误次数
        comServiceFrequentCache.removeFromServer(DictionaryKey.MemServiceKeyType.后台用户登陆尝试次数,req.getUserName());
        //登录成功，剔除之前登录的记录
        commonServiceCache.getInstance(DictionaryKey.Keys.后台用户Token).removeFromServer(encryToken(entity));



        return entity;
    }
}

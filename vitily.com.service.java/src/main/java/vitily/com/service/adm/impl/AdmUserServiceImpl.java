package vitily.com.service.adm.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vitily.base.ts_entity.PageInfo;
import vitily.base.tv_entity.TvPageList;
import vitily.com.api_entity.req_entity.other.TqUserLogin;
import vitily.com.cache.CommonServiceCache;
import vitily.com.consts.*;
import vitily.com.tb_entity.adm.TbAdmUser;
import vitily.com.other_entity.*;
import vitily.com.mapper.adm.AdmUserMapper;
import vitily.com.cache.DictionaryCache;
import vitily.com.service.adm.AdmUserService;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service_adapter.AdmUserAdapter;
import vitily.com.ts_entity.adm.TsAdmUser;
import vitily.com.tv_entity.adm.TvAdmUser;
import vitily.com.util.CommonUtil;
import vitily.com.util.DateUtil;
import vitily.com.util.GUIDGenerator;
import vitily.com.util.NumberUtil;
import vitily.com.util.PropertiesFileUtil;
import vitily.com.util.StringUtil;
import vitily.com.util.log.LogAdapter;

@Component
public class AdmUserServiceImpl extends BasicServiceImpl<TbAdmUser,TsAdmUser,TvAdmUser> implements AdmUserService {
    public LogAdapter logger=LogAdapter.getLogAdapter(getClass());
    final
    AdmUserMapper admUserMapper;
	final
    DictionaryCache dictionaryCache;
    final
    CommonServiceCache commonServiceCache;
    final AdmUserAdapter admUserAdapter;

    @Autowired()
    public AdmUserServiceImpl(AdmUserMapper admUserMapper,
                              DictionaryCache dictionaryCache,
                              CommonServiceCache commonServiceCache,
                              AdmUserAdapter admUserAdapter
                                ) {
        this.admUserMapper = admUserMapper;
        this.dictionaryCache = dictionaryCache;
        this.commonServiceCache = commonServiceCache;
        this.admUserAdapter = admUserAdapter;
        super.setBaseMapper(admUserMapper);
    }

    @Override
    public TvPageList getPagingList(TsAdmUser bean)throws Exception{
        bean.setSuperAdminId(Const.SUP_ADMIN_ID);
        if(CommonUtil.isNull(bean)){
            throw new CustomerException("查询实体为null", ResultStatus.参数不全);
        }
        PageInfo pageInfo = bean.getPageInfo();
        if(CommonUtil.isNull(pageInfo)){
            pageInfo = new PageInfo();
        }
        bean.setPageInfo(pageInfo);
        pageInfo.setRecordCount(admUserMapper.getCountPaging(bean));
        TvPageList pageList = new TvPageList();
        pageList.setPageInfo(pageInfo);
        pageList.setList(admUserMapper.getListByBean(bean));
        return pageList;
    }
	@Override
	public int insert(TsAdmUser bean) throws Exception{
		if(admUserMapper.isExists(bean)){
            throw new DuplicateDataException("已存在相同名字的后台用户！");
		}
        //
        bean.getEntity().setSalt(GUIDGenerator.getGUID());
        bean.getEntity().setPassword(admUserAdapter.encryPassword(bean.getEntity(), bean.getEntity().getPassword()));
        //密码end
        CommonUtil.formartInsertEnntity(bean.getEntity());
		return admUserMapper.insertSelective(bean.getEntity());
	}
	/**
	 * 修改：检查是否存在
	 * @param entity 1
	 * @throws Exception 2
	 */
    @Override
	public int update(TsAdmUser bean) throws Exception{
        if(CommonUtil.isEqual(bean.getEntity().getId(),Const.SUP_ADMIN_ID)){
            throw new NoPermissionException("高级用户不允许更改.");
        }
		if(admUserMapper.isExists(bean)){
            throw new DuplicateDataException("已存在相同名字的后台用户！");
		}

        //如果密码大于0 则表示说明要修改密码，顺便salt也更改, tonken也要更新的
        if (StringUtil.isEmpty(bean.getEntity().getPassword())) {
            bean.getEntity().setPassword(null);
            bean.getEntity().setSalt(null);
            bean.getEntity().setAuthToken(null);
        } else {
            bean.getEntity().setSalt(GUIDGenerator.getGUID());
            bean.getEntity().setPassword(admUserAdapter.encryPassword(bean.getEntity(), bean.getEntity().getPassword()));
            bean.getEntity().setAuthToken(GUIDGenerator.getGUID());
        }
        CommonUtil.formartUpdateEnntity(bean.getEntity());
        int res  = admUserMapper.updateByPrimaryKeySelective(bean.getEntity());
		if(res > 0) {
		    TvAdmUser admUser = admUserMapper.selectByPrimaryKeyForTv(bean.getEntity().getId());

            //更新了之后更新用户权限
            String keyToken = admUserAdapter.encryToken(admUser);
            UserStorage storage = (UserStorage) commonServiceCache.getInstance(DictionaryKey.Keys.后台用户Token).getFromServer(keyToken);
            if (!CommonUtil.isNull(storage)) {
                //
                storage.setShowName(admUser.getNickName());
                storage.setPermissonStr(admUserAdapter.getTotalPermissionStr(admUser));
                commonServiceCache.getInstance(DictionaryKey.Keys.后台用户Token).upToServer(keyToken,storage);
            }
        }
		return res;
    }
	
	/**
     * 根据密码修改用户信息
     * @param admin 1
     * @param newPassword 2
     * @throws Exception 3
     */
    public void updateByPassword(TbAdmUser admin,String newPassword)throws Exception{
    	TvAdmUser entity=admUserMapper.selectByPrimaryKeyForTv(admin.getId());
    	//传输的首次加密的密码
        if(!CommonUtil.isEqual(entity.getPassword(),admUserAdapter.encryPassword(entity,admin.getPassword()))){
        	throw new CustomerException("用户原密码不正确，请输入正确的原密码！",ResultStatus.用户名或密码错误);
        }
        admUserAdapter.checkAdmin(entity);
        //判断新密码是否为null以及大于0
        if(StringUtil.isEmpty(newPassword)){
            admin.setSalt(null);
            admin.setPassword(null);
            admin.setAuthToken(null);
            admin.setPasswordExpiration(null);
        }else{
            admin.setSalt(GUIDGenerator.getGUID());
            admin.setPassword(admUserAdapter.encryPassword(admin, newPassword));
            //修改了密码以后token重新生成
            admin.setAuthToken(GUIDGenerator.getGUID());
            Date now = new Date();
            //30天以后
            admin.setPasswordExpiration(DateUtil.addDate(now,NumberUtil.toInteger(PropertiesFileUtil.readValue("adm_password_expiration"),30)));
        }
        //用户名不允许修改
        admin.setUserName(null);
        //后台用户组不与许修改
        admin.setRoleId(null);
        //权限不允许修改
        admin.setPermissionStr(null);
        admin.setUpdateDate(new Date());
        
        
		TsAdmUser queryEntity=new TsAdmUser();
		queryEntity.getEntity().setNickName(admin.getNickName());
		queryEntity.getEntity().setId(entity.getId());
		if(admUserMapper.isExists(queryEntity)){
			throw new DuplicateDataException("已经存在相同的项！");
		}
        admUserMapper.updateByPrimaryKeySelective(admin);
    }
	
	/**
     * 根据id查询用户：
     * @param id 1
     * @return 2
     */
    public TvAdmUser getTvAdminById(int id)throws Exception{
    	TvAdmUser entity = admUserMapper.selectByPrimaryKeyForTv(id);
        CommonUtil.checkIsNullEntity(entity);
    	return entity;
    }
     /**
      * 用户登陆
      * @param req 请求实体
      * @return 1
      * @throws CustomerException 2
      * @throws Exception 3
      */
      public UserStorage login(TqUserLogin req)throws Exception{
    	  TvAdmUser admin;
          if(CommonUtil.isEqual(req.getLoginMode(), UserLoginModeDesc.用户名密码)){
              admin =  admUserAdapter.getTvAdminByUserName(req);
          }else if(CommonUtil.isEqual(req.getLoginMode(), UserLoginModeDesc.token登陆)){
              admin = admUserAdapter.getTvAdminByToken(req);
          }else {
              throw new CustomerException("请求选择异常！", ResultStatus.操作异常);
          }
    	  UserStorage storage=new UserStorage();
          storage.setId(admin.getId());
          storage.setName(admin.getUserName());
          //显示昵称
          storage.setShowName(admin.getNickName());
          storage.setPermissonStr(admUserAdapter.getTotalPermissionStr(admin));

          //登陆成功 更新tokenKey
          
          String newTokenKey=GUIDGenerator.getGUID();
          TbAdmUser upAdmin=new TbAdmUser();
          upAdmin.setId(admin.getId());
          upAdmin.setAuthToken(newTokenKey);
          upAdmin.setLastLoginDate(new Date());

          admin.setAuthToken(newTokenKey);
          admUserMapper.updateByPrimaryKeySelective(upAdmin);
          //加密token md5（salt＋id＋token）
          storage.setAuthToken(admUserAdapter.encryToken(admin));
          if(CommonUtil.isEqual(req.getLoginMode().getValue(),UserLoginModeDesc.用户名密码.getValue())){
              //save to cache
              Integer time = req.getStoreTime();
              if(CommonUtil.isNull(time)){
                  time = Integer.parseInt(dictionaryCache.getValue(DictionaryKey.Keys.后台用户Token.getValue()));
              }
              time *= 60 * 60;
              commonServiceCache.getInstance(DictionaryKey.Keys.后台用户Token).setToServer(storage.getAuthToken(),storage,time);
          }
          return storage;
      }
}

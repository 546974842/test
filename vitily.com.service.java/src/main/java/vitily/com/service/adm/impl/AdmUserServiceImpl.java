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
            throw new CustomerException("???????????????null", ResultStatus.????????????);
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
            throw new DuplicateDataException("???????????????????????????????????????");
		}
        //
        bean.getEntity().setSalt(GUIDGenerator.getGUID());
        bean.getEntity().setPassword(admUserAdapter.encryPassword(bean.getEntity(), bean.getEntity().getPassword()));
        //??????end
        CommonUtil.formartInsertEnntity(bean.getEntity());
		return admUserMapper.insertSelective(bean.getEntity());
	}
	/**
	 * ???????????????????????????
	 * @param entity 1
	 * @throws Exception 2
	 */
    @Override
	public int update(TsAdmUser bean) throws Exception{
        if(CommonUtil.isEqual(bean.getEntity().getId(),Const.SUP_ADMIN_ID)){
            throw new NoPermissionException("???????????????????????????.");
        }
		if(admUserMapper.isExists(bean)){
            throw new DuplicateDataException("???????????????????????????????????????");
		}

        //??????????????????0 ???????????????????????????????????????salt?????????, tonken???????????????
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

            //?????????????????????????????????
            String keyToken = admUserAdapter.encryToken(admUser);
            UserStorage storage = (UserStorage) commonServiceCache.getInstance(DictionaryKey.Keys.????????????Token).getFromServer(keyToken);
            if (!CommonUtil.isNull(storage)) {
                //
                storage.setShowName(admUser.getNickName());
                storage.setPermissonStr(admUserAdapter.getTotalPermissionStr(admUser));
                commonServiceCache.getInstance(DictionaryKey.Keys.????????????Token).upToServer(keyToken,storage);
            }
        }
		return res;
    }
	
	/**
     * ??????????????????????????????
     * @param admin 1
     * @param newPassword 2
     * @throws Exception 3
     */
    public void updateByPassword(TbAdmUser admin,String newPassword)throws Exception{
    	TvAdmUser entity=admUserMapper.selectByPrimaryKeyForTv(admin.getId());
    	//??????????????????????????????
        if(!CommonUtil.isEqual(entity.getPassword(),admUserAdapter.encryPassword(entity,admin.getPassword()))){
        	throw new CustomerException("?????????????????????????????????????????????????????????",ResultStatus.????????????????????????);
        }
        admUserAdapter.checkAdmin(entity);
        //????????????????????????null????????????0
        if(StringUtil.isEmpty(newPassword)){
            admin.setSalt(null);
            admin.setPassword(null);
            admin.setAuthToken(null);
            admin.setPasswordExpiration(null);
        }else{
            admin.setSalt(GUIDGenerator.getGUID());
            admin.setPassword(admUserAdapter.encryPassword(admin, newPassword));
            //?????????????????????token????????????
            admin.setAuthToken(GUIDGenerator.getGUID());
            Date now = new Date();
            //30?????????
            admin.setPasswordExpiration(DateUtil.addDate(now,NumberUtil.toInteger(PropertiesFileUtil.readValue("adm_password_expiration"),30)));
        }
        //????????????????????????
        admin.setUserName(null);
        //??????????????????????????????
        admin.setRoleId(null);
        //?????????????????????
        admin.setPermissionStr(null);
        admin.setUpdateDate(new Date());
        
        
		TsAdmUser queryEntity=new TsAdmUser();
		queryEntity.getEntity().setNickName(admin.getNickName());
		queryEntity.getEntity().setId(entity.getId());
		if(admUserMapper.isExists(queryEntity)){
			throw new DuplicateDataException("???????????????????????????");
		}
        admUserMapper.updateByPrimaryKeySelective(admin);
    }
	
	/**
     * ??????id???????????????
     * @param id 1
     * @return 2
     */
    public TvAdmUser getTvAdminById(int id)throws Exception{
    	TvAdmUser entity = admUserMapper.selectByPrimaryKeyForTv(id);
        CommonUtil.checkIsNullEntity(entity);
    	return entity;
    }
     /**
      * ????????????
      * @param req ????????????
      * @return 1
      * @throws CustomerException 2
      * @throws Exception 3
      */
      public UserStorage login(TqUserLogin req)throws Exception{
    	  TvAdmUser admin;
          if(CommonUtil.isEqual(req.getLoginMode(), UserLoginModeDesc.???????????????)){
              admin =  admUserAdapter.getTvAdminByUserName(req);
          }else if(CommonUtil.isEqual(req.getLoginMode(), UserLoginModeDesc.token??????)){
              admin = admUserAdapter.getTvAdminByToken(req);
          }else {
              throw new CustomerException("?????????????????????", ResultStatus.????????????);
          }
    	  UserStorage storage=new UserStorage();
          storage.setId(admin.getId());
          storage.setName(admin.getUserName());
          //????????????
          storage.setShowName(admin.getNickName());
          storage.setPermissonStr(admUserAdapter.getTotalPermissionStr(admin));

          //???????????? ??????tokenKey
          
          String newTokenKey=GUIDGenerator.getGUID();
          TbAdmUser upAdmin=new TbAdmUser();
          upAdmin.setId(admin.getId());
          upAdmin.setAuthToken(newTokenKey);
          upAdmin.setLastLoginDate(new Date());

          admin.setAuthToken(newTokenKey);
          admUserMapper.updateByPrimaryKeySelective(upAdmin);
          //??????token md5???salt???id???token???
          storage.setAuthToken(admUserAdapter.encryToken(admin));
          if(CommonUtil.isEqual(req.getLoginMode().getValue(),UserLoginModeDesc.???????????????.getValue())){
              //save to cache
              Integer time = req.getStoreTime();
              if(CommonUtil.isNull(time)){
                  time = Integer.parseInt(dictionaryCache.getValue(DictionaryKey.Keys.????????????Token.getValue()));
              }
              time *= 60 * 60;
              commonServiceCache.getInstance(DictionaryKey.Keys.????????????Token).setToServer(storage.getAuthToken(),storage,time);
          }
          return storage;
      }
}

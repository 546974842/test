package vitily.com.service.mem.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vitily.base.ts_entity.PageInfo;
import vitily.base.tv_entity.TvPageList;
import vitily.com.api_entity.req_entity.other.TqMemLogin;
import vitily.com.api_entity.resp_entity.mem.TmMemCommissionInfo;
import vitily.com.api_entity.resp_entity.mem.TmMemCommissionRinkingInfo;
import vitily.com.api_entity.resp_entity.mem.TmMemRecommendInfo;
import vitily.com.consts.*;
import vitily.com.tb_entity.mem.TbMemBase;
import vitily.com.tb_entity.mem.TbMemCompanyUserinfo;
import vitily.com.tb_entity.mem.TbMemLocalAccount;
import vitily.com.tb_entity.mem.TbMemPersonalUserinfo;
import vitily.com.mapper.mem.*;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.other_entity.NoExistsException;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.cache.ComServiceFrequentCache;
import vitily.com.cache.CommonServiceCache;
import vitily.com.cache.DictionaryCache;
import vitily.com.service.mem.MemBaseService;
import vitily.com.service_adapter.MemAdapter;
import vitily.com.ts_entity.mem.TsMemBase;
import vitily.com.ts_entity.mem.TsMemCommission;
import vitily.com.tv_entity.mem.TvMemBase;
import vitily.com.util.CommonUtil;
import vitily.com.util.GUIDGenerator;
import vitily.com.util.MD5;
import vitily.com.util.MemberUtil;
import vitily.com.util.NumberUtil;
import vitily.com.util.StringUtil;

@Component
public class MemBaseServiceImpl extends BasicServiceImpl<TbMemBase,TsMemBase,TvMemBase> implements MemBaseService {

	final MemBaseMapper memBaseMapper;
	final MemPersonalUserinfoMapper memPersonalUserinfoMapper;
	final MemCompanyUserinfoMapper memCompanyUserinfoMapper;
	final MemLocalAccountMapper memLocalAccountMapper;
	final DictionaryCache dictionaryCache;
	final ComServiceFrequentCache comServiceFrequentCache;
	final CommonServiceCache commonServiceCache;
	final MemPersonalCreditfileMapper memPersonalCreditfileMapper;
	final MemCompanyCreditfileMapper memCompanyCreditfileMapper;
	final MemAdapter memAdapter;
	@Autowired
	MemPersonalCertifyinfoMapper memPersonalCertifyinfoMapper;

	@Autowired()
	public MemBaseServiceImpl(MemBaseMapper memBaseMapper,
							  MemPersonalUserinfoMapper memPersonalUserinfoMapper,
							  MemCompanyUserinfoMapper memCompanyUserinfoMapper,
							  MemLocalAccountMapper memLocalAccountMapper,
							  DictionaryCache dictionaryCache,
							  ComServiceFrequentCache comServiceFrequentCache,
							  MemPersonalCreditfileMapper memPersonalCreditfileMapper,
							  MemCompanyCreditfileMapper memCompanyCreditfileMapper,
							  CommonServiceCache commonServiceCache,
							  MemAdapter memAdapter
	) {
		this.memBaseMapper = memBaseMapper;
		this.memPersonalUserinfoMapper = memPersonalUserinfoMapper;
		this.memCompanyUserinfoMapper = memCompanyUserinfoMapper;
		this.dictionaryCache = dictionaryCache;
		this.comServiceFrequentCache = comServiceFrequentCache;
		this.memLocalAccountMapper = memLocalAccountMapper;
		this.commonServiceCache = commonServiceCache;
		this.memPersonalCreditfileMapper = memPersonalCreditfileMapper;
		this.memCompanyCreditfileMapper = memCompanyCreditfileMapper;
		this.memAdapter = memAdapter;
		super.setBaseMapper(memBaseMapper);
	}

	@Override
	public TvMemBase selectByPrimaryKeyForTv(int id)throws Exception{
		TvMemBase view = memBaseMapper.selectByPrimaryKeyForTv(id);
		CommonUtil.checkIsNullEntity(view);
		view.setCompanyUserinfo(memCompanyUserinfoMapper.selectByPrimaryKey(id));
		view.setPersonalUserinfo(memPersonalUserinfoMapper.selectByPrimaryKey(id));
		view.setMemPersonalCertifyinfo(memPersonalCertifyinfoMapper.selectByPrimaryKey(id));
		return view;
	}
	@Override
	public int insert(TsMemBase bean) throws Exception{
		if(memBaseMapper.isExists(bean)){
			throw new DuplicateDataException("用户名/手机/email/昵称/qq已被占用");
		}
		//密码
		TbMemBase entity = bean.getEntity();
		memAdapter.checkMemberName(entity.getName(),entity.getName(),entity.getEmail());
		entity.setSalt(GUIDGenerator.getGUID());
		entity.setPassword(MD5.getMD5(entity.getPassword()+entity.getSalt()));
		Date now=new Date();
		entity.setCreateDate(now);
		entity.setUpdateDate(now);
		entity.setDeltag(DelTagDesc.正常.getValue());
		int res = memBaseMapper.insertSelective(entity);
		if(res > 0){
			TbMemLocalAccount localAccount = new TbMemLocalAccount();
			localAccount.setMemberId(entity.getId());
			localAccount.setCreateDate(now);
			//插入用户账户
			memLocalAccountMapper.insertSelective(localAccount);
			//插入用户其他信息(企业/个人信息一并插入防止修改的时候多做一次判断)
			TbMemCompanyUserinfo companyUserinfo = bean.getCompanyUserinfo();
			if(CommonUtil.isNull(companyUserinfo)){
				companyUserinfo = new TbMemCompanyUserinfo();
			}
			companyUserinfo.setMemberId(entity.getId());
			memCompanyUserinfoMapper.insertSelective(companyUserinfo);

			TbMemPersonalUserinfo personalUserinfo = bean.getPersonalUserinfo();
			if(CommonUtil.isNull(personalUserinfo)){
				personalUserinfo = new TbMemPersonalUserinfo();
			}
			personalUserinfo.setMemberId(entity.getId());
			memPersonalUserinfoMapper.insertSelective(personalUserinfo);
		}
		return res;
	}
	/**
	 * 是否存在特定条件的用户
	 * @param entity 1
	 * @return 2
	 * @throws Exception 3
	 */
	public boolean isExists(TsMemBase entity)throws Exception{
		return memBaseMapper.isExists(entity);
	}
	/**
	 * 修改：检查是否存在
	 * 密码：请传真实的
	 * @param
	 * @throws Exception 3
	 */
	@Override
	public int update(TsMemBase bean) throws Exception{
		if(memBaseMapper.isExists(bean)){
			throw new DuplicateDataException("用户名/手机/email/昵称/qq已被占用");
		}
		TbMemBase entity = bean.getEntity();
		memAdapter.checkMemberName(entity.getName(),entity.getName(),entity.getEmail());
		if (StringUtil.isEmpty(entity.getPassword())) {//没修改密码，salt和token key不需要更新
			entity.setPassword(null);
			entity.setSalt(null);
			entity.setTokenKey(null);
		} else {//修改了密码，token key也要更新
			entity.setSalt(GUIDGenerator.getGUID());
			entity.setPassword(MD5.getMD5(entity.getPassword() + entity.getSalt()));
			entity.setTokenKey(GUIDGenerator.getGUID());
		}
		CommonUtil.formartUpdateEnntity(entity);
		int res = memBaseMapper.updateByPrimaryKeySelective(entity);
		if(res > 0){
			//更新用户企业信息
			if(!CommonUtil.isNull(bean.getCompanyUserinfo())){
				bean.getCompanyUserinfo().setId(entity.getId());
				memCompanyUserinfoMapper.updateByPrimaryKeySelective(bean.getCompanyUserinfo());
			}
			if(!CommonUtil.isNull(bean.getPersonalUserinfo())){
				bean.getPersonalUserinfo().setId(entity.getId());
				memPersonalUserinfoMapper.updateByPrimaryKeySelective(bean.getPersonalUserinfo());
			}
		}
		return res;
	}
	/**
	 * 不检查是否存在，一般用于检查其他非唯一资料如修改密码等
	 * @param entity 1
	 * @throws Exception 2
	 */
	public void updateNotCheck(TvMemBase entity)throws Exception{
		CommonUtil.formartUpdateEnntity(entity);
		memBaseMapper.updateByPrimaryKeySelective(entity);
	}
	
	/**
	 * 通过用户名密码获取实体
	 */
	@Transactional(propagation=Propagation.NESTED,rollbackForClassName={"CustomerException","Exception"})
	public TvMemBase login(TqMemLogin req)throws Exception{

		 //判断登陆次数是否已经达到极限
		 Integer maxErrorCount=NumberUtil.toInteger(dictionaryCache.getValue(DictionaryKey.Keys.会员登陆尝试次数.getValue()));
		 int errCount=comServiceFrequentCache.getCache(DictionaryKey.MemServiceKeyType.会员登陆尝试次数,req.getUserName());
		 if(!CommonUtil.isNull(maxErrorCount)){
			 if(maxErrorCount.compareTo(errCount) <= 0){
				 throw new CustomerException("您今日已经尝试登陆次数过多，请明天此时再尝试！", ResultStatus.操作异常);
			 }
		 }
		 TvMemBase member=memBaseMapper.getTvMemberByLogin(req);
		 if(CommonUtil.isNull(member)){
			 comServiceFrequentCache.setToServer(DictionaryKey.MemServiceKeyType.会员登陆尝试次数,req.getUserName());
			 throw new CustomerException("登陆信息错误，用户/密码不正确.",ResultStatus.用户名或密码错误);
		 }
		 //加密密码对比
		 String secPassword=MD5.getMD5(req.getPassword()+member.getSalt());
		 if(!secPassword.equals(member.getPassword())){
			 comServiceFrequentCache.setToServer(DictionaryKey.MemServiceKeyType.会员登陆尝试次数,req.getUserName());
			 throw new CustomerException("登陆信息错误，用户/密码不正确.",ResultStatus.用户名或密码错误);
		 }
		 if(!CommonUtil.isEqual(StateDesc.正常.getValue(),member.getState())){
			 comServiceFrequentCache.setToServer(DictionaryKey.MemServiceKeyType.会员登陆尝试次数,req.getUserName());
			 throw new CustomerException("登录信息错误，用户已被禁用,请联系客服.",ResultStatus.用户已禁用);
		 }
		 
		 //登陆成功，清除错误次数
		 comServiceFrequentCache.removeFromServer(DictionaryKey.MemServiceKeyType.会员登陆尝试次数,req.getUserName());
		 
		 /*如果已经有了则t掉旧的：该处是一种处理方法，另一种处理方法是直接返回，不t旧的*/
		 //登陆成功：更新
		 //更新中一并更新返回的token
		 String newTokenKey=MD5.getMD5(GUIDGenerator.getGUID()+member.getId());
		 TbMemBase upMember=new TbMemBase();
		 upMember.setId(member.getId());
		 upMember.setTokenKey(newTokenKey);
		 member.setTokenKey(newTokenKey);
		 upMember.setLastLoginDate(new Date());
		memBaseMapper.updateByPrimaryKeySelective(upMember);
		 //原理:将 会员token（每次都会变）作为key，id作为value保存在缓存里，这样客户端通过token获取用户信息的时候就可以获取到了。
		 //但是还需要保存一个值作为会员单一登陆（会员id的md5码为key：固定；会员token为值）在缓存里。
		 //当登陆的时候总是更新会员当前登陆token值，且把之前的会员token给t掉
		 String eToken=MemberUtil.getMemberEToken(member);
		 //查询反向token
		 CommonServiceCache memCache=commonServiceCache.getInstance(DictionaryKey.Keys.会员Token);
		 Object oldKey=memCache.getFromServer(eToken);
		 if(!CommonUtil.isNull(oldKey)){
			 //存在了，t掉旧的
			 memCache.removeFromServer((String)oldKey);
		 }
		 //更新eToken：反向token
		 memCache.setToServer(eToken, newTokenKey);
		 //将登陆token存至缓存里: 接口存的是id
		 memCache.setToServer(newTokenKey, member.getId());
		//清除身份校验有效期：防止顶号情况，顶号需要重新验证
		 commonServiceCache.getInstance(DictionaryKey.Keys.身份校验通过有效期).removeFromServer(eToken);
		 if(CommonUtil.isEqual(MemTypeDesc.个人用户.getValue(),member.getType())){
		 	member.setPersonalUserinfo(memPersonalUserinfoMapper.selectByPrimaryKey(member.getId()));
		 }else if(CommonUtil.isEqual(MemTypeDesc.企业用户.getValue(),member.getType())){
		 	member.setCompanyUserinfo(memCompanyUserinfoMapper.selectByPrimaryKey(member.getId()));
		 }
		member.setMemPersonalCertifyinfo(memPersonalCertifyinfoMapper.selectByPrimaryKey(member.getId()));
		MemberUtil.outputMemBase(member);
		 return member;
	}
	/**
	 * 通过token获取会员信息
	 */
	public TvMemBase getTvMemberByToken(String token)throws Exception{
		Integer memberId=memAdapter.getMemberIdByToken(token);
		TvMemBase entity=memBaseMapper.selectByPrimaryKeyForTv(memberId);
		if(CommonUtil.isNull(entity)){
			throw new NoExistsException("登录信息错误，找不到用户.");
		}
		if(!CommonUtil.isEqual(StateDesc.正常.getValue(),entity.getState())){
			throw new CustomerException("登录信息错误，用户已被禁用,请联系客服.！", ResultStatus.操作异常);
		}
		return entity;
	}
	@Override
	public TmMemCommissionInfo selectCommssionInfo(Integer id)throws Exception{
		return memBaseMapper.selectCommssionInfo(id);
	}
	@Override
	public TmMemRecommendInfo selectRecommendInfo(Integer memberId)throws Exception{
		return memBaseMapper.selectRecommendInfo(memberId);
	}
	@Override
	public TvPageList getRecommendPageList(TsMemBase bean)throws Exception{
		if(CommonUtil.isNull(bean)){
			throw new CustomerException("查询实体为null", ResultStatus.参数不全);
		}
		PageInfo pageInfo = bean.getPageInfo();
		if(CommonUtil.isNull(pageInfo)){
			pageInfo = new PageInfo();
		}
		bean.setPageInfo(pageInfo);
		pageInfo.setRecordCount(memBaseMapper.getCountPaging(bean));
		TvPageList pageList = new TvPageList();
		pageList.setPageInfo(pageInfo);
		pageList.setList(memBaseMapper.getRecommendList(bean));
		return pageList;
	}
	public List<TmMemCommissionRinkingInfo> getForRankingReward(TsMemCommission bean){
		return memBaseMapper.getForRankingReward(bean);
	}
}
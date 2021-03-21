package vitily.com.util;

import vitily.com.consts.ResultStatus;
import vitily.com.tb_entity.mem.*;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.NoExistsException;
import vitily.com.tv_entity.mem.TvMemBase;

/**
 * 会员相关
 * @author lether
 *
 */
public class MemberUtil {
	/**
	 * 获取会员固定token： md5(id+?)
	 * @param member
	 * @return
	 */
	public static String getMemberEToken(TvMemBase member){
		return MD5.getMD5(member.getId()+"");
	}
//	public static boolean isIdentityVerify(TvMemBase mem,CommonServiceCache csc){
////		CommonServiceCache IdentityCache = csc.getInstance(DictionaryKey.Keys.身份校验通过有效期);
////		return  IdentityCache.exitsInLocal(MemberUtil.getMemberEToken(mem));
//	}

	/**
	 * 检查用户名是手机号码或者email
	 * @param name
	 * @param phone
	 * @param email
	 */
	public static void checkMemberName(String name,String phone,String email)throws Exception{
		if(CommonUtil.isPhone(name) && !StringUtil.isEmpty(phone) && !CommonUtil.isEqual(name, phone)){
			throw new CustomerException("登录名为手机号但是跟用户手机号不一致", ResultStatus.操作异常);
		}else if(CommonUtil.isEmail(name) && !StringUtil.isEmpty(email) && !CommonUtil.isEqual(name, email)){
			throw new CustomerException("登录名为Email但是跟用户Email不一致", ResultStatus.操作异常);
		}
	}
	public static void outputMemBase(TvMemBase e){
		e.setUpdateDate(null);
		e.setDeltag(null);
		e.setSort(null);
		e.setSalt(null);
		e.setPassword(null);
		e.setQuestion(null);
		e.setAnswer(null);
		outputMemPersonalInfo(e.getPersonalUserinfo());
		outputMemCompanyUserinfo(e.getCompanyUserinfo());
	}
	public static void outputMemPersonalInfo(TbMemPersonalUserinfo e){
		if(!CommonUtil.isNull(e)) {
			e.setUpdateDate(null);
			e.setDeltag(null);
			e.setSort(null);
		}
	}
	public static void outputMemPersonalCreditfile(TbMemPersonalCreditfile e){
		if(!CommonUtil.isNull(e)) {
			e.setUpdateDate(null);
			e.setDeltag(null);
			e.setSort(null);
		}
	}
	public static void outputMemCompanyUserinfo(TbMemCompanyUserinfo e){
		if(!CommonUtil.isNull(e)) {
			e.setUpdateDate(null);
			e.setDeltag(null);
			e.setSort(null);
		}
	}
	public static void outputMemCompanyCreditfile(TbMemCompanyCreditfile e){
		if(!CommonUtil.isNull(e)) {
			e.setUpdateDate(null);
			e.setDeltag(null);
			e.setSort(null);
		}
	}
	public static void checkMemAvailableAmount(TbMemLocalAccount localAccount, Long operaAmount,String errorMsg)throws Exception{
		if (CommonUtil.isNull(localAccount)) {
			throw new NoExistsException("用户账户不存在");
		}
		if(localAccount.getAvailableAmount() < operaAmount){
			throw new CustomerException(String.format(errorMsg,NumberUtil.respScale2MDownYuanByCent(localAccount.getAvailableAmount()),NumberUtil.respScale2MDownYuanByCent(operaAmount)),ResultStatus.余额不足了哟);//
		}
	}
	public static void checkMemFreezeAmount(TbMemLocalAccount localAccount, Long operaAmount,String errorMsg)throws Exception{
		if (CommonUtil.isNull(localAccount)) {
			throw new NoExistsException("用户账户不存在");
		}
		if(localAccount.getFreezeAmount() < operaAmount){
			throw new CustomerException(String.format(errorMsg,NumberUtil.respScale2MDownYuanByCent(localAccount.getFreezeAmount()),NumberUtil.respScale2MDownYuanByCent(operaAmount)),ResultStatus.余额不足了哟);//
		}
	}
	public static Long getWithdrawFeeOfCent(TvMemBase memBase,long centApplyAmount){
		Long fee = null;
		double percent = 0.02;
		switch (memBase.getLevel()){
			case 0:
				percent = 0.02d;
				break;
			case 1:
				percent = 0.02d;
				break;
			case 2:
				percent = 0.02d;
				break;
			case 3:
				percent = 0.02d;
				break;
			case 4:
				percent = 0.01d;
				break;
		}
		fee = (long)(centApplyAmount*percent);
		return fee;
	}
}

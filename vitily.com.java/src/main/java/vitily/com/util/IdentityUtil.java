package vitily.com.util;

import vitily.com.cache.ComServiceFrequentCache;
import vitily.com.cache.DictionaryCache;
import vitily.com.cache.SMSVerifyFrequentCache;
import vitily.com.consts.Const;
import vitily.com.consts.DictionaryKey;
import vitily.com.consts.ResultStatus;
import vitily.com.consts.SMSContentType;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.SMSVerifyCodeFrequent;
import vitily.com.tb_entity.mem.TbMemBase;

/**
 * 校验相关
 * @author lether
 *
 */
public class IdentityUtil {
	/**
	 * 判断输入的验证码是否正确
	 * 只做验证码判断，不清除缓存，缓存一直保留到第二天，除非错误！
	 * @param phone
	 * @param type
	 * @param code
	 * @return
	 */
	public static boolean checkSMSCode(String phone, SMSContentType contentType, String code, DictionaryCache dictionaryCache, SMSVerifyFrequentCache svfc)throws Exception{
		
		String cacheKey=phone+"_"+contentType.getValue();
		SMSVerifyCodeFrequent exitsEntity=(SMSVerifyCodeFrequent)svfc.getFromServer(cacheKey);
		if(exitsEntity == null){
			throw new CustomerException("验证码不存在！", ResultStatus.操作异常);
		}
		
		//获取每天做多可以输入多少次验证码
		Integer maxCodeErrorCount=NumberUtil.toInteger(dictionaryCache.getValue(DictionaryKey.Keys.每天验证码尝试匹配次数.getValue()));

		if(maxCodeErrorCount != null && maxCodeErrorCount <= exitsEntity.getErrorCount()){
			throw new CustomerException("您今天已尝试多次输入验证码，请明天此时再做校验！", ResultStatus.操作异常);
		}
		if(!CommonUtil.isEqual(code, exitsEntity.getContent())){
			//更新错误次数
			svfc.upErrorCount(cacheKey);
			throw new CustomerException("验证码校验失败,请重新输入！", ResultStatus.操作异常);
		}
		//如果超时了：

		 Integer lastSendSMSTime=NumberUtil.toInteger(dictionaryCache.getValue(DictionaryKey.Keys.发送验证码时间间隔.getValue()));
		 if(lastSendSMSTime == null){
			 lastSendSMSTime = Const.COMMON_CACHE_DEFAULT_VALITY_SECONDS;
		 }
		 Long restMils=exitsEntity.getMillTime() + lastSendSMSTime * 1000 - System.currentTimeMillis();
		 if(restMils <= 0){
			 throw new CustomerException("验证码已经超时，请重新获取！", ResultStatus.操作异常);
		 }
		
		return true;
	}
	/**
	 * 校验密保问题是否正确
	 * @param member
	 * @param answer
	 * @throws Exception
	 */
	public static boolean checkSecretQuestion(TbMemBase member, String answer, DictionaryCache dictionaryCache, ComServiceFrequentCache csfc)throws Exception{

		if(StringUtil.isEmpty(member.getAnswer()) || StringUtil.isEmpty(member.getQuestion())){
			throw new CustomerException("请先设置旧问题和答案！", ResultStatus.操作异常);
		}
		
		//判断次数
		Integer maxErrorCount=NumberUtil.toInteger(dictionaryCache.getValue(DictionaryKey.Keys.每天尝试密保问题次数.getValue()));
		int errCount=csfc.getCache(DictionaryKey.MemServiceKeyType.会员验证码问题尝试次数,member.getName());
		if(maxErrorCount != null){
			 if(maxErrorCount.compareTo(errCount) <= 0){
				 throw new CustomerException("您今日已经尝试登陆次数过多，请明天此时再尝试！", ResultStatus.操作异常);
			 }
		 }

		if(!CommonUtil.isEqual(answer, member.getAnswer())){
			//新增缓存
			csfc.setToServer(DictionaryKey.MemServiceKeyType.会员验证码问题尝试次数,member.getName());
			throw new CustomerException("输入的问题答案不正确！", ResultStatus.操作异常);
		}
		
		//验证成功，清除缓存
		csfc.removeFromServer(DictionaryKey.MemServiceKeyType.会员验证码问题尝试次数,member.getName());
		return true;
	}
}

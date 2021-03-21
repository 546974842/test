package vitily.com.util;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

import vitily.com.cache.DictionaryCache;
import vitily.com.cache.SMSVerifyFrequentCache;
import vitily.com.consts.DictionaryKey;
import vitily.com.consts.ResultStatus;
import vitily.com.consts.SMSCodeType;
import vitily.com.consts.SMSContentType;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.SMSVerifyCodeFrequent;

public class SmsUtil {

	/**
	 * 发送手机短信
	 * @param phone
	 * @param contentType ：内容类型
	 * @param sendType ： 短信类型
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static boolean sendPhoneContent(String phone, SMSContentType contentType, SMSCodeType codeType, String content, DictionaryCache dictionaryCache)throws Exception{
		boolean sendState = false;
		
		//发送短信
		//发送还是测试
		Integer isSend=NumberUtil.toInteger(dictionaryCache.getValue(DictionaryKey.Keys.是否真实发送短信.getValue()));
		if(!CommonUtil.isEqual(isSend,1)){
			return true;//不发送，直接返回
		}
		SmsDemo demo = new SmsDemo();
		SendSmsResponse response = demo.sendSms(phone,content);
		String code = response.getCode();
		if(code != null && code.equals("OK")) {
			sendState = true;
		}
		
		//发送短信完毕
		return sendState;
	}
	/**
	 * 
	 * @param phone 手机号码
	 * @param contentType 业务类型
	 * @param content 内容
	 * @return
	 */
	public static boolean sendPhoneVerifyceCode(String phone,SMSContentType contentType,SMSCodeType codeType,String content,DictionaryCache dictionaryCache,SMSVerifyFrequentCache svfc)throws Exception{
		boolean sendState=false;
		//查看缓存是否存在
		String cacheKey=phone+"_"+contentType.getValue();
		SMSVerifyCodeFrequent exitsEntity=(SMSVerifyCodeFrequent)svfc.getFromServer(cacheKey);
		if(exitsEntity != null){
			 //今日是否已尝试验证码匹配次数？：在验证的时候做判断就是
			Integer maxCodeErrorCount=NumberUtil.toInteger(dictionaryCache.getValue(DictionaryKey.Keys.每天验证码尝试匹配次数.getValue()));
			if(maxCodeErrorCount != null && maxCodeErrorCount <= exitsEntity.getErrorCount()){
				 Long restMils=exitsEntity.getMillTime() - System.currentTimeMillis() + 86400000;
				throw new CustomerException("您今天已尝试多次输入验证码，请 "+DateUtil.getRestTime(restMils)+"后再尝试.", ResultStatus.页面请求异常);
			}
			
			 //调用次数是否已到极限？
			//每天发送验证码次数
			 Integer maxSendSMSCount=NumberUtil.toInteger(dictionaryCache.getValue(DictionaryKey.Keys.会员每天可发送短信次数.getValue()));
			 // null 的话就是5次
			 if(maxSendSMSCount != null && maxSendSMSCount <= exitsEntity.getCount()){
				 Long restMils=exitsEntity.getMillTime() - System.currentTimeMillis() + 86400000;
				 throw new CustomerException("您今天已尝试发送短信多次，请 "+DateUtil.getRestTime(restMils)+"后再尝试.", ResultStatus.页面请求异常);
			 }
			 
			 //是否已到达间隔？：单位：秒
			 Integer lastSendSMSTime=NumberUtil.toInteger(dictionaryCache.getValue(DictionaryKey.Keys.发送验证码时间间隔.getValue()));
			 Long restMils=exitsEntity.getMillTime() + lastSendSMSTime * 1000 - System.currentTimeMillis();
			 if(lastSendSMSTime != null && restMils >= 0){
				 //计算剩余分钟数：粗略即可
				 //restMils／(1000*60)
				 throw new CustomerException("请等待 " + DateUtil.getRestTime(restMils) + " 后再尝试发送短信.", ResultStatus.页面请求异常);
			 }
		}
		
		//发送短信
		sendState = sendPhoneContent(phone, contentType, codeType, content,dictionaryCache);
		//发送短信完毕
		//加入缓存
		if(sendState){
			svfc.setToServer(cacheKey,content);
		}
		
		return sendState;
	}
}

package vitily.com.service_adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vitily.com.api_entity.req_entity.mem.TqGetPhoneVerifyCode;
import vitily.com.api_entity.resp_entity.mem.TmGetPhoneVerifyCode;
import vitily.com.cache.DictionaryCache;
import vitily.com.cache.SMSVerifyFrequentCache;
import vitily.com.consts.Const;
import vitily.com.consts.DictionaryKey;
import vitily.com.consts.ResultStatus;
import vitily.com.consts.SMSContentType;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.ResultBack;
import vitily.com.service.mem.MemBaseService;
import vitily.com.service_adapter.MemAdapter;
import vitily.com.service_adapter.PhoneSMSService;
import vitily.com.ts_entity.mem.TsMemBase;
import vitily.com.tv_entity.mem.TvMemBase;
import vitily.com.util.*;

@Repository
public class PhoneSMSServiceImpl implements PhoneSMSService {

	@Autowired
	MemAdapter memAdapter;
	@Autowired
	MemBaseService memBaseService;
	@Autowired
	private DictionaryCache dictionaryCache;
	@Autowired
	SMSVerifyFrequentCache smsVerifyFrequentCache;
	/**
	 * 校验发送验证码业务类型
	 * @param entity
	 * @throws Exception
	 */
	private void checkSendSmsService(TqGetPhoneVerifyCode entity) throws Exception{

		SMSContentType contentType = EnumHelperUtil.getByValue(SMSContentType.class,entity.getContentType());
		switch (contentType) {
			case 注册://需要数据库中不存在     不需要登陆：注意客户端不要让用户多次尝试
			{
				if(memAdapter.isLogined(entity.getMemToken())){
					throw new CustomerException("会员已经登陆，请退出登陆.", ResultStatus.无权限);
				}
				TsMemBase tsMember=new TsMemBase();
				tsMember.getEntity().setName(entity.getPhone());
				if(memBaseService.isExists(tsMember)){
					throw new CustomerException("该手机号已被注册，请使用另外一个手机.", ResultStatus.无权限);
				}
				break;
			}
			case 解除手机号码://需要登陆，需要有手机号码
			{
				TvMemBase member=memBaseService.getTvMemberByToken(entity.getMemToken());
				if(StringUtil.isEmpty(member.getName())){
					throw new CustomerException("用户没有绑定手机号码,请先绑定手机号码.", ResultStatus.无权限);
				}
				entity.setPhone(member.getName());
				break;
			}
			case 身份验证:// 信息设置:////需要数据库中存在手机  －－ 需要登陆
			{
				TvMemBase member=memBaseService.getTvMemberByToken(entity.getMemToken());
				if(StringUtil.isEmpty(member.getName())){
					throw new CustomerException("用户没有绑定手机号码,请先绑定手机号码.", ResultStatus.无权限);
				}
				entity.setPhone(member.getName());
				break;
			}
			case 找回密码:////需要数据库中存在该手机－－不需要登陆：注意客户端不要让用户多次尝试
			{
				TsMemBase tsMember=new TsMemBase();
				tsMember.getEntity().setName(entity.getPhone());//
				if(!memBaseService.isExists(tsMember)){
					throw new CustomerException("输入的手机号不存在，请检查.", ResultStatus.无权限);
				}
				break;
			}

			default:
				break;
		}
	}
	/**
	 * 获取手机验证码
	 * 此处 TqGetPhoneVerifyCode 需要继承TbMemBase 因此可能登陆后也需要发送验证码
	 */
	public ResultBack getPhoneVerifyCode(TqGetPhoneVerifyCode req)throws Exception{
		ResultBack resp=new ResultBack();
		//业务检查
		checkSendSmsService(req);
		//产生验证码
		req.setContent(StringUtil.getRandomNumber(Const.PHONE_CODE_LENGTH));

		//发送短信
		SMSContentType contentType = EnumHelperUtil.getByValue(SMSContentType.class,req.getContentType());
		boolean sendState= SmsUtil.sendPhoneVerifyceCode(req.getPhone(),
				contentType, req.getCodeType(),
				req.getContent(),dictionaryCache,
				smsVerifyFrequentCache
		);
		//
		if(!sendState){
			throw new CustomerException("发送失败！", ResultStatus.页面请求异常);
		}

		TmGetPhoneVerifyCode respEntity=new TmGetPhoneVerifyCode();
		//手机号码不输出
		//respEntity.setPhone(entity.getPhone());

		//是否返回短信内容
		Integer isShowContent= NumberUtil.toInteger(dictionaryCache.getValue(DictionaryKey.Keys.前台是否显示短信内容.getValue()));
		if(CommonUtil.isEqual(isShowContent, 1)){
			respEntity.setContent(req.getContent());
			resp.setCode(ResultStatus.其他.getValue());
		}else{
			resp.setCode(ResultStatus.正常.getValue());
			respEntity.setContent("短信发送成功，请注意查收");
		}
		Integer seconds=NumberUtil.toInteger(dictionaryCache.getValue(DictionaryKey.Keys.发送验证码时间间隔.getValue()));
		if(seconds == null){
			seconds = Const.PHONE_VERIFYCODE_DEFAULT_LEAVE_SECONDES;//默认5分钟
		}
		respEntity.setSeconds(seconds);//保存时长即为
		resp.setContent(respEntity);
		resp.setMessage("短信发送成功,请注意查收");
		return resp;
	}
}

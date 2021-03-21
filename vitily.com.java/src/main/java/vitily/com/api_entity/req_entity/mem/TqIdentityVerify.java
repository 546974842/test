package vitily.com.api_entity.req_entity.mem;

import vitily.com.consts.DictionaryKey;

/**
 * 用户修改资料等身份校验实体
 * @author lether
 *
 */
public class TqIdentityVerify extends TqMemBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 验证类型
	 */
	private DictionaryKey.IdentityVerifyType verifyType =DictionaryKey.IdentityVerifyType.手机验证码校验;//默认
	/**
	 * 短信内容
	 */
	private String smsContent;
	/**
	 * 密保答案
	 */
	private String verifyAnswer;
	/**
	 * 密保卡内容 : 待扩展
	 */
	private String securyContent;
	/**
	 * 支付密码(md5加密)：待扩展
	 */
	private String payPassword;
	public DictionaryKey.IdentityVerifyType getVerifyType() {
		return verifyType;
	}
	public void setVerifyType(DictionaryKey.IdentityVerifyType verifyType) {
		//
		if(verifyType != null){
			this.verifyType = verifyType;
		}
	}
	public String getSmsContent() {
		return smsContent;
	}
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	public String getVerifyAnswer() {
		return verifyAnswer;
	}
	public void setVerifyAnswer(String verifyAnswer) {
		this.verifyAnswer = verifyAnswer;
	}
	public String getSecuryContent() {
		return securyContent;
	}
	public void setSecuryContent(String securyContent) {
		this.securyContent = securyContent;
	}
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
}

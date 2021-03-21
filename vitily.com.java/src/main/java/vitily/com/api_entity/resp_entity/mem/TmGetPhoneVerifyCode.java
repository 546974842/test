package vitily.com.api_entity.resp_entity.mem;

import vitily.com.api_entity.resp_entity.base.TmBaseEntity;

/**
 * 手机验证码返回实体
 * @author lether
 *
 */
public class TmGetPhoneVerifyCode extends TmBaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 发送的手机号码
	 */
	String phone;
	/**
	 * 验证码内容
	 */
	String content;
	/**
	 * 保存时长：秒
	 */
	int seconds;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
}

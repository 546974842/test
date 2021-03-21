package vitily.com.api_entity.req_entity.mem;

import vitily.com.consts.SMSCodeType;

/**
 * 获取手机验证码
 * 服务器不加入随机验证码来验证了，但是客户端需要，这里只是最为备用以便以后需要
 * @author lether
 *
 */
public class TqGetPhoneVerifyCode extends TqMemBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 手机号码：要发送的手机号码
	 */
	String phone;
	/**
	 * 发送内容
	 */
	String content;
	/**
	 * 业务类型 比如：注册验证码，通用，广告内容等待。
	 */
	Integer contentType;
	/**
	 * 逻辑类型：普通短信／语音短信等
	 */
	SMSCodeType codeType = SMSCodeType.文本;
	/**
	 * 随机验证码：暂时用不到
	 */
	String ranCode;
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
	public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
	public SMSCodeType getCodeType() {
		return codeType;
	}
	public void setCodeType(SMSCodeType codeType) {
		this.codeType = codeType;
	}
	public String getRanCode() {
		return ranCode;
	}
	public void setRanCode(String ranCode) {
		this.ranCode = ranCode;
	}
	
}

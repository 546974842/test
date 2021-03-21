package vitily.com.api_entity.req_entity.other;

import vitily.base.ts_entity.TqBase;
import vitily.com.annotation.IntegerRangeValidator;
import vitily.com.annotation.RegexValidator;
import vitily.com.annotation.RequireValidator;
import vitily.com.util.Validator;

public class TqMemLogin extends TqBase{
	/**
	 * 登录用户名：可能也通过phone号码等登录
	 */
	@RequireValidator
	@RegexValidator(regexStr = Validator.STR_MAX_LENGTH128)
	private String userName;
	/**
	 * 登录密码：第一次加密的密码。
	 */
	@RequireValidator
	@RegexValidator(regexStr = Validator.STR_MAX_LENGTH128)
	private String password;
	/**
	 * 保存时长：小时
	 */
	@IntegerRangeValidator(min = 0,max = 24*7)
	private Integer storeTime;

	private String verify_code;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStoreTime() {
		return storeTime;
	}
	public void setStoreTime(Integer storeTime) {
		this.storeTime = storeTime;
	}

	public String getVerify_code() {
		return verify_code;
	}

	public void setVerify_code(String verify_code) {
		this.verify_code = verify_code;
	}
}

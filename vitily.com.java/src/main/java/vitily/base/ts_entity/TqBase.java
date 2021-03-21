package vitily.base.ts_entity;

import vitily.com.annotation.RegexValidator;
import vitily.com.annotation.RequireValidator;
import vitily.com.util.Validator;

import java.io.Serializable;

public class TqBase implements Serializable {
	/**
	 * 基础token
	 */
	//@RequireValidator
	@RegexValidator(regexStr = Validator.STR_MAX_LENGTH64)
	private String apiToken;
	private String reqIp;

	public String getApiToken() {
		return apiToken;
	}
	public void setApiToken(String token) {
		this.apiToken = token;
	}
	public String getReqIp() {
		return reqIp;
	}
	public void setReqIp(String reqIp) {
		this.reqIp = reqIp;
	}
}

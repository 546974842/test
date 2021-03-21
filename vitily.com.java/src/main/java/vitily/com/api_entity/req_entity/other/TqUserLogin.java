package vitily.com.api_entity.req_entity.other;

import vitily.com.consts.UserLoginModeDesc;
import vitily.base.ts_entity.TqBase;

public class TqUserLogin extends TqBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 登录模式
	 */
	private UserLoginModeDesc loginMode;
	/**
	 * 登录用户名：可能也通过phone号码等登录
	 */
	private String userName;
	/**
	 * 登录密码：第一次加密的密码。
	 */
	private String password;
	/**
	 * 第三方登陆：如cookie等需要token验证
	 */
	private String token;
	/**
	 * 保存时长：小时
	 */
	private Integer storeTime;
	/**
	 * id
	 */
	private int id;
	
	public UserLoginModeDesc getLoginMode() {
		return loginMode;
	}
	public void setLoginMode(UserLoginModeDesc loginMode) {
		this.loginMode = loginMode;
	}
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getStoreTime() {
		return storeTime;
	}
	public void setStoreTime(Integer storeTime) {
		this.storeTime = storeTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

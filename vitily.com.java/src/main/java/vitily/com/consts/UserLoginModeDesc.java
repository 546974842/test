package vitily.com.consts;

/**
 * 用户登陆模式
 * @author lether
 *
 */
public enum UserLoginModeDesc {
	Cookie登陆(0,"Cookie登陆"),
	用户名密码(1,"用户名密码"),
	token登陆(2,"token登陆"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	UserLoginModeDesc(int value, String desc){
		this.value=value;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}
}

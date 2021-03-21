package vitily.com.consts;


/**
 * 会员注册来源
 * @author lether
 *
 */
public enum RegFromDesc {
	后台添加(0,"后台添加"),
	手机号码注册(1,"手机号码注册"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	RegFromDesc(int value, String desc){
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

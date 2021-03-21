package vitily.com.consts;


/**
 * banner对应页面
 * @author lether
 *
 */
public enum BannerPageDesc {
	首页(0,"首页"),
	用户中心(1,"用户中心"),
	IOS1(2,"IOS1"),
	IOS2(3,"IOS2"),
	IOS3(4,"IOS3"),
	ANDROID1(5,"ANDROID1"),
	ANDROID2(6,"ANDROID2"),
	ANDROID3(7,"ANDROID3"),
	WAP1(8,"WAP1"),
	WAP2(9,"WAP2"),
	WAP3(10,"WAP3"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	BannerPageDesc(int value,String desc){
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

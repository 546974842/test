package vitily.com.consts;

/**
 * 事件通知
 * @author lether 2016年03月19日12:05:42
 *
 */
public enum ApiNotifyTypeDesc {
	更新字典(0,"更新字典"),
	获取Token(1,"获取Token"),
	更新会员信息(3,"更新会员信息"),
	设置apiuri(4,"设置apiuri"),
	设置分类信息(5,"设置分类信息"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	ApiNotifyTypeDesc(int value, String desc){
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

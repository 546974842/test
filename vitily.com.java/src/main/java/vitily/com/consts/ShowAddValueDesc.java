package vitily.com.consts;

/**
 *
 *
 */
public enum ShowAddValueDesc {
	关注店铺(0,"关注店铺"),
	咨询旺旺客服(1,"咨询旺旺客服"),
	;
	private final int value;
	private final String desc;
	ShowAddValueDesc(int value, String desc){
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

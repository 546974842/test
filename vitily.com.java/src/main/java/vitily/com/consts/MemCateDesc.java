package vitily.com.consts;

/**
 * 会员分类
 *
 */
public enum MemCateDesc {
	网红(0,"网红"),
	商家(1,"商家"),
	美工(2,"美工"),
	;
	private final int value;
	private final String desc;
	MemCateDesc(int value, String desc){
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

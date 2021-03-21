package vitily.com.consts;

/**
 * 订单评论类型
 *
 */
public enum OrderCommentTypeDesc {
	评论(0,"评论"),
	回复(1,"回复"),
	;
	private final int value;
	private final String desc;
	OrderCommentTypeDesc(int value, String desc){
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

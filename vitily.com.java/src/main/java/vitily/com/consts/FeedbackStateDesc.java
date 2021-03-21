package vitily.com.consts;

/**
* @ClassName: FeedbackStateDesc
* @Description: 意见反馈处理情况
* @author lhy
* @date 2018年9月20日
 */
public enum FeedbackStateDesc {
	待处理(0,"待处理"),
	已回复(1,"已处理"),
	用户已看(2,"用户已看"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	FeedbackStateDesc(int value, String desc){
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

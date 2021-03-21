package vitily.com.consts;

/**
 * 评论相关
 * @author lether
 *
 */
public enum CommentableDesc {
	禁止评论(0,"禁止评论"),
	可以评论(1,"可以评论"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	CommentableDesc(int value, String desc){
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

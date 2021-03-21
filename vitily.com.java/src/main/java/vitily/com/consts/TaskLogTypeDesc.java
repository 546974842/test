package vitily.com.consts;

/**
 * 定时任务日志类型
 *
 */
public enum TaskLogTypeDesc {
	日志收集(0,"日志收集"),
	图片定存(1,"图片定存"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	TaskLogTypeDesc(int value, String desc){
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

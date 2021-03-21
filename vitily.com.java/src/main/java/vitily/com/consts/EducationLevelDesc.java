package vitily.com.consts;

/**
 * 最高学历
 * @author lether
 *
 */
public enum EducationLevelDesc {
	无(0,"无"),
	本科(1,"本科"),
	大专(2,"大专"),
	硕士(3,"硕士"),
	博士(4,"博士"),
	博士后(5,"博士后"),
	高中(6,"高中"),
	中专(7,"中专"),
	初中(8,"初中"),
	专升本(9,"专升本"),

	其他(99,"其他");
	private final int value;
	private final String desc;
	EducationLevelDesc(int value, String desc){
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

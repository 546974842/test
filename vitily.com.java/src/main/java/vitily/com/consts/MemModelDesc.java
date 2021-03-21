package vitily.com.consts;

/**
* @ClassName: MemModelDesc
* @Description: 模特状态
* @author lhy
* @date 2018年8月8日
 */
public enum MemModelDesc {
	//状态1上架2待审核3下架
	上架(1,"已上架"),
	待审核(2,"待审核"),
	下架(3,"已下架"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	MemModelDesc(int value, String desc){
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

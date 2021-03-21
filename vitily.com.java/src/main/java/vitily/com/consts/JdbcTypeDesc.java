package vitily.com.consts;

/**
 * 删除位
 * @author lether
 *
 */
public enum JdbcTypeDesc {
	mysql(0,"mysql"),
	oracle(1,"oracle"),
	sqlserver(2,"sqlserver"),
	other(99,"other");
	private final int value;
	private final String desc;
	JdbcTypeDesc(int value, String desc){
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

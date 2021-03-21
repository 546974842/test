package vitily.com.consts;

/**
 *
 *
 */
public enum MemArtistOperaWorkDesc {
	个人(0,"个人"),
	团队(1,"团队"),
	;
	private final int value;
	private final String desc;
	MemArtistOperaWorkDesc(int value, String desc){
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

package vitily.com.consts;

/**
 *
 *
 */
public enum ShowModelAgeDesc {
	不限(0,0,99,"关注店铺"),
	十八到二十五(0,0,99,"关注店铺"),
	二十六到三十(0,26,30,"关注店铺"),
	三十一到三十五(0,31,35,"关注店铺"),
	三十六到四十(0,36,40,"关注店铺"),
	四十一到五十(0,41,50,"关注店铺"),
	五十一以上(0,51,199,"关注店铺"),
	;
	private final int value;
	private final int beginAge;
	private final int endAge;
	private final String desc;
	ShowModelAgeDesc(int value,int beginAge,int endAge, String desc){
		this.value=value;
		this.beginAge=beginAge;
		this.endAge=endAge;
		this.desc=desc;
	}
	public int getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}

	public int getBeginAge() {
		return beginAge;
	}

	public int getEndAge() {
		return endAge;
	}
}

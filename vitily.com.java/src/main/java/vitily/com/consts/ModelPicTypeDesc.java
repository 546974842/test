package vitily.com.consts;


/**
 *
 *
 */
public enum ModelPicTypeDesc {
	idImg("idImg","身份证图片"),
	picImg("picImg","封面图片"),
	oneImg("oneImg","作品一"),
	twoImg("twoImg","作品二"),
	threeImg("threeImg","作品三"),
	;
	private final String value;
	private final String desc;
	ModelPicTypeDesc(String value, String desc){
		this.value=value;
		this.desc=desc;
	}
	public String getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}
}

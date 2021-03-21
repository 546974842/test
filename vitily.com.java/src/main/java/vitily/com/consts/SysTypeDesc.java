package vitily.com.consts;

/**
 * 公共类型
 * @author lether 2016年03月19日12:05:42
 *
 */
public enum SysTypeDesc {
	CMS信息(Const.NEWSCATE_SYSTYPE_ID,"CMS"),
	普通产品(Const.PROCATE_SYSTYPE_ID,"产品信息"),
	字典分类(2,"字典分类"),
	图片信息(3,"imagesams"),
	文件类别(4,"文件类别"),
	常见问题索引(5,"常见问题索引"),
	品牌类型(6,"品牌类型"),
	借款用途(7,"借款用途"),
	标的分类(8,"标的分类"),
	体验类目(9,"体验类目"),
	其他(99,"其他");
	private final int value;
	private final String desc;
	SysTypeDesc(int value, String desc){
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

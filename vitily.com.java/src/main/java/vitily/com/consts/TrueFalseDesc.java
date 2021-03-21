package vitily.com.consts;

import vitily.com.util.CommonUtil;

public enum TrueFalseDesc {
	否(0,"否","red"),
	是(1,"是","green"),
	其他(99,"其他","gray");
	private int value;
	private String desc;
	private String type;
	private String wrapDesc;
	private TrueFalseDesc(int value,String desc,String type){
		this.value=value;
		this.desc=desc;
		this.type=type;
	}
	public int getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}
	public String getWrapDesc() {
		this.wrapDesc = "<span style='color:"+this.type+"'>"+this.desc+"</span>";
		return wrapDesc;
	}
	public static String getWrapDescByValue(Integer v){
		for(TrueFalseDesc item:TrueFalseDesc.values()){
			if(CommonUtil.isEqual(item.getValue(), v)){
				return item.getWrapDesc();
			}
		}
		return TrueFalseDesc.其他.getWrapDesc();
	}
}

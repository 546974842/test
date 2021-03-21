package vitily.com.consts;

import vitily.com.util.CommonUtil;

/**
 * 订单锁定状态
 * @author whh 2017年05月17日09:20:54
 *
 */
public enum PayOrderLockEnum {
	Normal(0,"正常","green"),
	Lock(1,"锁定","green"),
	Other(99,"其他","green");
	private int value;
	private String desc;
	private String type;
	private String wrapDesc;
	private PayOrderLockEnum(int value,String desc,String type){
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
		for(PayOrderLockEnum item:PayOrderLockEnum.values()){
			if(CommonUtil.isEqual(item.getValue(), v)){
				return item.getWrapDesc();
			}
		}
		return PayOrderLockEnum.Other.getWrapDesc();
	}
}

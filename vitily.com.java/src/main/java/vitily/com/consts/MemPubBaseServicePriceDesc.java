package vitily.com.consts;

import java.util.HashMap;
import java.util.Map;

/**
* @ClassName: MemPubBaseServicePriceDesc
* @Description: TODO
* @author lhy
* @date 2018年9月9日
 */
public class MemPubBaseServicePriceDesc {
	private static Map<String,Long> baseServicePrice = new HashMap<>();
	static {
		baseServicePrice.put(ShowExperiTypeDesc.线下退货.getValue()+"_"+"1",48L*Const.RATE_UNIT);
		baseServicePrice.put(ShowExperiTypeDesc.线下退货.getValue()+"_"+"2",45L*Const.RATE_UNIT);
		baseServicePrice.put(ShowExperiTypeDesc.线下退货.getValue()+"_"+"3",42L*Const.RATE_UNIT);
		baseServicePrice.put(ShowExperiTypeDesc.线下退货.getValue()+"_"+"4",40L*Const.RATE_UNIT);
		baseServicePrice.put(ShowExperiTypeDesc.无需退货.getValue()+"_"+"1",12L*Const.RATE_UNIT);
		baseServicePrice.put(ShowExperiTypeDesc.无需退货.getValue()+"_"+"2",10L*Const.RATE_UNIT);
		baseServicePrice.put(ShowExperiTypeDesc.无需退货.getValue()+"_"+"3",8L*Const.RATE_UNIT);
		baseServicePrice.put(ShowExperiTypeDesc.无需退货.getValue()+"_"+"4",6L*Const.RATE_UNIT);
	}
	public static Long getByTypeAndLevel(int type,int level){
		return baseServicePrice.get(type+"_"+level);
	}
}

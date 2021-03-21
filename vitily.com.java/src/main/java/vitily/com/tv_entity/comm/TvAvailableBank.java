package vitily.com.tv_entity.comm;
import vitily.com.consts.BankCardTypeDesc;
import vitily.com.consts.PlatformDesc;
import vitily.com.tb_entity.comm.TbAvailableBank;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvAvailableBank extends TbAvailableBank {
	private String typeDesc;
	private String platformDesc;

	public String getTypeDesc() {
		if(CommonUtil.isNull(typeDesc)) {
			typeDesc = EnumHelperUtil.getEnumWrapDescByValue(BankCardTypeDesc.class,this.getType());
		}
		return typeDesc;
	}
	public String getPlatformDesc() {
		if(CommonUtil.isNull(platformDesc)){
			platformDesc = "";
			for(PlatformDesc p:PlatformDesc.values()){
				if(CommonUtil.inStr(this.getPlatform(),String.valueOf(p.getValue()),',')){
					platformDesc+=p.getDesc()+",";
				}
			}
		}
		return platformDesc;
	}
}

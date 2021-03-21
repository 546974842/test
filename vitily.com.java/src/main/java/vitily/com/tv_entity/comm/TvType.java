package vitily.com.tv_entity.comm;

import java.util.List;

import vitily.com.consts.SysTypeDesc;
import vitily.com.tb_entity.comm.TbDynProper;
import vitily.com.tb_entity.comm.TbType;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvType extends TbType {
	/**
	 * 额外属性
	 */
	private List<TbDynProper> dyns;
	/**
	 * 系统类型名称
	 */
	private String sysTypeDesc;
	
	public List<TbDynProper> getDyns() {
		return dyns;
	}
	public void setDyns(List<TbDynProper> dyns) {
		this.dyns = dyns;
	}
	public String getSysTypeDesc(){
		if(CommonUtil.isNull(sysTypeDesc)){
			this.sysTypeDesc = EnumHelperUtil.getEnumWrapDescByValue(SysTypeDesc.class,this.getSysType());
		}
		return sysTypeDesc;
	}
}

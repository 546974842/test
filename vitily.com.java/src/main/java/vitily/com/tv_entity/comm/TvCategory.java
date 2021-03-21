package vitily.com.tv_entity.comm;


import java.util.List;

import vitily.com.consts.SysTypeDesc;
import vitily.com.tb_entity.comm.TbCategory;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvCategory extends TbCategory {
	/**
	 * 系统类型
	 */
	private String sysTypeDesc;
	
	/**
	 * 类型名称
	 */
	private String typeName;
	
	/**
	 * 直接子分类
	 */
	private List<TvCategory> children;

	public String getSysTypeDesc(){
		if(CommonUtil.isNull(sysTypeDesc)){
			this.sysTypeDesc = EnumHelperUtil.getEnumWrapDescByValue(SysTypeDesc.class,this.getSysType());
		}
		return sysTypeDesc;
	}


	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<TvCategory> getChildren() {
		return children;
	}

	public void setChildren(List<TvCategory> children) {
		this.children = children;
	}


}

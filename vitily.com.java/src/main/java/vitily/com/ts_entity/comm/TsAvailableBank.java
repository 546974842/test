package vitily.com.ts_entity.comm;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.comm.TbAvailableBank;
import vitily.com.util.CommonUtil;

public class TsAvailableBank extends BaseSearch<TbAvailableBank> {
	public TsAvailableBank(){
		super(new TbAvailableBank());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selNameOrCode;
	private String typeStr;
	private Integer selPlatform;
	public String getSelNameOrCode() {
		return selNameOrCode;
	}
	public void setSelNameOrCode(String selNameOrCode) {
		this.selNameOrCode = selNameOrCode;
	}
	public String getTypeStr() {
		return typeStr;
	}
	public void setTypeStr(String typeStr) {
		if(CommonUtil.isNumOrD(typeStr)) {
			this.typeStr = typeStr;
		}
	}
	public Integer getSelPlatform() {
		return selPlatform;
	}
	public void setSelPlatform(Integer selPlatform) {
		this.selPlatform = selPlatform;
	}
}

package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbTaskLog;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsTaskLog extends BaseSearch<TbTaskLog> {
	public TsTaskLog(){
		super(new TbTaskLog());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String beginLogTime;
	private String endLogTime;
	
	private String selOperaDesc;
	/**
	 * 类型str：如(1,2,...x)
	 */
	private String typeStr;

	public String getTypeStr() {
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		if(CommonUtil.isNumOrD(typeStr)){
			this.typeStr = typeStr;
		}
	}

	public String getBeginLogTime() {
		return beginLogTime;
	}

	public void setBeginLogTime(String beginLogTime) {
		this.beginLogTime = beginLogTime;
	}

	public String getEndLogTime() {
		return endLogTime;
	}

	public void setEndLogTime(String endLogTime) {
		this.endLogTime = endLogTime;
	}

	public String getSelOperaDesc() {
		return selOperaDesc;
	}

	public void setSelOperaDesc(String selOperaDesc) {
		this.selOperaDesc = selOperaDesc;
	}
}

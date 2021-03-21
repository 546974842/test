package vitily.com.ts_entity.adm;

import vitily.com.tb_entity.adm.TbAdmLog;
import vitily.base.ts_entity.BaseSearch;
import vitily.com.util.CommonUtil;

public class TsAdmLog extends BaseSearch<TbAdmLog> {
	public TsAdmLog(){super(new TbAdmLog());}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 栏目id组合
	 */
	private String columnIdStr;
	/**
	 * 日志时间：开始
	 */
	private String beginLogTime;
	/**
	 * 日志时间：结束
	 */
	private String endLogTime;
	/**
	 * 操作用户：历史
	 */
	private String selUserName;
	/**
	 * 操作用户组合
	 */
	private String selUserIds;
	/**
	 * 操作uri
	 */
	private String selUri;
	/**
	 * 操作描述
	 */
	private String selOperaDesc;
	
	/**
	 * ip
	 */
	private String selIp;

	public String getColumnIdStr() {
		return columnIdStr;
	}

	public void setColumnIdStr(String columnIdStr) {
		if(CommonUtil.isNumOrD(columnIdStr)){
			this.columnIdStr = columnIdStr;
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

	public String getSelUserName() {
		return selUserName;
	}

	public void setSelUserName(String selUserName) {
		this.selUserName = selUserName;
	}

	public String getSelUserIds() {
		return selUserIds;
	}

	public void setSelUserIds(String selUserIds) {
		if(CommonUtil.isNumOrD(selUserIds)){
			this.selUserIds = selUserIds;
		}
	}

	public String getSelUri() {
		return selUri;
	}

	public void setSelUri(String selUri) {
		this.selUri = selUri;
	}

	public String getSelOperaDesc() {
		return selOperaDesc;
	}

	public void setSelOperaDesc(String selOperaDesc) {
		this.selOperaDesc = selOperaDesc;
	}

	public String getSelIp() {
		return selIp;
	}

	public void setSelIp(String selIp) {
		this.selIp = selIp;
	}
}

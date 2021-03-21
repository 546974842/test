package vitily.com.ts_entity.order;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.order.TbOrderDetail;
import vitily.com.tb_entity.order.TbOrderOperaRecord;
import vitily.com.util.CommonUtil;

public class TsOrderOperaRecord extends BaseSearch<TbOrderOperaRecord> {
	public TsOrderOperaRecord(){
		super(new TbOrderOperaRecord());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selIp;
	private String typeStr;

	public String getSelIp() {
		return selIp;
	}

	public void setSelIp(String selIp) {
		this.selIp = selIp;
	}

	public String getTypeStr() {
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		if(CommonUtil.isNumOrD(typeStr)) {
			this.typeStr = typeStr;
		}
	}
}

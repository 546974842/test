package vitily.com.ts_entity.mem;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.mem.TbMemCreditfileCertifyLog;
import vitily.com.util.CommonUtil;

public class TsMemCreditfileCertifyLog extends BaseSearch<TbMemCreditfileCertifyLog> {
	public TsMemCreditfileCertifyLog(){
		super(new TbMemCreditfileCertifyLog());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String creditfileTypeStr;
	private String creditfileStateStr;
	private String selIp;
	private String selMemo;

	public String getCreditfileTypeStr() {
		return creditfileTypeStr;
	}

	public void setCreditfileTypeStr(String creditfileTypeStr) {
		if(CommonUtil.isNumOrD(creditfileTypeStr)) {
			this.creditfileTypeStr = creditfileTypeStr;
		}
	}

	public String getCreditfileStateStr() {
		return creditfileStateStr;
	}

	public void setCreditfileStateStr(String creditfileStateStr) {
		if(CommonUtil.isNumOrD(creditfileStateStr)) {
			this.creditfileStateStr = creditfileStateStr;
		}
	}

	public String getSelIp() {
		return selIp;
	}

	public void setSelIp(String selIp) {
		this.selIp = selIp;
	}

	public String getSelMemo() {
		return selMemo;
	}

	public void setSelMemo(String selMemo) {
		this.selMemo = selMemo;
	}
}

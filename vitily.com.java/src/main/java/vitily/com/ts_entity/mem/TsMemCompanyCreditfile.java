package vitily.com.ts_entity.mem;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.mem.TbMemCompanyCreditfile;
import vitily.com.tb_entity.mem.TbMemCreditHistory;

public class TsMemCompanyCreditfile extends BaseSearch<TbMemCompanyCreditfile> {
	public TsMemCompanyCreditfile(){
		super(new TbMemCompanyCreditfile());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer beginCreditPoints;
	private Integer endCreditPoints;

	private TbMemCreditHistory creditHistory;
	private String auditIp;
	private Integer auditResult;

	public Integer getBeginCreditPoints() {
		return beginCreditPoints;
	}

	public void setBeginCreditPoints(Integer beginCreditPoints) {
		this.beginCreditPoints = beginCreditPoints;
	}

	public Integer getEndCreditPoints() {
		return endCreditPoints;
	}

	public void setEndCreditPoints(Integer endCreditPoints) {
		this.endCreditPoints = endCreditPoints;
	}

	public TbMemCreditHistory getCreditHistory() {
		return creditHistory;
	}

	public void setCreditHistory(TbMemCreditHistory creditHistory) {
		this.creditHistory = creditHistory;
	}

	public String getAuditIp() {
		return auditIp;
	}

	public void setAuditIp(String auditIp) {
		this.auditIp = auditIp;
	}

	public Integer getAuditResult() {
		return auditResult;
	}

	public void setAuditResult(Integer auditResult) {
		this.auditResult = auditResult;
	}
}

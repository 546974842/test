package vitily.com.ts_entity.mem;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.mem.TbMemBankcard;
import vitily.com.util.CommonUtil;

public class TsMemBankcard extends BaseSearch<TbMemBankcard> {
	public TsMemBankcard(){
		super(new TbMemBankcard());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selCode;
	private String selBranch;
	private String selBankName;
	private String selNumber;
	private String typeStr;

	public String getSelCode() {
		return selCode;
	}

	public void setSelCode(String selCode) {
		this.selCode = selCode;
	}

	public String getSelBranch() {
		return selBranch;
	}

	public void setSelBranch(String selBranch) {
		this.selBranch = selBranch;
	}

	public String getSelBankName() {
		return selBankName;
	}

	public void setSelBankName(String selBankName) {
		this.selBankName = selBankName;
	}

	public String getSelNumber() {
		return selNumber;
	}

	public void setSelNumber(String selNumber) {
		this.selNumber = selNumber;
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

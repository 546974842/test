package vitily.com.ts_entity.mem;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.mem.TbMemLocalAccount;

public class TsMemLocalAccount extends BaseSearch<TbMemLocalAccount> {
	public TsMemLocalAccount(){
		super(new TbMemLocalAccount());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer oldVersion;
	public Integer getOldVersion() {
		return oldVersion;
	}
	public void setOldVersion(Integer oldVersion) {
		this.oldVersion = oldVersion;
	}
}

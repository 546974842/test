package vitily.com.ts_entity.adm;

import vitily.com.tb_entity.adm.TbAdmRole;
import vitily.base.ts_entity.BaseSearch;

public class TsAdmRole extends BaseSearch<TbAdmRole> {
	public TsAdmRole(){
		super(new TbAdmRole());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 分组名称：模糊查询
	 */
	private String selName;

	public String getSelName() {
		return selName;
	}

	public void setSelName(String selName) {
		this.selName = selName;
	}
}

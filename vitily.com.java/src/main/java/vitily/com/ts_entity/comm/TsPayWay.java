package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbPayWay;
import vitily.base.ts_entity.BaseSearch;

public class TsPayWay extends BaseSearch<TbPayWay> {
	public TsPayWay(){
		super(new TbPayWay());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selName;
	public String getSelName() {
		return selName;
	}
	public void setSelName(String selName) {
		this.selName = selName;
	}
}

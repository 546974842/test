package vitily.com.ts_entity.comm;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.comm.TbRegion;

public class TsRegion extends BaseSearch<TbRegion> {
	public TsRegion(){
		super(new TbRegion());
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

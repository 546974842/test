package vitily.com.ts_entity.pro;

import vitily.com.tb_entity.pro.TbProSpVal;
import vitily.base.ts_entity.BaseSearch;

public class TsProSpVal extends BaseSearch<TbProSpVal> {
	public TsProSpVal(){
		super(new TbProSpVal());
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

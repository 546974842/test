package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbDeliveryWay;
import vitily.base.ts_entity.BaseSearch;

public class TsDeliveryWay extends BaseSearch<TbDeliveryWay> {
	public TsDeliveryWay(){
		super(new TbDeliveryWay());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long beginPrice;//单位：分
	private Long endPrice;//单位：分
	private String selName;
	public Long getBeginPrice() {
		return beginPrice;
	}
	public void setBeginPrice(Long beginPrice) {
		this.beginPrice = beginPrice;
	}
	public Long getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(Long endPrice) {
		this.endPrice = endPrice;
	}
	public String getSelName() {
		return selName;
	}
	public void setSelName(String selName) {
		this.selName = selName;
	}
	
}

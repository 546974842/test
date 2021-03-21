package vitily.com.tv_entity.order;

import vitily.com.tb_entity.order.TbOrderDetail;
import vitily.com.util.CommonUtil;

public class TvOrderDetail extends TbOrderDetail {
	/**
	 * 产品旧的库存
	 */
	private int proStock;
	
	/**
	 * 产品旧的版本:默认是0如果没有则初始化0
	 */
	private Integer proVersion=0;


	public int getProStock() {
		return proStock;
	}

	public void setProStock(int proStock) {
		this.proStock = proStock;
	}

	public Integer getProVersion() {
		return proVersion;
	}

	public void setProVersion(Integer proVersion) {
		if(!CommonUtil.isNull(proVersion)){
			this.proVersion = proVersion;
		}
	}

}

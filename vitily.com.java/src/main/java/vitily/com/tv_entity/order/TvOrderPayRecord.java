package vitily.com.tv_entity.order;

import vitily.com.tb_entity.order.TbOrderPayRecord;

public class TvOrderPayRecord extends TbOrderPayRecord {
	private String payWayName;
	private String memName;
	public String getPayWayName() {
		return payWayName;
	}
	public void setPayWayName(String payWayName) {
		this.payWayName = payWayName;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}

}

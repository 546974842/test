package vitily.com.tv_entity.pro;

import vitily.com.tb_entity.pro.TbProMemPri;

public class TvProMemPri extends TbProMemPri {
	/**
	 * 会员分组名称
	 */
	private String memGroupName;
	/**
	 * 该会员（组）所享受的原百分比
	 */
	private Double percent;

	public String getMemGroupName() {
		return memGroupName;
	}

	public void setMemGroupName(String memGroupName) {
		this.memGroupName = memGroupName;
	}

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}



}

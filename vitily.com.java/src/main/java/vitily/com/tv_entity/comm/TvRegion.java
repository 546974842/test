package vitily.com.tv_entity.comm;


import vitily.com.tb_entity.comm.TbRegion;

public class TvRegion extends TbRegion {
	private String parentName;
	private boolean hasSon;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public boolean isHasSon() {
		return hasSon;
	}

	public void setHasSon(boolean hasSon) {
		this.hasSon = hasSon;
	}
}

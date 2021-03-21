package vitily.com.tv_entity.comm;

import vitily.com.tb_entity.comm.TbMessage;

public class TvMessage extends TbMessage {
	private String memName;
	private String adminName;
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

}

package vitily.com.ts_entity.adm;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.adm.TbAdmAideMemoire;

public class TsAdmAideMemoire extends BaseSearch<TbAdmAideMemoire> {
	public TsAdmAideMemoire(){
		super(new TbAdmAideMemoire());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selTitle;
	private String beginRemindTime;
	private String endRemindTime;
	private String selLabelId;

	public String getSelTitle() {
		return selTitle;
	}

	public void setSelTitle(String selTitle) {
		this.selTitle = selTitle;
	}

	public String getBeginRemindTime() {
		return beginRemindTime;
	}

	public void setBeginRemindTime(String beginRemindTime) {
		this.beginRemindTime = beginRemindTime;
	}

	public String getEndRemindTime() {
		return endRemindTime;
	}

	public void setEndRemindTime(String endRemindTime) {
		this.endRemindTime = endRemindTime;
	}

	public String getSelLabelId() {
		return selLabelId;
	}

	public void setSelLabelId(String selLabelId) {
		this.selLabelId = selLabelId;
	}
}

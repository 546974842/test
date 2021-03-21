package vitily.com.ts_entity.adm;

import vitily.base.ts_entity.BaseSearch;
import vitily.com.tb_entity.adm.TbAdmMsg;

public class TsAdmMsg extends BaseSearch<TbAdmMsg> {
	public TsAdmMsg(){
		super(new TbAdmMsg());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selTitle;
	private String selLabelId;

	private Integer memGroupId;

	public String getSelTitle() {
		return selTitle;
	}

	public void setSelTitle(String selTitle) {
		this.selTitle = selTitle;
	}

	public String getSelLabelId() {
		return selLabelId;
	}

	public void setSelLabelId(String selLabelId) {
		this.selLabelId = selLabelId;
	}

	public Integer getMemGroupId() {
		return memGroupId;
	}

	public void setMemGroupId(Integer memGroupId) {
		this.memGroupId = memGroupId;
	}
}

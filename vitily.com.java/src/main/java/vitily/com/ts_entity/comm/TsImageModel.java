package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbImageModel;
import vitily.base.ts_entity.BaseSearch;

public class TsImageModel extends BaseSearch<TbImageModel> {
	public TsImageModel(){
		super(new TbImageModel());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 哪个标签
	 */
	private Integer selLabelId;

	public Integer getSelLabelId() {
		return selLabelId;
	}

	public void setSelLabelId(Integer selLabelId) {
		this.selLabelId = selLabelId;
	}
}

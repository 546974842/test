package vitily.com.tv_entity.comm;

import vitily.com.tb_entity.comm.TbAdvertise;
import vitily.com.util.CommonUtil;

public class TvAdvertise extends TbAdvertise {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String typeName;
	
	/**
	 * 列表图片
	 */
	private String imgSamUrlDesc;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getImgSamUrlDesc() {
		if(CommonUtil.isNull(imgSamUrlDesc)){
			this.imgSamUrlDesc =  "<img style='width:40px;' src='"+this.getImgSamUrl() + "' />";
		}
		return imgSamUrlDesc;
	}


}

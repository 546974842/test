package vitily.com.tv_entity.pro;

import java.util.List;

import vitily.com.consts.ShowTypeDesc;
import vitily.com.tb_entity.pro.TbProSpec;
import vitily.com.tb_entity.pro.TbProSpAttr;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvProSpec extends TbProSpec {
	private List<TbProSpAttr> pars;
	/**
	 * 显示类型
	 */
	private String showTypeDesc;
	public String getShowTypeDesc(){
		if(CommonUtil.isNull(showTypeDesc)){
			this.showTypeDesc = EnumHelperUtil.getEnumWrapDescByValue(ShowTypeDesc.class,this.getShowType());
		}
		return showTypeDesc;
	}

	public List<TbProSpAttr> getPars() {
		return pars;
	}
	public void setPars(List<TbProSpAttr> pars) {
		this.pars = pars;
	}


}

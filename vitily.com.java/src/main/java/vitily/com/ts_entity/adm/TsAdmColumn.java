package vitily.com.ts_entity.adm;

import vitily.com.tb_entity.adm.TbAdmColumn;
import vitily.base.ts_entity.BaseSearch;

public class TsAdmColumn extends BaseSearch<TbAdmColumn> {
	public TsAdmColumn(){
		super(new TbAdmColumn());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 栏目名称：模糊查询
	 */
	private String selName;
	/**
	 * 栏目连接地址：模糊查询
	 */
	private String selUriLink;
	public String getSelName() {
		return selName;
	}
	public void setSelName(String selName) {
		this.selName = selName;
	}
	public String getSelUriLink() {
		return selUriLink;
	}
	public void setSelUriLink(String selUriLink) {
		this.selUriLink = selUriLink;
	}
}

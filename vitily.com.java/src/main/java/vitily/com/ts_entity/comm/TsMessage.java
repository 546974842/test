package vitily.com.ts_entity.comm;

import vitily.com.tb_entity.comm.TbMessage;
import vitily.base.ts_entity.BaseSearch;

public class TsMessage extends BaseSearch<TbMessage> {
	public TsMessage(){
		super(new TbMessage());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selTitle;
	private String selName;
	private String selPost;
	private String selEmail;
	private String selPhone;
	private String selProvince;
	private String selCompany;
	public String getSelTitle() {
		return selTitle;
	}
	public void setSelTitle(String selTitle) {
		this.selTitle = selTitle;
	}
	public String getSelName() {
		return selName;
	}
	public void setSelName(String selName) {
		this.selName = selName;
	}
	public String getSelPost() {
		return selPost;
	}
	public void setSelPost(String selPost) {
		this.selPost = selPost;
	}
	public String getSelEmail() {
		return selEmail;
	}
	public void setSelEmail(String selEmail) {
		this.selEmail = selEmail;
	}
	public String getSelPhone() {
		return selPhone;
	}
	public void setSelPhone(String selPhone) {
		this.selPhone = selPhone;
	}
	public String getSelProvince() {
		return selProvince;
	}
	public void setSelProvince(String selProvince) {
		this.selProvince = selProvince;
	}
	public String getSelCompany() {
		return selCompany;
	}
	public void setSelCompany(String selCompany) {
		this.selCompany = selCompany;
	}
	
}

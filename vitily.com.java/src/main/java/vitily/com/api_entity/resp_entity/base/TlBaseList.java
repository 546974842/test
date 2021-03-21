package vitily.com.api_entity.resp_entity.base;

import java.io.Serializable;

import vitily.base.ts_entity.PageInfo;

public class TlBaseList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PageInfo pageInfo = new PageInfo();

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	
}

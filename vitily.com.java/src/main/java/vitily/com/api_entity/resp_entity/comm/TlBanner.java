package vitily.com.api_entity.resp_entity.comm;

import java.util.ArrayList;
import java.util.List;

import vitily.com.api_entity.resp_entity.base.TlBaseList;
import vitily.com.tv_entity.comm.TvBanner;

/**
 * 列表
 * @author lether
 *
 */
public class TlBanner extends TlBaseList{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<TvBanner> list=new ArrayList<>();
	public List<TvBanner> getList() {
		return list;
	}
	public void setList(List<TvBanner> list) {
		this.list = list;
	}
}

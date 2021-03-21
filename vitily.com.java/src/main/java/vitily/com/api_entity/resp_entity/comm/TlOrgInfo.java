package vitily.com.api_entity.resp_entity.comm;

import java.util.ArrayList;
import java.util.List;

import vitily.com.api_entity.resp_entity.base.TlBaseList;
import vitily.com.tv_entity.comm.TvOrgInfo;

/**
 * 列表
 * @author lether
 *
 */
public class TlOrgInfo extends TlBaseList{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 普通机构列表
	 */
	List<TvOrgInfo> list =new ArrayList<>();
	public List<TvOrgInfo> getList() {
		return list;
	}
	public void setList(List<TvOrgInfo> list) {
		this.list = list;
	}
}

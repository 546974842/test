package vitily.com.api_entity.resp_entity.comm;

import java.util.ArrayList;
import java.util.List;

import vitily.com.api_entity.resp_entity.base.TlBaseList;
import vitily.com.tv_entity.comm.TvAdvertise;

/**
 * 列表
 * @author lether
 *
 */
public class TlAdvertise extends TlBaseList{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<TvAdvertise> advertiseList=new ArrayList<>();
	public List<TvAdvertise> getAdvertiseList() {
		return advertiseList;
	}
	public void setAdvertiseList(List<TvAdvertise> advertiseList) {
		this.advertiseList = advertiseList;
	}
}

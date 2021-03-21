package vitily.com.api_entity.resp_entity.comm;

import java.util.ArrayList;
import java.util.List;

import vitily.com.api_entity.resp_entity.base.TlBaseList;
import vitily.com.tv_entity.comm.TvLabel;

/**
 * 列表
 * @author lether
 *
 */
public class TlLabel extends TlBaseList{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<TvLabel> labels=new ArrayList<>();
	public List<TvLabel> getLabels() {
		return labels;
	}
	public void setLabels(List<TvLabel> labels) {
		this.labels = labels;
	}
}

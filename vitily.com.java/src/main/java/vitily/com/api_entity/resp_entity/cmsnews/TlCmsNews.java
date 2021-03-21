package vitily.com.api_entity.resp_entity.cmsnews;

import java.util.ArrayList;
import java.util.List;

import vitily.com.api_entity.resp_entity.base.TlBaseList;
import vitily.com.tv_entity.cms.TvCmsNews;

/**
 * 列表
 * @author lether
 *
 */
public class TlCmsNews extends TlBaseList{
	private static final long serialVersionUID = 1L;
	List<TvCmsNews> newsList=new ArrayList<>();
	public List<TvCmsNews> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<TvCmsNews> newsList) {
		this.newsList = newsList;
	}
	
}

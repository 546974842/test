package vitily.com.service.base;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vitily.base.tb_entity.BaseEntity;
import vitily.base.tv_entity.TvPageList;

public interface BasicService<T extends BaseEntity,S,V extends T> {

	TvPageList getPagingList(S bean)throws Exception;
	Integer getCountPaging(S bean)throws Exception;
	List<?> getListByBean(S bean)throws Exception;
	T getMaxBean(S bean);
	T selectByPrimaryKey(int id)throws Exception;
	T selectSingleByBean(S bean)throws Exception;
	T selectByPrimaryKeyOfNoCheck(int id)throws Exception;
	V selectByPrimaryKeyForTv(int id)throws Exception;
	
	void sort(T bean, List <Integer> ids, List <Double> sorts)throws Exception;
	void updateDeltag(T bean, List <Integer> ids, int delTag)throws Exception;
	int insert(S bean)throws Exception;
	int update(S bean)throws Exception;
	int updateByTs(S bean)throws Exception;
	void export(HttpServletRequest request,HttpServletResponse response,String excelName, 
			S queryEntity, LinkedHashMap<String, String> fieldMap)throws Exception;
}

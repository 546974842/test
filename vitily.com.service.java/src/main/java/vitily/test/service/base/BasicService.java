package vitily.test.service.base;

import vitily.base.tb_entity.BaseEntity;
import vitily.base.tv_entity.TvPageList;

import java.util.List;

public interface BasicService<T extends BaseEntity,S,V extends T> {

	TvPageList getPagingList(S bean)throws Exception;
	Integer getCountPaging(S bean)throws Exception;
	List<?> getListByBean(S bean)throws Exception;
	T getMaxBean(S bean);
	T selectByPrimaryKey(int id)throws Exception;
	int insertSelective(T bean)throws Exception;
	int updateByPrimaryKeySelective(T bean)throws Exception;
	V selectByPrimaryKeyForTv(int id)throws Exception;
	
	void sort(T bean, List <Integer> ids, List <Double> sorts)throws Exception;
	void updateDeltag(T bean, List <Integer> ids, int delTag)throws Exception;
	int insert(S bean)throws Exception;
	int update(S bean)throws Exception;
}

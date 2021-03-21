package vitily.com.cache;

import java.util.List;
import java.util.Map;

import vitily.com.tv_entity.comm.TvCategory;

/**
 * 分类缓存
 * @author lether
 *
 */
public interface CategoryCache extends BaseCache {

	/**
	 * 获取分类列表 1
	 * @return 2
	 */
	Map<String, TvCategory> getCateMap()throws Exception;
	/**
	 * 获取分类列表
	 * @return 1
	 */
	List<TvCategory> getCateList()throws Exception;
	/**
	 * 通过id获取分类
	 * @param urlTip 1
	 * @return 2
	 */
	TvCategory getValue(String urlTip)throws Exception;
	/**
	 * 通过id获取
	 * @param id 1
	 * @return 2
	 */
	TvCategory getValue(Integer id)throws Exception;
	/**
	 * 根据父级id获取分类列表
	 * @return 2
	 */
	Map<String, TvCategory> getCateMap(Integer parentId)throws Exception;
	/**
	 * 根据父级 urltip获取子分类列表
	 * @return 2
	 */
	Map<String, TvCategory> getCateMap(String urlTip)throws Exception;
	/**
	 * 根据父级id获取子分类列表
	 * @return 2
	 */
	List<TvCategory> getCateList(Integer parentId)throws Exception;
	/**
	 * 根据父级 urltip获取子分类列表
	 * @return 2
	 */
	List<TvCategory> getCateList(String urlTip)throws Exception;
	/**
	 * 批量更新
	 * @param map 1
	 * @return 2
	 */
	String setCategory(Map<String, TvCategory> map)throws Exception;
	String setCategory(TvCategory entity)throws Exception;
	/**
	 * 初始化
	 * @param list 1
	 */
	void init(List<TvCategory> list)throws Exception;
}

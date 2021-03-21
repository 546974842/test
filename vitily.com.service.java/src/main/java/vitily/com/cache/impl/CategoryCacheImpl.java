package vitily.com.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.cache.CategoryCache;
import vitily.com.cache.DictionaryCache;
import vitily.com.consts.DictionaryKey;
import vitily.com.tv_entity.comm.TvCategory;
import vitily.com.util.CommonUtil;
import vitily.com.util.MD5;
import vitily.com.util.cache.ViyBasicCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口缓存
 * @author lether
 *
 */
@Component
public final class CategoryCacheImpl extends BaseCacheImpl implements CategoryCache {
	
	/**
	 * 单一
	 */
	@Autowired
	private CategoryCacheImpl(DictionaryCache dictionaryCache,ViyBasicCache viyBasicCache){
		//null使用字典缓存里的时长
		super(DictionaryKey.Keys.分类.getValue(),null,dictionaryCache,viyBasicCache);
	}
	/**
	 * 根据id获取实体
	 */
	@Override
	public TvCategory getValue(String urlTip)throws Exception {
		return (TvCategory)hget("", MD5.getMD5(urlTip));
	}
	/**
	 * 如果不存在：返回一个新的
	 */
	public TvCategory getValue(Integer id)throws Exception{
		Map<String, TvCategory> map = (Map<String, TvCategory>)hgetAll("");
		for (Map.Entry<String, TvCategory> entry : map.entrySet()) {
			if(CommonUtil.isEqual(entry.getValue().getId(), id)){
				return entry.getValue();
			}
		}
		return new TvCategory();
		
	}
	/**
	 * 从缓存中获取分类列表
	 */
	@Override
	public Map<String, TvCategory> getCateMap()throws Exception {
		return (Map<String, TvCategory>)hgetAll("");
	}/**
	 * 从缓存中获取分类列表
	 */
	@Override
	public List<TvCategory> getCateList()throws Exception {
		return new ArrayList<>(getCateMap().values());
	}
	

	/**
	 * 根据父级id获取子列表
	 */
	@Override
	public Map<String, TvCategory> getCateMap(Integer parentId)throws Exception {
		Map<String, TvCategory> map = (Map<String, TvCategory>)hgetAll("");
		Map<String, TvCategory> newMap = new HashMap<>();
		for (Map.Entry<String, TvCategory> entry : map.entrySet()) {
			if(CommonUtil.isEqual(entry.getValue().getParentId(), parentId)){
				newMap.put(entry.getKey(), entry.getValue());
			}
		}
		return newMap;
	}
	/**
	 * 根据父级的urlTip 获取子分类列表
	 */
	@Override
	public Map<String, TvCategory> getCateMap(String urlTip)throws Exception {
		TvCategory curTvCategory = getValue(urlTip);
		return getCateMap(curTvCategory.getId());
	}
	@Override
	public List<TvCategory> getCateList(Integer parentId)throws Exception {
		return new ArrayList<>(getCateMap(parentId).values());
	}
	@Override
	public List<TvCategory> getCateList(String urlTip)throws Exception {
		return new ArrayList<>(getCateMap(urlTip).values());
	}
	/**
	 * 批量设置map列表
	 * 判断：如果删除则将这些干掉
	 */
	@Override
	public String setCategory(Map<String, TvCategory> map)throws Exception {
		return "ok";
	}
	@Override
	public String setCategory(TvCategory e)throws Exception {
		return "ok";
	}

	@Override
	public void init(List<TvCategory> list)throws Exception {
	}
	
}

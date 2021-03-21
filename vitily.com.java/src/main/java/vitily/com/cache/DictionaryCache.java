package vitily.com.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vitily.com.tb_entity.comm.TbDictionary;
import vitily.com.tv_entity.comm.TvDictionary;

public interface DictionaryCache extends BaseCache {
	/**
	 * 获取 static
	 * 返回的是左值 可以随意更新
	 * @return 1
	 */
	HashMap<String, String> getPubDicHashMap()throws Exception;
	/**
	 * 单个更新:
	 * @param key 1
	 * @param value 2
	 */
	String setDictionary(TbDictionary dictionary)throws Exception;
	/**
	 * 批量更新
	 * @param map 1
	 * @return 2
	 */
	String ListenDictionary(Map<String, String> map)throws Exception;
	/**
	 * 获得字典值:直接从 map获取
	 * @param dictionaryKey 1
	 */
	String getValue(String dictionaryKey)throws Exception;
	
	/**
	 * 删除一个字典：一般不允许删除字典
	 * @param dicianaryKey 1
	 * @return 2
	 * @throws Exception 3
	 */
	String removeKey(String dicianaryKey)throws Exception;
	/**
	 * 初始化字典列表（服务器跟本地一起）
	 * @param list 1
	 */
	void init(List<TvDictionary> list)throws Exception;
}

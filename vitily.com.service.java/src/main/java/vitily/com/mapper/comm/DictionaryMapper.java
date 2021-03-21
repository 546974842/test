package vitily.com.mapper.comm;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.comm.TbDictionary;
import vitily.com.ts_entity.comm.TsDictionary;
import vitily.com.tv_entity.comm.TvDictionary;

public interface DictionaryMapper extends BaseMapper<TbDictionary,TsDictionary,TvDictionary> {
	void updateByDicKey(TbDictionary t);
}

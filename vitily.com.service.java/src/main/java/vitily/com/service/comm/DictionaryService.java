package vitily.com.service.comm;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.comm.TbDictionary;
import vitily.com.ts_entity.comm.TsDictionary;
import vitily.com.tv_entity.comm.TvDictionary;

public interface DictionaryService extends BasicService<TbDictionary,TsDictionary,TvDictionary> {
	void updateByDicKey(TbDictionary entity);
}
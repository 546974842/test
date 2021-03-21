package vitily.com.mapper.cms;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.cms.TbCmsNews;
import vitily.com.ts_entity.cms.TsCmsNews;
import vitily.com.tv_entity.cms.TvCmsNews;

public interface CmsNewsMapper extends BaseMapper<TbCmsNews,TsCmsNews,TvCmsNews> {
	void updateByBean(TsCmsNews bean)throws Exception;
}

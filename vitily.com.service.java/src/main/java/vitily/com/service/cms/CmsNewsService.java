package vitily.com.service.cms;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.cms.TbCmsNews;
import vitily.com.ts_entity.cms.TsCmsNews;
import vitily.com.tv_entity.cms.TvCmsNews;

public interface CmsNewsService extends BasicService<TbCmsNews,TsCmsNews,TvCmsNews> {
    void updateByBean(TsCmsNews bean)throws Exception;
}
package vitily.com.service_adapter;

import vitily.com.tb_entity.cms.TbCmsDynproVal;

import java.util.List;

public interface CmsNewsAdapter {
    void bitInsertCmsDynproVals(Integer typeId,Integer newsId,String guid,List<TbCmsDynproVal> gens)throws Exception;
}

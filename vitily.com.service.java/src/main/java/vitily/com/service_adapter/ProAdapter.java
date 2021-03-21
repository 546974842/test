package vitily.com.service_adapter;

import vitily.com.tb_entity.pro.TbProDynproVal;
import vitily.com.tv_entity.pro.TvProMemPri;

import java.util.Date;
import java.util.List;

public interface ProAdapter {
    void bitInsertProMemPris(Integer productId, String guid, Date now, Integer specParProId, String specParIds, List<TvProMemPri> pmps)throws Exception;
    void bitInsertProDynproVals(Integer typeId,Integer productId, Date now,String guid,List<TbProDynproVal> gens);
}

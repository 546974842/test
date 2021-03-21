package vitily.com.service.comm;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.comm.TbImageModel;
import vitily.com.ts_entity.comm.TsImageModel;
import vitily.com.tv_entity.comm.TvImageModel;

import java.util.List;

public interface ImageModelService extends BasicService<TbImageModel,TsImageModel,TvImageModel> {
    void bitInsert(List <TbImageModel> list);
}
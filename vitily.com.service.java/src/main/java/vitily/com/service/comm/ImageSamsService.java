package vitily.com.service.comm;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.comm.TbImageSams;
import vitily.com.ts_entity.comm.TsImageSams;
import vitily.com.tv_entity.comm.TvImageSams;

import java.util.List;

public interface ImageSamsService extends BasicService<TbImageSams,TsImageSams,TvImageSams> {
    void bitInsert(List <TbImageSams> list);
}
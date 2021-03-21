package vitily.com.mapper.comm;

import java.util.List;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.comm.TbImageModel;
import vitily.com.ts_entity.comm.TsImageModel;
import vitily.com.tv_entity.comm.TvImageModel;

public interface ImageModelMapper extends BaseMapper<TbImageModel,TsImageModel,TvImageModel> {
	/**
	 * 插入图片
	 * @param list 1
	 */
	void bitInsert(List <TbImageModel> list);
}

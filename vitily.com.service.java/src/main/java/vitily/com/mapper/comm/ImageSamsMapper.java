package vitily.com.mapper.comm;

import java.util.List;

import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.comm.TbImageSams;
import vitily.com.ts_entity.comm.TsImageSams;
import vitily.com.tv_entity.comm.TvImageSams;

public interface ImageSamsMapper extends BaseMapper<TbImageSams,TsImageSams,TvImageSams> {
	/**
	 * 插入图片
	 * @param list 1
	 */
	void bitInsert(List <TbImageSams> list);
}

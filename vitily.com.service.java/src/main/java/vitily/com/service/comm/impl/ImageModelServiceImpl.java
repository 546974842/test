package vitily.com.service.comm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vitily.com.tb_entity.comm.TbImageModel;
import vitily.com.ts_entity.comm.TsImageModel;
import vitily.com.tv_entity.comm.TvImageModel;
import vitily.com.mapper.comm.ImageModelMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.ImageModelService;

@Component
public class ImageModelServiceImpl extends BasicServiceImpl<TbImageModel,TsImageModel,TvImageModel> implements ImageModelService {

	final
	ImageModelMapper imageModelMapper;

	@Autowired()
	public ImageModelServiceImpl(ImageModelMapper imageModelMapper) {
		this.imageModelMapper = imageModelMapper;
		super.setBaseMapper(imageModelMapper);
	}
	/** 
     * 批量插入
     * @param list 1
     */
    public void bitInsert(List<TbImageModel> list){
		imageModelMapper.bitInsert(list);
    }
}
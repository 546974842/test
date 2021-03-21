package vitily.com.service.comm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbImageSams;
import vitily.com.ts_entity.comm.TsImageSams;
import vitily.com.tv_entity.comm.TvImageSams;
import vitily.com.mapper.comm.ImageSamsMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.ImageSamsService;

@Component
public class ImageSamsServiceImpl extends BasicServiceImpl<TbImageSams,TsImageSams,TvImageSams> implements ImageSamsService {

	final
	ImageSamsMapper imageSamsMapper;

	@Autowired()
	public ImageSamsServiceImpl(ImageSamsMapper imageSamsMapper) {
		this.imageSamsMapper = imageSamsMapper;
		super.setBaseMapper(imageSamsMapper);
	}
	/** 
     * 批量插入
     * @param list 1
     */
    public void bitInsert(List<TbImageSams> list){
		imageSamsMapper.bitInsert(list);
    }
}
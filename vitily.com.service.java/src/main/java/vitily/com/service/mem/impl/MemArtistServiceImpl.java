package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.consts.DelTagDesc;
import vitily.com.consts.StateDesc;
import vitily.com.mapper.mem.MemArtistMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemArtistService;
import vitily.com.tb_entity.mem.TbMemArtist;
import vitily.com.ts_entity.mem.TsMemArtist;
import vitily.com.tv_entity.mem.TvMemArtist;

import java.util.Date;

@Component
public class MemArtistServiceImpl extends BasicServiceImpl<TbMemArtist,TsMemArtist,TvMemArtist> implements MemArtistService {

	final MemArtistMapper memArtistMapper;

	@Autowired()
	public MemArtistServiceImpl(MemArtistMapper memArtistMapper) {
		this.memArtistMapper = memArtistMapper;
		super.setBaseMapper(memArtistMapper);
	}

	@Override
	public void insertOrUpdate(TbMemArtist entity) {
		TsMemArtist tsMemArtist = new TsMemArtist();
		tsMemArtist.setEntity(entity);
		if(memArtistMapper.isExists(tsMemArtist)){
			memArtistMapper.updateByPrimaryKeySelective(entity);
		}else{
			entity.setCreateDate(new Date());
			entity.setState(StateDesc.正常.getValue());
			entity.setDeltag(DelTagDesc.正常.getValue());
			entity.setSort(0D);
			memArtistMapper.insertSelective(entity);
		}
	}
}
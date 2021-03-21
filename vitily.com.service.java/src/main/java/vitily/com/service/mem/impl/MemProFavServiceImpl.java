package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.mem.TbMemProFav;
import vitily.com.mapper.mem.MemProFavMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemProFavService;
import vitily.com.ts_entity.mem.TsMemProFav;
import vitily.com.tv_entity.mem.TvMemProFav;

@Component
public class MemProFavServiceImpl extends BasicServiceImpl<TbMemProFav,TsMemProFav,TvMemProFav> implements MemProFavService {

	final
	MemProFavMapper memProFavMapper;

	@Autowired()
	public MemProFavServiceImpl(MemProFavMapper memProFavMapper) {
		this.memProFavMapper = memProFavMapper;
		super.setBaseMapper(memProFavMapper);
	}
}
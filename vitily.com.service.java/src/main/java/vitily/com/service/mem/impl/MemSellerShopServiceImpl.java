package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.mem.TbMemSellerShop;
import vitily.com.mapper.mem.MemSellerShopMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemSellerShopService;
import vitily.com.ts_entity.mem.TsMemSellerShop;
import vitily.com.tv_entity.mem.TvMemSellerShop;

@Component
public class MemSellerShopServiceImpl extends BasicServiceImpl<TbMemSellerShop,TsMemSellerShop,TvMemSellerShop> implements MemSellerShopService {

	final
	MemSellerShopMapper memSellerShopMapper;

	@Autowired()
	public MemSellerShopServiceImpl(MemSellerShopMapper memSellerShopMapper) {
		this.memSellerShopMapper = memSellerShopMapper;
		super.setBaseMapper(memSellerShopMapper);
	}
}
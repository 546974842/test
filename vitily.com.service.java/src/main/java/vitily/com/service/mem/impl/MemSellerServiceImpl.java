package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.mapper.mem.MemSellerMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemSellerService;
import vitily.com.tb_entity.mem.TbMemSeller;
import vitily.com.ts_entity.mem.TsMemSeller;
import vitily.com.tv_entity.mem.TvMemSeller;

@Component
public class MemSellerServiceImpl extends BasicServiceImpl<TbMemSeller, TsMemSeller, TvMemSeller> implements MemSellerService {

    final MemSellerMapper memSellerMapper;

    @Autowired
    public MemSellerServiceImpl(MemSellerMapper memSellerMapper) {
        this.memSellerMapper = memSellerMapper;
        super.setBaseMapper(memSellerMapper);
    }
}
package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.mapper.mem.MemIntegralMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemIntegralService;
import vitily.com.tb_entity.mem.TbMemIntegral;
import vitily.com.ts_entity.mem.TsMemIntegral;
import vitily.com.tv_entity.mem.TvMemIntegral;

@Component
public class MemIntegralServiceImpl extends BasicServiceImpl<TbMemIntegral, TsMemIntegral, TvMemIntegral> implements MemIntegralService {

    final MemIntegralMapper memIntegralMapper;

    @Autowired
    public MemIntegralServiceImpl(MemIntegralMapper memIntegralMapper) {
        this.memIntegralMapper = memIntegralMapper;
        super.setBaseMapper(memIntegralMapper);
    }
}
package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.mapper.mem.MemMocardMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemMocardService;
import vitily.com.tb_entity.mem.TbMemMocard;
import vitily.com.ts_entity.mem.TsMemMocard;
import vitily.com.tv_entity.mem.TvMemMocard;

@Component
public class MemMocardServiceImpl extends BasicServiceImpl<TbMemMocard, TsMemMocard, TvMemMocard> implements MemMocardService {

    final MemMocardMapper memMocardMapper;

    @Autowired
    public MemMocardServiceImpl(MemMocardMapper memMocardMapper) {
        this.memMocardMapper = memMocardMapper;
        super.setBaseMapper(memMocardMapper);
    }
}
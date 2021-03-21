package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.mapper.mem.MemIntegralFlowMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemIntegralFlowService;
import vitily.com.tb_entity.mem.TbMemIntegralFlow;
import vitily.com.ts_entity.mem.TsMemIntegralFlow;
import vitily.com.tv_entity.mem.TvMemIntegralFlow;

@Component
public class MemIntegralFlowServiceImpl extends BasicServiceImpl<TbMemIntegralFlow, TsMemIntegralFlow, TvMemIntegralFlow> implements MemIntegralFlowService {

    final MemIntegralFlowMapper memIntegralFlowMapper;

    @Autowired
    public MemIntegralFlowServiceImpl(MemIntegralFlowMapper memIntegralFlowMapper) {
        this.memIntegralFlowMapper = memIntegralFlowMapper;
        super.setBaseMapper(memIntegralFlowMapper);
    }
}
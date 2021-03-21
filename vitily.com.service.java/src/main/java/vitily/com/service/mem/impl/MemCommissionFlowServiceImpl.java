package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.mapper.mem.MemCommissionFlowMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemCommissionFlowService;
import vitily.com.tb_entity.mem.TbMemCommissionFlow;
import vitily.com.ts_entity.mem.TsMemCommissionFlow;
import vitily.com.tv_entity.mem.TvMemCommissionFlow;

@Component
public class MemCommissionFlowServiceImpl extends BasicServiceImpl<TbMemCommissionFlow, TsMemCommissionFlow, TvMemCommissionFlow> implements MemCommissionFlowService {

    final MemCommissionFlowMapper memCommissionFlowMapper;

    @Autowired
    public MemCommissionFlowServiceImpl(MemCommissionFlowMapper memCommissionFlowMapper) {
        this.memCommissionFlowMapper = memCommissionFlowMapper;
        super.setBaseMapper(memCommissionFlowMapper);
    }
}
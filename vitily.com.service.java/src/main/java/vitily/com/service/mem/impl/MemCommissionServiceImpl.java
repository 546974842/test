package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.mapper.mem.MemCommissionMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemCommissionService;
import vitily.com.tb_entity.mem.TbMemCommission;
import vitily.com.ts_entity.mem.TsMemCommission;
import vitily.com.tv_entity.mem.TvMemCommission;

@Component
public class MemCommissionServiceImpl extends BasicServiceImpl<TbMemCommission, TsMemCommission, TvMemCommission> implements MemCommissionService {

    final MemCommissionMapper memCommissionMapper;

    @Autowired
    public MemCommissionServiceImpl(MemCommissionMapper memCommissionMapper) {
        this.memCommissionMapper = memCommissionMapper;
        super.setBaseMapper(memCommissionMapper);
    }
}
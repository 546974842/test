package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.mapper.mem.MemModelInfoMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemModelInfoService;
import vitily.com.tb_entity.mem.TbMemModelInfo;
import vitily.com.ts_entity.mem.TsMemModelInfo;
import vitily.com.tv_entity.mem.TvMemModelInfo;

@Component
public class MemModelInfoServiceImpl extends BasicServiceImpl<TbMemModelInfo, TsMemModelInfo, TvMemModelInfo> implements MemModelInfoService {

    final MemModelInfoMapper memModelInfoMapper;

    @Autowired
    public MemModelInfoServiceImpl(MemModelInfoMapper memModelInfoMapper) {
        this.memModelInfoMapper = memModelInfoMapper;
        super.setBaseMapper(memModelInfoMapper);
    }
}
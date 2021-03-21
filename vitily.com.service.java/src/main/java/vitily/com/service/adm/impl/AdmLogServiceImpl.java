package vitily.com.service.adm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.adm.TbAdmLog;
import vitily.com.mapper.adm.AdmLogMapper;
import vitily.com.service.adm.AdmLogService;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.ts_entity.adm.TsAdmLog;
import vitily.com.tv_entity.adm.TvAdmLog;

@Component
public class AdmLogServiceImpl extends BasicServiceImpl<TbAdmLog,TsAdmLog,TvAdmLog> implements AdmLogService {

	final
	AdmLogMapper admLogMapper;

	@Autowired()
	public AdmLogServiceImpl(AdmLogMapper admLogMapper) {
		this.admLogMapper = admLogMapper;
		super.setBaseMapper(admLogMapper);
	}
	/** 
     * 批量插入
     * @param list 1
     */
    public void bitInsert(List<TbAdmLog> list){
		admLogMapper.bitInsert(list);
    }
}
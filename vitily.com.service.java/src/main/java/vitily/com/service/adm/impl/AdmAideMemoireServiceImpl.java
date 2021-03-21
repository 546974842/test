package vitily.com.service.adm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.mapper.adm.AdmAideMemoireMapper;
import vitily.com.service.adm.AdmAideMemoireService;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.tb_entity.adm.TbAdmAideMemoire;
import vitily.com.ts_entity.adm.TsAdmAideMemoire;
import vitily.com.tv_entity.adm.TvAdmAideMemoire;

@Component
public class AdmAideMemoireServiceImpl extends BasicServiceImpl<TbAdmAideMemoire,TsAdmAideMemoire,TvAdmAideMemoire> implements AdmAideMemoireService {

	final
	AdmAideMemoireMapper admAideMemoireMapper;

	@Autowired()
	public AdmAideMemoireServiceImpl(AdmAideMemoireMapper admAideMemoireMapper) {
		this.admAideMemoireMapper = admAideMemoireMapper;
		super.setBaseMapper(admAideMemoireMapper);
	}
}

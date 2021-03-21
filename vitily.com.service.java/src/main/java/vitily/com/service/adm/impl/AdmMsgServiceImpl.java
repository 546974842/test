package vitily.com.service.adm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.mapper.adm.AdmMsgMapper;
import vitily.com.service.adm.AdmMsgService;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.tb_entity.adm.TbAdmMsg;
import vitily.com.ts_entity.adm.TsAdmMsg;
import vitily.com.tv_entity.adm.TvAdmMsg;

@Component
public class AdmMsgServiceImpl extends BasicServiceImpl<TbAdmMsg,TsAdmMsg,TvAdmMsg> implements AdmMsgService {

	final AdmMsgMapper admMsgMapper;

	@Autowired()
	public AdmMsgServiceImpl(AdmMsgMapper admMsgMapper) {
		this.admMsgMapper = admMsgMapper;
		super.setBaseMapper(admMsgMapper);
	}

	@Override
	public void insertByQueryMember(TsAdmMsg bean){
		admMsgMapper.insertByQueryMember(bean);
	}
}

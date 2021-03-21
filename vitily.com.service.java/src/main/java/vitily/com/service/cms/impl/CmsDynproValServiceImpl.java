package vitily.com.service.cms.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.cms.TbCmsDynproVal;
import vitily.com.mapper.cms.CmsDynproValMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.cms.CmsDynproValService;
import vitily.com.ts_entity.cms.TsCmsDynproVal;
import vitily.com.tv_entity.cms.TvCmsDynproVal;

@Component
public class CmsDynproValServiceImpl extends BasicServiceImpl<TbCmsDynproVal,TsCmsDynproVal,TvCmsDynproVal> implements CmsDynproValService {

	final
	CmsDynproValMapper cmsDynproValMapper;

	@Autowired()
	public CmsDynproValServiceImpl(CmsDynproValMapper cmsDynproValMapper) {
		this.cmsDynproValMapper = cmsDynproValMapper;
		super.setBaseMapper(cmsDynproValMapper);
	}
}

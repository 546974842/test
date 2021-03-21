package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.consts.DelTagDesc;
import vitily.com.tb_entity.mem.TbMemBankcard;
import vitily.com.mapper.mem.MemBankcardMapper;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.mem.MemBankcardService;
import vitily.com.ts_entity.mem.TsMemBankcard;
import vitily.com.tv_entity.mem.TvMemBankcard;
import vitily.com.util.CommonUtil;

import java.util.Date;

@Component
public class MemBankcardServiceImpl extends BasicServiceImpl<TbMemBankcard,TsMemBankcard,TvMemBankcard> implements MemBankcardService {

	final
	MemBankcardMapper memBankcardMapper;

	@Autowired()
	public MemBankcardServiceImpl(MemBankcardMapper memBankcardMapper) {
		this.memBankcardMapper = memBankcardMapper;
		super.setBaseMapper(memBankcardMapper);
	}
	@Override
	public int insert(TsMemBankcard bean) throws Exception{
		bean.getEntity().setDeltag(DelTagDesc.正常.getValue());
		if(memBankcardMapper.isExists(bean)){
			throw new DuplicateDataException("卡号已被占用");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return memBankcardMapper.insertSelective(bean.getEntity());
	}
	@Override
	public int update(TsMemBankcard bean)throws Exception{
		bean.getEntity().setDeltag(DelTagDesc.正常.getValue());
		if(memBankcardMapper.isExists(bean)){
			throw new DuplicateDataException("卡号已被占用");
		}
		bean.getEntity().setUpdateDate(new Date());
		return memBankcardMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
}
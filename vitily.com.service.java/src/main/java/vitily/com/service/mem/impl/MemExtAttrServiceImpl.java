package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.mem.TbMemExtAttr;
import vitily.com.mapper.mem.MemExtAttrMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.mem.MemExtAttrService;
import vitily.com.ts_entity.mem.TsMemExtAttr;
import vitily.com.tv_entity.mem.TvMemExtAttr;
import vitily.com.util.CommonUtil;

@Component
public class MemExtAttrServiceImpl extends BasicServiceImpl<TbMemExtAttr,TsMemExtAttr,TvMemExtAttr> implements MemExtAttrService {

	final
    MemExtAttrMapper memExtAttrMapper;

	@Autowired()
	public MemExtAttrServiceImpl(MemExtAttrMapper memExtAttrMapper) {
		this.memExtAttrMapper = memExtAttrMapper;
		super.setBaseMapper(memExtAttrMapper);
	}

	@Override
	public int insert(TsMemExtAttr bean) throws Exception{
		if(memExtAttrMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同的会员属性");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return memExtAttrMapper.insertSelective(bean.getEntity());
	}
}
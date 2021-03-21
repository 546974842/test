package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbLabel;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.ts_entity.comm.TsLabel;
import vitily.com.tv_entity.comm.TvLabel;
import vitily.com.mapper.comm.LabelMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.LabelService;
import vitily.com.util.CommonUtil;

@Component
public class LabelServiceImpl extends BasicServiceImpl<TbLabel,TsLabel,TvLabel> implements LabelService {

	final
    LabelMapper labelMapper;

	@Autowired()
	public LabelServiceImpl(LabelMapper labelMapper) {
		this.labelMapper = labelMapper;
		super.setBaseMapper(labelMapper);
	}
	@Override
	public int insert(TsLabel bean) throws Exception{
		if(labelMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同url的标签！");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return labelMapper.insertSelective(bean.getEntity());
	}
	@Override
	public int update(TsLabel bean) throws Exception{
		if(labelMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同url的标签！");
		}
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		return labelMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
}

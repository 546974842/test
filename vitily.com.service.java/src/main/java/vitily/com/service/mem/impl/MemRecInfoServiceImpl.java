package vitily.com.service.mem.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.consts.DefaultDesc;
import vitily.com.consts.DelTagDesc;
import vitily.com.tb_entity.mem.TbMemRecInfo;
import vitily.com.mapper.mem.MemRecInfoMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.mem.MemRecInfoService;
import vitily.com.ts_entity.mem.TsMemRecInfo;
import vitily.com.tv_entity.mem.TvMemRecInfo;
import vitily.com.util.CommonUtil;

import java.util.Date;

@Component
public class MemRecInfoServiceImpl extends BasicServiceImpl<TbMemRecInfo,TsMemRecInfo,TvMemRecInfo> implements MemRecInfoService {

	final
	MemRecInfoMapper memRecInfoMapper;

	@Autowired()
	public MemRecInfoServiceImpl(MemRecInfoMapper memRecInfoMapper) {
		this.memRecInfoMapper = memRecInfoMapper;
		super.setBaseMapper(memRecInfoMapper);
	}
	@Override
	public int insert(TsMemRecInfo bean)throws Exception{
		Date now=new Date();
		//如果是默认的
		if(CommonUtil.isEqual(bean.getEntity().getState(), DefaultDesc.是.getValue())){
			TsMemRecInfo upbean = new TsMemRecInfo();
			upbean.getEntity().setMemberId(bean.getEntity().getMemberId());
			upbean.getEntity().setState(DefaultDesc.否.getValue());
			upbean.getEntity().setUpdateDate(now);
			memRecInfoMapper.updateByTs(upbean);
		}
		bean.getEntity().setCreateDate(now);
		bean.getEntity().setDeltag(DelTagDesc.正常.getValue());
		return memRecInfoMapper.insertSelective(bean.getEntity());
	}
	public int update(TsMemRecInfo bean)throws Exception{
		Date now=new Date();
		//如果是默认的
		if(CommonUtil.isEqual(bean.getEntity().getState(), DefaultDesc.是.getValue())){
			TsMemRecInfo upbean = new TsMemRecInfo();
			upbean.getEntity().setMemberId(bean.getEntity().getMemberId());
			upbean.getEntity().setState(DefaultDesc.否.getValue());
			upbean.getEntity().setUpdateDate(now);
			memRecInfoMapper.updateByTs(upbean);
		}
		bean.getEntity().setUpdateDate(now);
		return memRecInfoMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
}
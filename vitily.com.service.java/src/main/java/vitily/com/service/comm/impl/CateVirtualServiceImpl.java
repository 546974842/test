package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbCateVirtual;
import vitily.com.mapper.comm.CateVirtualMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.comm.CateVirtualService;
import vitily.com.service_adapter.CateVirtualAdapter;
import vitily.com.ts_entity.comm.TsCateVirtual;
import vitily.com.tv_entity.comm.TvCateVirtual;
import vitily.com.util.CommonUtil;

@Component
public class CateVirtualServiceImpl extends BasicServiceImpl<TbCateVirtual,TsCateVirtual,TvCateVirtual> implements CateVirtualService {

	final CateVirtualMapper cateVirtualMapper;
	final CateVirtualAdapter cateVirtualAdapter;

	@Autowired()
	public CateVirtualServiceImpl(CateVirtualMapper cateVirtualMapper,CateVirtualAdapter cateVirtualAdapter) {
		this.cateVirtualMapper = cateVirtualMapper;
		this.cateVirtualAdapter = cateVirtualAdapter;
		super.setBaseMapper(cateVirtualMapper);
	}
	/**
	 * 判断siblings是否有同一个名称 也就是同一父级之下同一类型有唯一的名字
	 */
	@Override
	public int insert(TsCateVirtual bean) throws Exception{
		if(CommonUtil.isNull(bean.getEntity().getParentId())){
			bean.getEntity().setParentId(0);
		}
		if(cateVirtualMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同分类！");
		}
		//构建sql
		cateVirtualAdapter.setCateVirtualSql(bean.getEntity());
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return cateVirtualMapper.insertSelective(bean.getEntity());
	}
	/**
	 * 修改：检查是否存在 ：比较复杂 ，判断父级是否已改变等
	 * @param entity 1
	 * @throws Exception 2
	 */
	@Override
	public int update(TsCateVirtual bean) throws Exception{
		if(CommonUtil.isNull(bean.getEntity().getParentId())){
			bean.getEntity().setParentId(0);
		}
		if(cateVirtualMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同分类！");
		}
		//构建sql
		cateVirtualAdapter.setCateVirtualSql(bean.getEntity());
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		return cateVirtualMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
}
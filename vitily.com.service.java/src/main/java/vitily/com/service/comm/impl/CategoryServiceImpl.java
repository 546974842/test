package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbCategory;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.ts_entity.comm.TsCategory;
import vitily.com.tv_entity.comm.TvCategory;
import vitily.com.mapper.cms.CmsNewsMapper;
import vitily.com.mapper.comm.CategoryMapper;
import vitily.com.mapper.pro.ProBaseMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.comm.CategoryService;
import vitily.com.util.CommonUtil;

@Component
public class CategoryServiceImpl extends BasicServiceImpl<TbCategory,TsCategory,TvCategory> implements CategoryService {


	final
	CategoryMapper categoryMapper;
	final
    CmsNewsMapper cmsNewsMapper;
	final
	ProBaseMapper productMapper;

	@Autowired
	public CategoryServiceImpl(CategoryMapper categoryMapper,
							   CmsNewsMapper cmsNewsMapper,
							   ProBaseMapper productMapper) {
		this.categoryMapper = categoryMapper;
		this.cmsNewsMapper = cmsNewsMapper;
		this.productMapper = productMapper;
		super.setBaseMapper(categoryMapper);
	}
	
	@Override
	public int insert(TsCategory bean) throws Exception{
		if(CommonUtil.isNull(bean.getEntity().getParentId())){
			bean.getEntity().setParentId(0);
		}
		if(categoryMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同分类！");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return categoryMapper.insertSelective(bean.getEntity());
	}
	/**
	 * 通过路径进行更新：一般设置分类转移到别的分类下面：子分类一并转移过去
	 * @param entity 1
	 * @param oldParentRoot 2
	 * @param oldState 3
	 * @throws Exception 4
	 */
	@Override
	public int update(TsCategory bean) throws Exception{
		if(CommonUtil.isNull(bean.getEntity().getParentId())){
			bean.getEntity().setParentId(0);
		}
		if(categoryMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同分类！");
		}
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		return categoryMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
}
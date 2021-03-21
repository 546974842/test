package vitily.test.service.base.impl;

import vitily.base.tb_entity.BaseEntity;
import vitily.base.ts_entity.BaseSearch;
import vitily.base.ts_entity.PageInfo;
import vitily.base.tv_entity.TvPageList;
import vitily.com.consts.Const;
import vitily.com.consts.DelTagDesc;
import vitily.com.consts.ResultStatus;
import vitily.com.mapper.BaseMapper;
import vitily.com.other_entity.CustomerException;
import vitily.com.util.CommonUtil;
import vitily.test.service.base.BasicService;

import java.util.Date;
import java.util.List;

public class BasicServiceImpl<T extends BaseEntity,S extends BaseSearch<T>,V extends T> implements BasicService<T,S,V> {
	
	BaseMapper<T,S,V> baseMapper;
	
	public BasicServiceImpl(){}
    public BasicServiceImpl(BaseMapper<T,S,V> _bBaseMapper){
    	this.baseMapper=_bBaseMapper;
    }
    protected BaseMapper<T, S, V> getBaseMapper() {
		return baseMapper;
	}
	protected void setBaseMapper(BaseMapper<T, S, V> baseMapper) {
		this.baseMapper = baseMapper;
	}

	public TvPageList getPagingList(S bean)throws Exception{
    	if(CommonUtil.isNull(bean)){
    		throw new CustomerException("查询实体为null", ResultStatus.参数不全);
		}
		PageInfo pageInfo = bean.getPageInfo();
		if(CommonUtil.isNull(pageInfo)){
			pageInfo = new PageInfo();
		}
		bean.setPageInfo(pageInfo);
		pageInfo.setRecordCount(baseMapper.getCountPaging(bean));
		TvPageList pageList = new TvPageList();
		pageList.setPageInfo(pageInfo);
		pageList.setList(baseMapper.getListByBean(bean));
		return pageList;
	}
	public Integer getCountPaging(S bean)throws Exception{
		return baseMapper.getCountPaging(bean);
	}
	public List<?> getListByBean(S bean)throws Exception{
		if(!CommonUtil.isNull(bean.getPageInfo())){
			bean.getPageInfo().setPageSize(Const.COMMON_MAX_PAGESIZE);
		}
		return baseMapper.getListByBean(bean); 
	}
	public T getMaxBean(S bean){
		return baseMapper.getMaxBean(bean);
	}
	public T selectByPrimaryKey(int id) throws Exception{
		T t = baseMapper.selectByPrimaryKey(id);
		CommonUtil.checkIsNullEntity(t);
		return t;
	}
	public int insertSelective(T bean)throws Exception{
		Date now=new Date();
		bean.setCreateDate(now);
		bean.setUpdateDate(now);
		bean.setDeltag(DelTagDesc.正常.getValue());
		return baseMapper.insertSelective(bean);
	}
	public int updateByPrimaryKeySelective(T bean)throws Exception{
		bean.setUpdateDate(new Date());
		return baseMapper.updateByPrimaryKeySelective(bean);
	}
	public int insert(S bean)throws Exception{
		Date now=new Date();
		bean.getEntity().setCreateDate(now);
		//bean.getEntity().setUpdateDate(now);
		bean.getEntity().setDeltag(DelTagDesc.正常.getValue());
		return baseMapper.insertSelective(bean.getEntity());
	}
	public int update(S bean)throws Exception{
		bean.getEntity().setUpdateDate(new Date());
		return baseMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
	public V selectByPrimaryKeyForTv(int id)throws Exception{
		V v = baseMapper.selectByPrimaryKeyForTv(id);
		CommonUtil.checkIsNullEntity(v);
		return v;
	}
	
	public void sort(T bean,List<Integer> ids,List<Double> sorts){
		Date now = new Date();
		for(int i=0;i<ids.size();++i){
			bean.setId(ids.get(i));
			bean.setSort(sorts.get(i));
			bean.setState(null);
			bean.setDeltag(null);
			bean.setUpdateDate(now);
			baseMapper.updateByPrimaryKeySelective(bean);
		}
	}
	public void updateDeltag(T bean,List<Integer> ids,int delTag)throws Exception{
		Date now = new Date();
		for (Integer id : ids) {
			bean.setId(id);
			bean.setDeltag(delTag);
			bean.setState(null);
			bean.setUpdateDate(now);
			baseMapper.updateByPrimaryKeySelective(bean);
		}
	}
}

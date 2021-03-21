package vitily.com.service.base.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import vitily.com.consts.Const;
import vitily.com.consts.DelTagDesc;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.consts.ResultStatus;
import vitily.com.other_entity.CustomerException;
import vitily.com.mapper.BaseMapper;
import vitily.base.ts_entity.BaseSearch;
import vitily.base.ts_entity.PageInfo;
import vitily.base.tv_entity.TvPageList;
import vitily.com.service.base.BasicService;
import vitily.com.tv_entity.finance.TvAccountFlow;
import vitily.com.util.CommonUtil;
import vitily.com.util.ExportExcelUtils;

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
		if(CommonUtil.isNotNull(bean.getPageInfo())){
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
	public T selectByPrimaryKeyOfNoCheck(int id)throws Exception{
		T t = baseMapper.selectByPrimaryKey(id);
		return t;
	}
	public T selectSingleByBean(S bean)throws Exception{
		T t = baseMapper.selectSingleByBean(bean);
		return t;
	}
	public int insert(S bean)throws Exception{
		Date now=new Date();
		bean.getEntity().setCreateDate(now);
		bean.getEntity().setDeltag(DelTagDesc.正常.getValue());
		return baseMapper.insertSelective(bean.getEntity());
	}
	public int update(S bean)throws Exception{
		bean.getEntity().setUpdateDate(new Date());
		return baseMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
	public int updateByTs(S bean)throws Exception{
		bean.getEntity().setUpdateDate(new Date());
		return baseMapper.updateByTs(bean);
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
	
	/**
	 * 导出Excel
	 */
	@Override
	public void export(HttpServletRequest request,
			HttpServletResponse response, String excelName, S bean,
			LinkedHashMap<String, String> fieldMap) throws Exception {

		if(CommonUtil.isNotNull(bean.getPageInfo())){
			bean.getPageInfo().setPageSize(Const.COMMON_MAX_PAGESIZE);
		}
		
		List<?> list = baseMapper.getListByBean(bean); 
		JSON.toJSONString(list);
        //导出相关信息
        new ExportExcelUtils().export(excelName, list, fieldMap, response);
	}
	
	
}

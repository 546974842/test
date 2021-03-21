package vitily.com.service.adm.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vitily.com.consts.DelTagDesc;
import vitily.com.consts.StateDesc;
import vitily.com.tb_entity.adm.TbAdmColumn;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service_adapter.AdmColumnAdapter;
import vitily.com.mapper.adm.AdmColumnMapper;
import vitily.com.service.adm.AdmColumnService;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.ts_entity.adm.TsAdmColumn;
import vitily.com.tv_entity.adm.TvAdmColumn;
import vitily.com.util.CommonUtil;
import vitily.com.util.StringUtil;
import vitily.com.util.log.LogAdapter;

@Component
public class AdmColumnServiceImpl extends BasicServiceImpl<TbAdmColumn,TsAdmColumn,TvAdmColumn> implements AdmColumnService {

	static LogAdapter logger = LogAdapter.getLogAdapter(AdmColumnServiceImpl.class);

	final AdmColumnMapper admColumnMapper;
	final AdmColumnAdapter admColumnAdapter;

	@Autowired()
	public AdmColumnServiceImpl(AdmColumnMapper admColumnMapper, AdmColumnAdapter admColumnAdapter) {
		this.admColumnMapper = admColumnMapper;
		this.admColumnAdapter = admColumnAdapter;
		super.setBaseMapper(admColumnMapper);
	}

	@Override
	public int insert(TsAdmColumn bean) throws Exception{
        if(CommonUtil.isNull(bean.getEntity().getParentId())){
			bean.getEntity().setParentId(0);
        }
		if(admColumnMapper.isExists(bean)){
            throw new DuplicateDataException("已存在相同名字的栏目！");
		}
		bean.getEntity().setState(StateDesc.正常.getValue());
		CommonUtil.formartInsertEnntity(bean.getEntity());
		int cal = admColumnMapper.insertSelective(bean.getEntity());
		//创建必定未删除
		if(cal > 0) {
			admColumnAdapter.getCacheColumns().add(new TvAdmColumn(bean.getEntity()));
			String actionPath = bean.getEntity().getRightUrls();
			Integer rightId = bean.getEntity().getId();
			if(!StringUtil.isEmpty(actionPath)){
				String[] rightUrls = actionPath.split(",");
				for(String s:rightUrls){
					if(!StringUtil.isEmpty(s) && CommonUtil.isEqual(StateDesc.正常.getValue(),bean.getEntity().getState())){
						admColumnAdapter.putAuth(s,rightId);
					}
				}
			}
		}
		return cal;
	}

	/**
	 * 修改：检查是否存在
	 * @param entity 1
	 * @throws Exception 2
	 */
	@Override
	public int update(TsAdmColumn bean) throws Exception{
		if(CommonUtil.isNull(bean.getEntity().getParentId())){
			bean.getEntity().setParentId(0);
		}
		if(admColumnMapper.isExists(bean)){
			throw new DuplicateDataException("已经存在相同的栏目！");
		}
		TbAdmColumn entity = bean.getEntity();
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		int res = admColumnMapper.updateByPrimaryKeySelective(entity);
		
		//修改重新加载
		admColumnAdapter.clearCacheColumns();
		admColumnAdapter.getCacheColumns();
		if(res > 0){
			String actionPath = bean.getEntity().getRightUrls();
			Integer rightId = bean.getEntity().getId();
			if(!StringUtil.isEmpty(actionPath)){
				String[] rightUrls = actionPath.split(",");
				for(String s:rightUrls){
					if(!StringUtil.isEmpty(s)){
						if(CommonUtil.isEqual(StateDesc.正常.getValue(),bean.getEntity().getState())) {
							admColumnAdapter.putAuth(s, rightId);
						}else{
							admColumnAdapter.removeAuth(s);
						}
					}
				}
			}
		}
		return res;
	}
	/**
	 * 重写排序
	 */
	@Override
	public void sort(TbAdmColumn bean, List<Integer> ids, List<Double> sorts){
		Date now = new Date();
		for(int i=0;i<ids.size();++i){
			bean.setId(ids.get(i));
			bean.setSort(sorts.get(i));
			bean.setState(null);
			bean.setDeltag(null);
			bean.setUpdateDate(now);
			admColumnMapper.updateByPrimaryKeySelective(bean);
			//更新缓存
			TvAdmColumn entity = admColumnAdapter.geTvColumnById(ids.get(i));
			if(!CommonUtil.isNull(entity)) {
				entity.setSort(bean.getSort());
			}
		}
	} 
	/**
	 * 删除或者恢复 : 覆盖
	 * @param bean 1
	 * @param ids 2
	 * @param delTag 3
	 * @throws Exception 4
	 */
	@Override
	public void updateDeltag(TbAdmColumn bean, List<Integer> ids, int delTag)throws Exception{
		List<TvAdmColumn> list = admColumnAdapter.getCacheColumns();
		Date now = new Date();
		for (Integer id : ids) {
			bean.setId(id);
			bean.setDeltag(delTag);
			bean.setState(null);
			bean.setUpdateDate(now);
			TbAdmColumn entity = admColumnMapper.selectByPrimaryKey(id);
			entity.setUpdateDate(now);
			entity.setDeltag(delTag);
			//从删除到正常
			if (CommonUtil.isEqual(delTag, DelTagDesc.正常.getValue())) {
				entity.setDeltag(DelTagDesc.正常.getValue());
				list.add(new TvAdmColumn(entity));
				if(!StringUtil.isEmpty(entity.getRightUrls())){
					String[] rightUrls = entity.getRightUrls().split(",");
					for(String s:rightUrls){
						if(!StringUtil.isEmpty(s)){
							admColumnAdapter.putAuth(s,entity.getId());
						}
					}
				}
			}else{
				if(!StringUtil.isEmpty(entity.getRightUrls())){
					String[] rightUrls = entity.getRightUrls().split(",");
					for(String s:rightUrls){
						if(!StringUtil.isEmpty(s)){
							admColumnAdapter.removeAuth(s);
						}
					}
				}
			}
			admColumnMapper.updateByPrimaryKeySelective(entity);
		}
		if(!CommonUtil.isEqual(delTag, DelTagDesc.正常.getValue())){
			Iterator<TvAdmColumn> iter = list.iterator();
			while(iter.hasNext()){
				TvAdmColumn e = iter.next();
				if(ids.contains(e.getId())){
					iter.remove();
				}
			}
		}
	}

	public List<TvAdmColumn> getListByBean(TsAdmColumn bean){
		return (List<TvAdmColumn>)admColumnMapper.getListByBean(bean);
	}
	
}

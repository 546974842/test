package vitily.com.service.cms.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.consts.ResultStatus;
import vitily.com.tb_entity.cms.TbCmsDynproVal;
import vitily.com.tb_entity.cms.TbCmsNews;
import vitily.com.mapper.cms.CmsDynproValMapper;
import vitily.com.mapper.cms.CmsNewsMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.other_entity.CustomerException;
import vitily.com.service.cms.CmsNewsService;
import vitily.com.service_adapter.CmsNewsAdapter;
import vitily.com.ts_entity.cms.TsCmsDynproVal;
import vitily.com.ts_entity.cms.TsCmsNews;
import vitily.com.tv_entity.cms.TvCmsNews;
import vitily.com.util.CommonUtil;
import vitily.com.util.GUIDGenerator;

@Component
public class CmsNewsServiceImpl extends BasicServiceImpl<TbCmsNews,TsCmsNews,TvCmsNews> implements CmsNewsService {

    final CmsNewsMapper cmsNewsMapper;
    final CmsDynproValMapper cmsDynproValMapper;
    final CmsNewsAdapter cmsNewsAdapter;

    @Autowired
    public CmsNewsServiceImpl(
            CmsDynproValMapper cmsDynproValMapper,
            CmsNewsMapper cmsNewsMapper,
            CmsNewsAdapter cmsNewsAdapter
            ) {
        this.cmsDynproValMapper = cmsDynproValMapper;
        this.cmsNewsMapper = cmsNewsMapper;
        this.cmsNewsAdapter = cmsNewsAdapter;
        super.setBaseMapper(cmsNewsMapper);
    }

	/**
     * 增加：增加额外属性
     * @param entity 1
     * @param gens 2
     * @return 3
     * @throws Exception 4
     */
    @Override
    public int insert(TsCmsNews queryEntity) throws Exception{
        CommonUtil.formartInsertEnntity(queryEntity.getEntity());
    	int cal = cmsNewsMapper.insertSelective(queryEntity.getEntity());
        if(cal < 1){
            throw new CustomerException("添加异常！", ResultStatus.操作异常);
        }
        String guid=GUIDGenerator.getGUID();
        cmsNewsAdapter.bitInsertCmsDynproVals(queryEntity.getEntity().getTypeId(),queryEntity.getEntity().getId(),guid,queryEntity.getDynList());
        return cal;
    }
	/**
     * 修改：
     * @param entity 1
     * @throws Exception 2
     */
	@Override
    public int update(TsCmsNews queryEntity) throws Exception{
        CommonUtil.formartUpdateEnntity(queryEntity.getEntity());
        int res = cmsNewsMapper.updateByPrimaryKeySelective(queryEntity.getEntity());
        if(queryEntity.isChangeDyn()){//先删除后新增
                TsCmsDynproVal delDynProperGen=new TsCmsDynproVal();
                delDynProperGen.getEntity().setNewsId(queryEntity.getEntity().getId());
                cmsDynproValMapper.deleteByBean(delDynProperGen);
            if(!CommonUtil.isNull(queryEntity.getDynList())) {
                String guid = GUIDGenerator.getGUID();
                cmsNewsAdapter.bitInsertCmsDynproVals(queryEntity.getEntity().getTypeId(),queryEntity.getEntity().getId(), guid, queryEntity.getDynList());
            }
        }else{//直接更新
            if(!CommonUtil.isNull(queryEntity.getDynList())) {
                for (TbCmsDynproVal item : queryEntity.getDynList()) {
                    item.setUpdateDate(new Date());
                    cmsDynproValMapper.updateByPrimaryKeySelective(item);
                }
            }
        }
        return res;
    }
	/**
     * 批量更新
     */
    @Override
    public void updateByBean(TsCmsNews bean)throws Exception{
            bean.getEntity().setUpdateDate(new Date());
            cmsNewsMapper.updateByBean(bean);
    }
}

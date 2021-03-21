package vitily.com.service.pro.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.consts.DelTagDesc;
import vitily.com.consts.ResultStatus;
import vitily.com.consts.StateDesc;
import vitily.com.tb_entity.pro.TbProDynproVal;
import vitily.com.tb_entity.pro.TbProMemPri;
import vitily.com.tb_entity.pro.TbProBase;
import vitily.com.mapper.pro.ProDynproValMapper;
import vitily.com.mapper.pro.ProMemPriMapper;
import vitily.com.mapper.pro.ProBaseMapper;
import vitily.com.mapper.pro.ProSpValMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.pro.ProBaseService;
import vitily.com.service_adapter.ProAdapter;
import vitily.com.ts_entity.pro.TsProDynproVal;
import vitily.com.ts_entity.pro.TsProMemPri;
import vitily.com.ts_entity.pro.TsProBase;
import vitily.com.ts_entity.pro.TsProSpVal;
import vitily.com.tv_entity.pro.TvProMemPri;
import vitily.com.tv_entity.pro.TvProBase;
import vitily.com.tv_entity.pro.TvProSpVal;
import vitily.com.util.CommonUtil;
import vitily.com.util.GUIDGenerator;

@Component
public class ProBaseServiceImpl extends BasicServiceImpl<TbProBase,TsProBase,TvProBase> implements ProBaseService {

	final
	ProBaseMapper proBaseMapper;
	final
	ProDynproValMapper proDynproValMapper;
	final
	ProMemPriMapper proMemPriMapper;
	final
	ProSpValMapper proSpValMapper;
	final ProAdapter proAdapter;

	@Autowired
	public ProBaseServiceImpl(ProBaseMapper proBaseMapper,
							  ProDynproValMapper proDynproValMapper,
							  ProMemPriMapper proMemPriMapper,
							  ProSpValMapper proSpValMapper,
							  ProAdapter proAdapter
	) {
		this.proBaseMapper = proBaseMapper;
		this.proDynproValMapper = proDynproValMapper;
		this.proMemPriMapper = proMemPriMapper;
		this.proSpValMapper = proSpValMapper;
		this.proAdapter = proAdapter;
		super.setBaseMapper(proBaseMapper);
	}
	/**
	 * 增加：增加额外属性
	 * @param entity 1
	 * @param gens 2
	 * @return 3
	 * @throws Exception 4
	 */
	@Override
	public int insert(TsProBase queryEntity) throws Exception{
		TbProBase entity = queryEntity.getEntity();
		entity.setHits(0);
		CommonUtil.formartInsertEnntity(entity);
		int cal = proBaseMapper.insertSelective(entity);
		if(cal < 1){
			throw new CustomerException("添加异常！", ResultStatus.操作异常);
		}
		String guid=GUIDGenerator.getGUID();
		Date now = new Date();
		//添加额外属性
		proAdapter.bitInsertProDynproVals(entity.getTypeId(),entity.getId(),now,guid,queryEntity.getDynList());
		//添加会员价格
		if(CommonUtil.isNotNull(queryEntity.getPmpList())){
			proAdapter.bitInsertProMemPris(entity.getId(),guid,now,null,null,queryEntity.getPmpList());
		}
		if(CommonUtil.isNotNull(queryEntity.getPspList())){
			for(TvProSpVal item:queryEntity.getPspList()){
				item.setCreateDate(new Date());
				item.setGuid(guid);
				item.setState(entity.getState());
				item.setTypeId(entity.getTypeId());
				item.setCateId(entity.getCateId());
				item.setNewsId(entity.getNewsId());
				item.setProductId(entity.getId());
				item.setInPrice(entity.getInPrice());
				item.setPrimePrice(entity.getPrimePrice());
				item.setHits(entity.getHits());
				item.setPayWayIds(entity.getPayWayIds());
				item.setDeliveryIds(entity.getDeliveryIds());
				item.setMaxCanbuy(entity.getMaxCanbuy());
				item.setLabelIds(entity.getLabelIds());
				//item.setDescription(tb_entity.getDescription());
				item.setPicList(entity.getPicList());
				item.setDeltag(DelTagDesc.正常.getValue());
				proSpValMapper.insertSelective(item);

				//插入规格的会员价格
				if(CommonUtil.isNotNull(item.getPmps())){
					proAdapter.bitInsertProMemPris(entity.getId(),guid,now,item.getId(),item.getSpecParIds(),item.getPmps());
				}

			}
		}
		return cal;
	}
	@Override
	public int update(TsProBase queryEntity) throws Exception{
		if(proBaseMapper.isExists(queryEntity)){
			throw new DuplicateDataException("已经存在相同的产品编码！");
		}
		TbProBase entity = queryEntity.getEntity();
		CommonUtil.formartUpdateEnntity(entity);
		int res = proBaseMapper.updateByPrimaryKeySelective(entity);
		String guid = GUIDGenerator.getGUID();
		if(queryEntity.isChangeDyn()){//先删除后新增
			TsProDynproVal delDynProperGen=new TsProDynproVal();
			delDynProperGen.getEntity().setProductId(entity.getId());
			proDynproValMapper.deleteByBean(delDynProperGen);

			if(CommonUtil.isNotNull(queryEntity.getDynList())) {
				proAdapter.bitInsertProDynproVals(entity.getTypeId(),entity.getId(),entity.getUpdateDate(),guid,queryEntity.getDynList());
			}
		}else{//直接更新
			if(CommonUtil.isNotNull(queryEntity.getDynList())) {
				for(TbProDynproVal item:queryEntity.getDynList()){
					item.setUpdateDate(entity.getUpdateDate());
					item.setGuid(guid);
					proDynproValMapper.updateByPrimaryKeySelective(item);
				}
			}
		}


		//更新会员价格
		if(CommonUtil.isNotNull(queryEntity.getPmpList())){
			for(TbProMemPri item:queryEntity.getPmpList()){
				item.setProductId(entity.getId());
				item.setGuid(guid);
				if(CommonUtil.isNotNull(item.getId()) && item.getId() > 0){
					item.setUpdateDate(entity.getUpdateDate());
					proMemPriMapper.updateByPrimaryKeySelective(item);
				}else{
					item.setCreateDate(new Date());
					item.setDeltag(DelTagDesc.正常.getValue());
					item.setState(StateDesc.正常.getValue());
					item.setSort(0.0D);
					proMemPriMapper.insertSelective(item);
				}
			}
		}
//		//规格
		if(CommonUtil.isNotNull(queryEntity.getPspList())){
			for(TvProSpVal item:queryEntity.getPspList()){
				item.setGuid(guid);
				//该状态和产品自己的状态一样？
				item.setState(entity.getState());

				item.setTypeId(entity.getTypeId());
				item.setCateId(entity.getCateId());
				item.setNewsId(entity.getNewsId());
				item.setInPrice(entity.getInPrice());
				item.setPrimePrice(entity.getPrimePrice());
				item.setHits(entity.getHits());
				item.setPayWayIds(entity.getPayWayIds());
				item.setDeliveryIds(entity.getDeliveryIds());
				item.setMaxCanbuy(entity.getMaxCanbuy());
				item.setLabelIds(entity.getLabelIds());
				//item.setDescription(tb_entity.getDescription());
				item.setPicList(entity.getPicList());
				if(item.getId() >0){
					item.setUpdateDate(new Date());
					proSpValMapper.updateByPrimaryKeySelective(item);
				}else{
					item.setProductId(entity.getId());
					item.setCreateDate(new Date());
					item.setDeltag(DelTagDesc.正常.getValue());
					item.setHits(0);
					proSpValMapper.insertSelective(item);
				}
				//规格会员价格
				if(CommonUtil.isNull(item.getPmps())){
					continue;
				}
				for(TbProMemPri it:item.getPmps()){
					it.setProductId(entity.getId());
					it.setGuid(guid);
					it.setState(entity.getState());
					if(CommonUtil.isNotNull(it.getId()) && it.getId() > 0){
						it.setUpdateDate(new Date());
						proMemPriMapper.updateByPrimaryKeySelective(it);
					}else{
						it.setCreateDate(new Date());
						it.setSpecParProId(item.getId());
						it.setSpecParIds(item.getSpecParIds());
						it.setDeltag(DelTagDesc.正常.getValue());
						proMemPriMapper.insertSelective(it);
					}
				}

			}
		}
		//删除的规格相关
		if(CommonUtil.isNumOrD(queryEntity.getDelSppIds())){
			TsProSpVal delSpecParPro=new TsProSpVal();
			delSpecParPro.getEntity().setDeltag(DelTagDesc.已删除.getValue());
			delSpecParPro.setIdStr(queryEntity.getDelSppIds());
			proSpValMapper.updateByBean(delSpecParPro);
			//删除会员规格
//			TsProMemPri delMemPri=new TsProMemPri();
//			delMemPri.getEntity().setDeltag(DelTagDesc.已删除.getValue());
//			delMemPri.getEntity().setUpdateDate(new Date());
//			delMemPri.setSpecParProIds(delSppIds);
//			proMemPriMapper.updateByBean(delMemPri);
		}

		return res;
	}
	/**
	 * 批量更新
	 */
	public void updateByBean(TsProBase bean)throws Exception{
		bean.getEntity().setUpdateDate(new Date());
		proBaseMapper.updateByBean(bean);
	}
}
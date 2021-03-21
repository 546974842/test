package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbDeliveryWay;
import vitily.com.mapper.comm.DeliveryWayMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.comm.DeliveryWayService;
import vitily.com.ts_entity.comm.TsDeliveryWay;
import vitily.com.tv_entity.comm.TvDeliveryWay;
import vitily.com.util.CommonUtil;

@Component
public class DeliveryWayServiceImpl extends BasicServiceImpl<TbDeliveryWay,TsDeliveryWay,TvDeliveryWay> implements DeliveryWayService {

	final
	DeliveryWayMapper deliveryWayMapper;

	@Autowired()
	public DeliveryWayServiceImpl(DeliveryWayMapper deliveryWayMapper) {
		this.deliveryWayMapper = deliveryWayMapper;
		super.setBaseMapper(deliveryWayMapper);
	}

	@Override
	public int insert(TsDeliveryWay bean) throws Exception{
		if(deliveryWayMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的配送方式！");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return deliveryWayMapper.insertSelective(bean.getEntity());
	}
	@Override
	public int update(TsDeliveryWay bean) throws Exception{
		if(deliveryWayMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的配送方式！");
		}
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		return deliveryWayMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
}
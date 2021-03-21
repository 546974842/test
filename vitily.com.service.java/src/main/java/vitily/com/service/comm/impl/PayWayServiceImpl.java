package vitily.com.service.comm.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.comm.TbPayWay;
import vitily.com.mapper.comm.PayWayMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.comm.PayWayService;
import vitily.com.ts_entity.comm.TsPayWay;
import vitily.com.tv_entity.comm.TvPayWay;
import vitily.com.util.CommonUtil;

@Component
public class PayWayServiceImpl extends BasicServiceImpl<TbPayWay,TsPayWay,TvPayWay> implements PayWayService {

	final
	PayWayMapper payWayMapper;

	@Autowired()
	public PayWayServiceImpl(PayWayMapper payWayMapper) {
		this.payWayMapper = payWayMapper;
		super.setBaseMapper(payWayMapper);
	}

	@Override
	public int insert(TsPayWay bean) throws Exception{
		if(payWayMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的支付方式！");
		}
		CommonUtil.formartInsertEnntity(bean.getEntity());
		return payWayMapper.insertSelective(bean.getEntity());
	}
	@Override
	public int update(TsPayWay bean) throws Exception{
		if(payWayMapper.isExists(bean)){
			throw new DuplicateDataException("已存在相同名字的支付方式！");
		}
		CommonUtil.formartUpdateEnntity(bean.getEntity());
		return payWayMapper.updateByPrimaryKeySelective(bean.getEntity());
	}
}
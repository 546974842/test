package vitily.com.service.order.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.order.TbOrderPayRecord;
import vitily.com.mapper.order.OrderPayRecordMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.order.OrderPayRecordService;
import vitily.com.ts_entity.order.TsOrderPayRecord;
import vitily.com.tv_entity.order.TvOrderPayRecord;

@Component
public class OrderPayRecordServiceImpl extends BasicServiceImpl<TbOrderPayRecord,TsOrderPayRecord,TvOrderPayRecord> implements OrderPayRecordService {

	final
	OrderPayRecordMapper orderPayRecordMapper;

	@Autowired()
	public OrderPayRecordServiceImpl(OrderPayRecordMapper orderPayRecordMapper) {
		this.orderPayRecordMapper = orderPayRecordMapper;
		super.setBaseMapper(orderPayRecordMapper);
	}
}

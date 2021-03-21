package vitily.com.service.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.mapper.order.OrderOperaRecordMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.order.OrderOperaRecordService;
import vitily.com.tb_entity.order.TbOrderOperaRecord;
import vitily.com.ts_entity.order.TsOrderOperaRecord;
import vitily.com.tv_entity.order.TvOrderOperaRecord;

@Component
public class OrderOperaRecordServiceImpl extends BasicServiceImpl<TbOrderOperaRecord,TsOrderOperaRecord,TvOrderOperaRecord> implements OrderOperaRecordService {

	final OrderOperaRecordMapper orderOperaRecordMapper;

	@Autowired()
	public OrderOperaRecordServiceImpl(OrderOperaRecordMapper orderOperaRecordMapper) {
		this.orderOperaRecordMapper = orderOperaRecordMapper;
		super.setBaseMapper(orderOperaRecordMapper);
	}
}

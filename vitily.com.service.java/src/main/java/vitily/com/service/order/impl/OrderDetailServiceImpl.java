package vitily.com.service.order.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import vitily.com.tb_entity.order.TbOrderDetail;
import vitily.com.mapper.order.OrderDetailMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.order.OrderDetailService;
import vitily.com.ts_entity.order.TsOrderDetail;
import vitily.com.tv_entity.order.TvOrderDetail;

@Component
public class OrderDetailServiceImpl extends BasicServiceImpl<TbOrderDetail,TsOrderDetail,TvOrderDetail> implements OrderDetailService {

	final
    OrderDetailMapper orderDetailMapper;

	@Autowired()
	public OrderDetailServiceImpl(OrderDetailMapper orderDetailMapper) {
		this.orderDetailMapper = orderDetailMapper;
		super.setBaseMapper(orderDetailMapper);
	}
}
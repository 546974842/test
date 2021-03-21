package vitily.com.service.order;

import vitily.com.api_entity.req_entity.mem.TqPlaceOrder;
import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.order.TbOrderForm;
import vitily.com.ts_entity.order.TsOrderForm;
import vitily.com.tv_entity.order.TvOrderForm;

public interface OrderFormService extends BasicService<TbOrderForm,TsOrderForm,TvOrderForm> {
	/**
	 * 插入订单
	 * @param entity 1
	 * @throws Exception 2
	 */
    boolean placeOrder(TqPlaceOrder entity)throws Exception;
}
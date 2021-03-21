package vitily.com.service.order;

import vitily.com.api_entity.req_entity.mem.TqPlaceOrder;
import vitily.com.api_entity.req_entity.mem.TqPlaceShowOrder;
import vitily.com.api_entity.req_entity.mem.TqSaveOrderExpress;
import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.order.TbOrderFormShow;
import vitily.com.ts_entity.order.TsOrderFormShow;
import vitily.com.tv_entity.order.TvOrderFormShow;

public interface OrderFormShowService extends BasicService<TbOrderFormShow,TsOrderFormShow,TvOrderFormShow> {
	/**
	 * 插入订单
	 * @param entity 1
	 * @throws Exception 2
	 */
    boolean placeOrder(TqPlaceShowOrder entity)throws Exception;
    void saveExpress(TqSaveOrderExpress bean)throws Exception;
}
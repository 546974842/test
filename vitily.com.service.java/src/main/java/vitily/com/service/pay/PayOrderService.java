package vitily.com.service.pay;


import vitily.com.api_entity.req_entity.mem.TqPlaceOrder;
import vitily.com.other_entity.CustomerException;
import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.finance.TbRecharge;
import vitily.com.tb_entity.pay.TbPayOrder;
import vitily.com.ts_entity.pay.TsPayOrder;
import vitily.com.tv_entity.pay.TvPayOrder;

import java.io.IOException;

public interface PayOrderService extends BasicService<TbPayOrder,TsPayOrder,TvPayOrder> {
	/**
	 * 增加：
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public long insert(TbPayOrder entity) throws Exception;
	/**
	 * 修改：
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void update(TbPayOrder entity) throws Exception;
	
	/**
	 * 
	 * 下单 韦海鹤 2017年05月19日17:03:06
	 * @throws Exception
	 */
	public TbPayOrder createOrder(TbRecharge recharge)throws CustomerException,Exception;
}
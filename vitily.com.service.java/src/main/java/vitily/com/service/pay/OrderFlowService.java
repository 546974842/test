package vitily.com.service.pay;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.pay.TbOrderFlow;
import vitily.com.ts_entity.pay.TsOrderFlow;
import vitily.com.tv_entity.pay.TvOrderFlow;

import java.util.List;

public interface OrderFlowService extends BasicService<TbOrderFlow,TsOrderFlow,TvOrderFlow> {
	/**
	 * 增加：
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public long insert(TbOrderFlow entity) throws Exception;
	/**
	 * 修改：
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void update(TbOrderFlow entity) throws Exception;
	/**
	 * 查询：通过订单id查询流水记录
	 * @param
	 * @return  List<TvOrderFlow>
	 * @throws Exception
	 */
	public List<TvOrderFlow> selectByOrderId(Integer orderId) throws Exception;
}
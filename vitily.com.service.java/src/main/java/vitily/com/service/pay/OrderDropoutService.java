package vitily.com.service.pay;


import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.pay.TbOrderDropout;
import vitily.com.ts_entity.pay.TsOrderDropout;
import vitily.com.tv_entity.pay.TvOrderDropout;

import java.util.List;

public interface OrderDropoutService extends BasicService<TbOrderDropout,TsOrderDropout,TvOrderDropout> {
	/**
	 * 增加：
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public long insert(TbOrderDropout entity) throws Exception;
	/**
	 * 修改：
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void update(TbOrderDropout entity) throws Exception;
	/**
	 * 修改：
	 * @param
	 * @return list
	 * @throws Exception
	 */
	public List<TvOrderDropout> selectByOrderId(Integer orderId) throws Exception;
}
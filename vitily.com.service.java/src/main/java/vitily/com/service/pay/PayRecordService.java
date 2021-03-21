package vitily.com.service.pay;

import vitily.com.service.base.BasicService;
import vitily.com.tb_entity.pay.TbPayRecord;
import vitily.com.ts_entity.pay.TsPayRecord;
import vitily.com.tv_entity.pay.TvPayRecord;

import java.util.List;

public interface PayRecordService extends BasicService<TbPayRecord,TsPayRecord,TvPayRecord> {
	/**
	 * 增加：
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public long insert(TbPayRecord entity) throws Exception;
	/**
	 * 修改：
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void update(TbPayRecord entity) throws Exception;
	/**
	 * 修改：
	 * @param
	 * @return
	 * @throws Exception
	 */
	public List<TvPayRecord> selectByOrderId(Integer orderId) throws Exception;
}
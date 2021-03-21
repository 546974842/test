package vitily.com.mapper.pay;

import org.apache.ibatis.annotations.Param;
import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.pay.TbPayOrder;
import vitily.com.ts_entity.pay.TsPayOrder;
import vitily.com.tv_entity.pay.TvPayOrder;

public interface PayOrderMapper extends BaseMapper<TbPayOrder,TsPayOrder,TvPayOrder> {
	TvPayOrder selectForUpdate(@Param("orderNo")String orderNo);
}

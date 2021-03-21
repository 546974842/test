package vitily.com.mapper.pay;

import org.apache.ibatis.annotations.Param;
import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.pay.TbOrderFlow;
import vitily.com.ts_entity.pay.TsOrderFlow;
import vitily.com.tv_entity.pay.TvOrderFlow;

import java.util.List;

public interface OrderFlowMapper extends BaseMapper<TbOrderFlow,TsOrderFlow,TvOrderFlow> {
	List<TvOrderFlow> selectByOrderId(@Param("orderId")Integer orderId);
}

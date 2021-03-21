package vitily.com.mapper.pay;

import org.apache.ibatis.annotations.Param;
import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.pay.TbOrderDropout;
import vitily.com.ts_entity.pay.TsOrderDropout;
import vitily.com.tv_entity.pay.TvOrderDropout;

import java.util.List;

public interface OrderDropoutMapper extends BaseMapper<TbOrderDropout,TsOrderDropout,TvOrderDropout> {
	List<TvOrderDropout> selectByOrderId(@Param("orderId") Integer orderId);
}

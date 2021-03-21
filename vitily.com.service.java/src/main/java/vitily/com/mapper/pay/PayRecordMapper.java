package vitily.com.mapper.pay;

import org.apache.ibatis.annotations.Param;
import vitily.com.mapper.BaseMapper;
import vitily.com.tb_entity.pay.TbPayRecord;
import vitily.com.ts_entity.pay.TsPayRecord;
import vitily.com.tv_entity.pay.TvPayRecord;

import java.util.List;

public interface PayRecordMapper extends BaseMapper<TbPayRecord,TsPayRecord,TvPayRecord> {
	List<TvPayRecord> selectByOrderId(@Param("orderId") Integer orderId);
}

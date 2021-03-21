package vitily.com.service_adapter;

import vitily.com.tv_entity.comm.TvType;

import java.util.List;
import java.util.Map;

public interface TypeAdapter {
    Map<String,List<TvType>> priTypeBySystType(List<TvType> list);
}

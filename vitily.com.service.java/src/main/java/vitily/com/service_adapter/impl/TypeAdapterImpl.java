package vitily.com.service_adapter.impl;

import org.springframework.stereotype.Component;
import vitily.com.service_adapter.TypeAdapter;
import vitily.com.tv_entity.comm.TvType;
import vitily.com.util.CommonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TypeAdapterImpl implements TypeAdapter {
    @Override
    public Map<String,List<TvType>> priTypeBySystType(List<TvType> list){
        Map<String,List<TvType>> map = new HashMap<>();
        for(TvType e:list){
            List<TvType> types = map.get(e.getSysTypeDesc());
            if(CommonUtil.isNull(types)){
                types = new ArrayList<>();
                map.put(e.getSysTypeDesc(),types);
            }
            types.add(e);
        }
        return map;
    }
}

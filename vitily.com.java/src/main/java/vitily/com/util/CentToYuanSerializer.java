package vitily.com.util;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;

public class CentToYuanSerializer implements ObjectSerializer{
    public static final CentToYuanSerializer instance = new CentToYuanSerializer();

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,int features) throws IOException {
        SerializeWriter out = serializer.out;
        if (object == null) {
            out.writeNull();
            return;
        }
        out.write(NumberUtil.getScale2MDownYuanByCent((long)object).toString());
        //out.writeDouble(NumberUtil.getScale2MDownYuanByCent((long)object).doubleValue(),false);
    }
//    public static void main(String[] args){
//        System.out.println("s:" + NumberUtil.getScale2MDownYuanByCent(236500L).toString());
//    }
}

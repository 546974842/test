package vitily.com.util;

import java.lang.reflect.Method;

import vitily.com.util.log.LogAdapter;

/**
 * 反射类
 * @author lether
 *
 */
public class LeReflection
{
	static LogAdapter logger = LogAdapter.getLogAdapter(LeReflection.class);
    public static Object getModelItemValue(Object t,String name){
    	Object object=null;
    	try{
    		name = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
    		Method m = t.getClass().getMethod("get"+name);
    		object=m.invoke(t);
    	}catch (Exception e) {
    		logger.info("error:"+e.getMessage());
		}
		if(object == null){
			object=new String("");
		}
    	return object;
    }
	public static void setModelItemValue(Object t,String name,Object value,Class<?> type){
		try{
			name = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
			Method m = t.getClass().getMethod("set"+name,type);
			m.invoke(t,value);
		}catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
}  
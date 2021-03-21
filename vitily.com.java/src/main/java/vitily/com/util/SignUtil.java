package vitily.com.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * @author lether
 *
 */
public class SignUtil {
	
	/**
	 * 加密以便验签
	 * @param paramStr getRequestParam 方法得出的字符串
	 * @param key
	 * @return
	 */
	public static String encry(String paramStr,String key){
		paramStr +="key=";
		paramStr +=key;
		return MD5.getMD5(paramStr);
	}
	/**
	 * 参数为map的加密方式
	 * @param map
	 * @param key
	 * @return
	 */
	public static String encry(Map<String,String> map,String mem_key){
		return encry(getParamByMap(map),mem_key);
	}
	/**
	 * 通过map拼凑成url参数
	 * @param map
	 * @return
	 */
	public static String getParamByMap(Map<String, String> map){
		List<String> keyList=new ArrayList<String>(map.keySet());
		Collections.sort(keyList);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<keyList.size();++i){
			String key=keyList.get(i);
			String value=map.get(key);
			if(StringUtil.isEmpty(value)){
				continue;
			}
			if(i !=0){
				sb.append("&");
			}
			sb.append(key).append("=").append(value);
		}
		return sb.toString();
		
	}
	/**
	 * 获取params：排序过后的params
	 * 排除sign
	 * @param request
	 * @return
	 */
	public static String getRequestParam(HttpServletRequest request){
		Enumeration<String> paramNames=request.getParameterNames();
		List<String> keyList=new ArrayList<String>();
		while (paramNames.hasMoreElements()) {
			String string = paramNames.nextElement();
			if(!StringUtil.isEmpty(string) && !string.equals("sign")){
				keyList.add(string);
			}
		}
		Collections.sort(keyList);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<keyList.size();++i){
			String key=keyList.get(i);
			String value=request.getParameter(key);
			if(StringUtil.isEmpty(value)){
				continue;
			}
			if(i !=0){
				sb.append("&");
			}
			sb.append(key).append("=").append(value);
		}
		return sb.toString();
	}
}

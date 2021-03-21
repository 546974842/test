package vitily.com.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SysContext {
	private static ThreadLocal<HttpServletRequest> requestLocal=new ThreadLocal<>();
    private static ThreadLocal<HttpServletResponse> responseLocal=new ThreadLocal<>();
    /**
     * 获得网站跟路径
     * @return 1
     */
    public static String getServletRoot(){
    	return "/";
    }
    public static void main (String[] args){
    	String value = "mxssExecutionSink('1',\"%27%5C\"><xsstag>()locxss\")#javascript:d";
    	value = value.replaceAll("[<>\"\']", "-");
        CommonUtil.SystemPrintln("valueafr:" + value);
        CommonUtil.SystemPrintln("i:" + "faasfEvleValasdf");
    }
    public static String cleanXSS(String str){
    	return str.replaceAll("[<>\"\']", "-");
    }
    public static boolean isValible(HttpServletRequest request){
        Map<String, String[]> params = request.getParameterMap();  
        String value;
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (String e : values) {
                value = e;
                if (
                        key.contains("\"") ||
                        key.contains("\'") ||
                        key.contains("<") ||
                        key.contains(">") ||
                        key.contains("(") ||
                        key.contains(")") ||
                        key.contains("\\") ||
                        key.contains("script") ||
                        key.contains("eval") ||
                        key.contains("SCRIPT") ||
                        key.contains("EVAL") ||
                        value.contains("\"") ||
                        value.contains("\'") ||
                        value.contains("<") ||
                        value.contains(">") ||
                        value.contains("(") ||
                        value.contains(")") ||
                        value.contains("\\") ||
                        value.contains("script") ||
                        value.contains("eval") ||
                        value.contains("SCRIPT") ||
                        value.contains("EVAL")
                        ) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * 获得请求参数串：当有非法字符时候：如"\"","'","javascript:","<",">",
     * @return 1
     */
    public static String getQueryString(){
    	HttpServletRequest request=getRequest();
        Map<String, String[]> params = request.getParameterMap();  
        StringBuilder queryString = new StringBuilder();
        for (String key : params.keySet()) {  
            String[] values = params.get(key);
            for (String e : values) {
                String value = e;
                value = cleanXSS(value);
                key = cleanXSS(key);
                queryString.append(key).append("=").append(value).append("&");
            }
        }  
        // 去掉最后一个空格  
        if(queryString.length() == 0){
        	return "";
        }
        queryString = new StringBuilder(queryString.substring(0, queryString.length() - 1));
        return queryString.toString();
    }
    public static HttpServletRequest getRequest(){  
        return requestLocal.get();  
    }  
      
    public static void setRequest(HttpServletRequest request){  
        requestLocal.set(request);  
    }
      
    public static HttpServletResponse getResponse(){  
        return responseLocal.get();  
    }
      
    public static void setResponse(HttpServletResponse response){  
        responseLocal.set(response);  
    }  
      
    public static HttpSession getSession(){  
        return (getRequest()).getSession();
    }  
}

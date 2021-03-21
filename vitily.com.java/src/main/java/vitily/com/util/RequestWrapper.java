package vitily.com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import vitily.com.util.log.LogAdapter;

public class RequestWrapper extends HttpServletRequestWrapper{
	static public LogAdapter logger= LogAdapter.getLogAdapter(RequestWrapper.class);
	public RequestWrapper(){  
        super(null);  
    }  
  
    public RequestWrapper(HttpServletRequest httpservletrequest) {  
        super(httpservletrequest);  
    }  
  
    public String[] getParameterValues(String s) {  
        String str[] = super.getParameterValues(s);  
        if (str == null) {  
            return null;  
        }  
        int i = str.length;  
        String as1[] = new String[i];  
        for (int j = 0; j < i; j++) {  
            as1[j] = cleanXSS(cleanSQLInject(str[j]));  
        }  
  
        return as1;  
    }  
  
    public String getParameter(String s) {  
        String s1 = super.getParameter(s);  
        if (s1 == null) {  
            return null;  
        } else {  
            return cleanXSS(cleanSQLInject(s1));  
        }  
    }  
  
    public String getHeader(String s) {  
        String s1 = super.getHeader(s);  
        if (s1 == null) {  
            return null;  
        } else {  
            return cleanXSS(cleanSQLInject(s1));  
        }  
    }  
  
    public static final String scriptRegStrs[] = {"(?i)(script|eval)","0x0d","0x0a"};
    public static final String sqlRegStrs[] = {"(?i)(insert|select|update|delete|truncate)"};
    public String cleanXSS(String src) {  
        String temp =src;  
        String nm = "＃";
        //src = src.replaceAll("#", nm);
          
        Pattern pattern=Pattern.compile("[\"\\'][\\s]*javascript:(.*)[\\\"\\']",Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(src); 
        src = matcher.replaceAll("\"\"");
          
        //增加脚本
        for(String reg : scriptRegStrs){
    	    src = src.replaceAll(reg, nm);
        }
  
        if(!temp.equals(src)){  
        	logger.info("输入信息存在xss攻击！");  
        	logger.info("原始输入信息-->"+temp);  
        	logger.info("处理后信息-->"+src);  
        }  
        return src;  
    }  
      
    //需要增加通配，过滤大小写组合  
    public String cleanSQLInject(String src) {  
        String temp =src;  
        String nm = "＃";
        for(String reg : sqlRegStrs){
    	    src = src.replaceAll(reg, nm);
        }
        if(!temp.equals(src)){  
        	logger.info("输入信息存在SQL攻击！");  
        	logger.info("原始输入信息-->"+temp);  
        	logger.info("处理后信息-->"+src);  
        }  
        return src;  
    }
}

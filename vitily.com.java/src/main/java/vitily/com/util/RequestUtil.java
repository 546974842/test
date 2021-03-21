package vitily.com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;

public class RequestUtil {
	/**
	 * 读取request流
	 * 
	 * @param request
	 * @return
	 * @author 
	 */
	public static String readReqStr(HttpServletRequest request) {
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			reader = new BufferedReader(new InputStreamReader(
					request.getInputStream(), "utf-8"));
			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != reader) {
					reader.close();
				}
			} catch (IOException e) {

			}
		}
		return sb.toString();
	}
	/**
	 * 读取流中的数据
	 * @param request
	 * @param c
	 * @return
	 */
	public static <T> T parseObjectFromReqStream(HttpServletRequest request,Class<T> c){
		String reqStr=readReqStr(request);
		if(reqStr == null){
			return null;
		}
		return JSON.parseObject(reqStr, c);
	}
	
	/**
	 * 获得客户端Ip地址
	 * @param request
	 * @return 1
	 */
	public static String getRemoteAddr(HttpServletRequest request){
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	/**
	 * 获得客户端Ip地址:过滤nginx
	 * @param request
	 * @return
	 */
	public static String getRemoteAddrTrimNg(HttpServletRequest request){
		String ip = getRemoteAddr(request);
		if(StringUtil.isEmpty(ip)){
			ip = "emptyIp";
		}
		int last = ip.lastIndexOf(",");
		if(last > -1){
			ip = ip.substring(0,last);
		}
		return ip;
	}
	public static String getString(HttpServletRequest request, String parameterName)
	  {
	    if ((request == null) || (StringUtil.isEmpty(parameterName))) {
	      return null;
	    }
	    String value = request.getParameter(parameterName);
	    if (value != null) {
	      value = value.trim();
	    }
	    return value;
	  }

	  public static String getString(HttpServletRequest request, String parameterName, String defaultValue)
	  {
	    String value = getString(request, parameterName);
	    if (StringUtil.isEmpty(value)) {
	      value = defaultValue;
	    }
	    return value;
	  }

	  public static int getInt(HttpServletRequest request, String parameterName)
	  {
	    if (request == null) {
	      return 0;
	    }
	    int value = 0;
	    String strValue = getString(request, parameterName);
	    if (StringUtil.isEmpty(strValue)) {
	      return 0;
	    }
	    try
	    {
	      value = new Integer(strValue).intValue();
	    }
	    catch (Exception ex)
	    {
	      value = 0;
	    }

	    return value;
	  }

	  public static long getLong(HttpServletRequest request, String parameterName)
	  {
	    if (request == null) {
	      return 0L;
	    }
	    long value = 0L;
	    String strValue = getString(request, parameterName);
	    if (StringUtil.isEmpty(strValue)) {
	      return 0L;
	    }
	    try
	    {
	      value = new Long(strValue).longValue();
	    }
	    catch (Exception ex)
	    {
	      value = 0L;
	    }

	    return value;
	  }

	  public static int getInt(HttpServletRequest request, String parameterName, int defaultValue)
	  {
	    int value = getInt(request, parameterName);
	    if (value == 0) {
	      value = defaultValue;
	    }
	    return value;
	  }

	  public static long getLong(HttpServletRequest request, String parameterName, int defaultValue)
	  {
	    long value = getLong(request, parameterName);

	    if (value == 0L) {
	      value = defaultValue;
	    }
	    return value;
	  }

	  public static String[] getParameterValues(HttpServletRequest request, String parameterName)
	  {
	    if (StringUtil.isEmpty(parameterName)) {
	      return null;
	    }
	    return request.getParameterValues(parameterName);
	  }

	  @SuppressWarnings("rawtypes")
	public static String printAllParameterInHidden(HttpServletRequest request)
	  {
	    StringBuffer html = new StringBuffer();
	    String hidden = "";

	    Map paramMap = request.getParameterMap();
	    Enumeration eName = request.getParameterNames();
	    if ((eName != null) && (paramMap != null))
	    {
	      while (eName.hasMoreElements())
	      {
	        String name = (String)eName.nextElement();
	        String[] values = (String[])paramMap.get(name);
	        for (int i = 0; i < values.length; i++)
	        {
	          html.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + values[i] + "\">\n");
	        }
	      }

	      hidden = html.toString();
	    }

	    return hidden;
	  }

	  public static String getParameterForURL(HttpServletRequest request)
	  {
	    StringBuffer buf = new StringBuffer();

	    @SuppressWarnings("rawtypes")
		Map paramMap = request.getParameterMap();
	    @SuppressWarnings("rawtypes")
		Enumeration eName = request.getParameterNames();
	    if ((eName != null) && (paramMap != null))
	    {
	      while (eName.hasMoreElements())
	      {
	        String name = (String)eName.nextElement();
	        String[] values = (String[])paramMap.get(name);
	        for (int i = 0; i < values.length; i++)
	        {
	          buf.append("&");
	          buf.append(name + "=" + values[i]);
	        }
	      }
	    }

	    return buf.toString();
	  }
}

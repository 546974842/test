package vitily.com.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vitily.com.util.log.LogAdapter;

public class GetContextFilter implements Filter{ 
	static LogAdapter logger = LogAdapter.getLogAdapter(GetContextFilter.class);
  
    @Override  
    public void destroy() {  
          
    }  
  
    @Override
    public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse,  
            FilterChain filterchain) throws IOException, ServletException {  
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletrequest;  
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletresponse;  
        SysContext.setRequest(httpServletRequest);  
        SysContext.setResponse(httpServletResponse);  
      //flag = true 只做URL验证; flag = false 做所有字段的验证;  
        boolean flag = false;  
        if(flag){  
//            //只对URL做xss校验  
//              
//            String requesturi = httpServletRequest.getRequestURL().toString();  
//            requesturi = URLDecoder.decode(requesturi, "UTF-8");  
//            if(requesturi!=null&&requesturi.indexOf("alipay_hotel_book_return.html")!=-1){  
//                filterchain.doFilter(servletrequest, servletresponse);  
//                return;  
//            }  
//            if(requesturi!=null&&requesturi.indexOf("account_bank_return.html")!=-1){  
//                filterchain.doFilter(servletrequest, servletresponse);  
//                return;  
//            }  
//            if(requesturi!=null&&requesturi.indexOf("/alipay/activity.html")!=-1){  
//                filterchain.doFilter(servletrequest, servletresponse);  
//                return ;  
//            }  
//            if(requesturi!=null&&requesturi.indexOf("/alipayLogin.html")!=-1){  
//                filterchain.doFilter(servletrequest, servletresponse);  
//                return ;  
//            }  
//            RequestWrapper rw = new RequestWrapper(httpServletRequest);  
//            String param =  httpServletRequest.getQueryString();  
//            if(!"".equals(param) && param != null) {  
//                param = URLDecoder.decode(param, "UTF-8");  
//                String originalurl = requesturi + param;  
//                  
//                String sqlParam = param;  
//                //添加sql注入的判断  
//                if(requesturi.endsWith("/askQuestion.html") || requesturi.endsWith("/mem/answer.html")){
//                    sqlParam = rw.cleanSQLInject(param);  
//                }  
//                  
//                String xssParam = rw.cleanXSS(sqlParam);  
//                requesturi += "?"+xssParam;  
//                  
//                  
//                if(!xssParam.equals(param)){  
//                	logger.info("requesturi::::::"+requesturi);  
//                    httpServletResponse.sendRedirect(requesturi);  
//                    logger.info("no entered.");  
////                  filterchain.doFilter(new RequestWrapper((HttpServletRequest) servletrequest), servletresponse);  
//                    return ;  
//                }  
//            }  
//            
//            //httpOnly
//            Cookie[] cookies = httpServletRequest.getCookies();  
//            if(cookies != null){  
//                for(int i=0;i<cookies.length;i++){  
//                    Cookie cookie = cookies[i];  
//                    if(cookie != null && cookie.getName() != null){  
//                        String value = cookie.getValue();  
//                        httpServletResponse.setHeader("Set-Cookie", cookie.getName() + "=" + value + "; Secrue; HTTPOnly; ");  
//                    }  
//                }  
//            }
           //httpOnly end
            filterchain.doFilter(httpServletRequest, httpServletResponse);  
        }else{  
              
            //对请求中的所有东西都做校验，包括表单。此功能校验比较严格容易屏蔽表单正常输入，使用此功能请注意。  
            filterchain.doFilter(new RequestWrapper((HttpServletRequest) servletrequest), servletresponse);  
        }  
        //chain.doFilter(request, response);  
    }
  
    @Override  
    public void init(FilterConfig config) throws ServletException {  
          
    }  
  
} 
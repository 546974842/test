package vitily.com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * session 相关操作
 * @author lether
 *
 */
public class SessionHelper {
	/**
	 * 根据request获取保存的session对象：可转移memcached
	 * @param request 1
	 * @param session_key 2
	 * @return 3
	 */
	public static Object getSession(HttpServletRequest request,String session_key){
		HttpSession session=request.getSession();
		if(session==null){
			return null;
		}
		return session.getAttribute(session_key);
	}
	/**
	 * 设置session值
	 * @param request 1
	 * @param session_Key 2
	 * @param session_val 3
	 * @return 4
	 */
	public static boolean setSession(HttpServletRequest request,String session_Key,Object session_val){
		HttpSession session=request.getSession();
		if(session==null){
			return false;
		}
		session.setAttribute(session_Key, session_val);
		return true;
	}
	/**
	 * 移除session
	 * @param request 1
	 * @param session_key 2
	 */
	public static boolean removeSession(HttpServletRequest request,String session_key){
		HttpSession session=request.getSession();
		if(session==null){
			return false;
		}
		session.removeAttribute(session_key);
		return true;
	}
}

package com.taotaoti.common.utils;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liulxiang
 * 获取HTTP相关的属性
 */
public class HttpUtils {

	private static final String forwardHeadName = "X-Forwarded-For";
	public static String getHttpForwardIp(HttpServletRequest request){
		if(request == null){
			return null;
		}
		String ip=request.getHeader(forwardHeadName);
		if(ip==null){
			return request.getRemoteAddr(); 
		}else{
			 int idx = ip.indexOf(',');
	         if (idx > -1) {
	        	 ip = ip.substring(0, idx);
	         }
	         return ip;
		}
	}
	
	/**
	 * 获取浏览器信息
	 * @author liulxiang
	 * @version 1.2.18
	 * @param request
	 * @return
	 */
	public static String getHttpBrowser(HttpServletRequest request){
		if(request == null){
			return null;
		}
		return request.getHeader("User-Agent");
	}
	
	/**
	 * 获得整个url,如http://www.weamea.com/music/index.jsp?id=4342
	 * @author liulxiang
	 * @version 1.2.18
	 * @param request
	 * @return
	 */
	public static String getFullURL(HttpServletRequest request){
		if(request == null){
			return null;
		}
		String url=request.getRequestURL().toString();
		String QueryString=request.getQueryString();
		if((QueryString!=null)&&(QueryString.length()>0))
			url=url+"?"+QueryString;
		return url;
	} 
	/**
	 * 得到请求的根目录
	 * 
	 * @param request
	 * @return
	 */
	public static String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path;
		return basePath;
	}

	/**
	 * 得到结构目录
	 * 
	 * @param request
	 * @return
	 */
	public static String getContextPath(HttpServletRequest request) {
		String path = request.getContextPath();
		return path;
	}
}	

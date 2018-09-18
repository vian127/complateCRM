package com.pop136.core;

import com.pop136.customerservice.utils.BusinessException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class WebUtil {
	
	public static Map<String,String> getHeaders(HttpServletRequest request){
		Map<String,String> result = new HashMap<String,String>();
		Enumeration<String> names = request.getHeaderNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			result.put(name, request.getHeader(name));
		}
		return result;
	}
	
	public static HttpServletRequest resolveRequest(){
		ServletRequestAttributes holder = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes() ;
		return holder.getRequest() ;
	}
	
	public static String getHeader(HttpServletRequest request , String name ){
		Map<String , String> headers = getHeaders( request ) ;
		if( headers == null || headers.isEmpty() ){
			return null ;
		}
		for( Map.Entry<String , String> header : headers.entrySet() ){
			if( header.getKey().equalsIgnoreCase( name ) ){
				return header.getValue() ;
			}
		}
		return null ;
	}
	
	public static void setCacheExpireDate(HttpServletResponse response) {
		setCacheExpireDate(response, Integer.MAX_VALUE);
	}
	
	public static void setCacheExpireDate(HttpServletResponse response, int seconds) {
		if (response != null) {
			response.setHeader("Cache-Control", "PUBLIC, max-age=" + seconds + ", must-revalidate");
			
			Calendar cal = new GregorianCalendar();
			cal.add(Calendar.SECOND, seconds);
			response.setHeader("Expires", htmlExpiresDateFormat().format(cal.getTime()));
		}
	}
	
	public static void disableCache(HttpServletResponse response){
		response.setHeader("Pragma","No-cache"); 
		response.setHeader("Cache-Control","no-cache"); 
		response.setDateHeader("Expires", 0); 
	}

	private static DateFormat htmlExpiresDateFormat() {
		DateFormat httpDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
		httpDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		return httpDateFormat;
	}
	
	
	public static String getCookieValue(HttpServletRequest request, String cookieName){
		Cookie[] cookies = request.getCookies();
		if(cookies==null||cookies.length==0){
			return null;
		}
		for(int i=0;i<cookies.length;i++){
			Cookie cookie = cookies[i];
			String name = cookie.getName();
			if(cookieName.equalsIgnoreCase(name)){
				return cookie.getValue();
			}
		}
		return null;
	}
	
	public static void addCookie(HttpServletResponse response, String name, String value){
		Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        response.addCookie(cookie); 
	}

	public static void addCookie(HttpServletResponse response, String name, String value, String path, int maxAge){
		Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie); 
	}

	protected static void clearCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
	}

	public static void setDownloadHeader(HttpServletRequest request, HttpServletResponse response, String filename, String contentType) throws IOException{
		String DOWN_TYPE = "application/x-download";
		if(contentType==null){
			contentType = DOWN_TYPE;
		}
		response.setContentType(contentType);
		if(isIE(request)){
			filename = java.net.URLEncoder.encode(filename, "utf-8");
		}else{
			filename = new String(filename.getBytes("utf-8"), "ISO8859-1");
		}
		if(DOWN_TYPE.equals(contentType)){
			response.setHeader("Content-Disposition", "attachment; filename=" + filename);	
		}
	}

	public static void setImageHeader(HttpServletResponse response, String extName, Integer length) throws IOException{
		response.setContentType("image/"+extName);
		if(length!=null){
			response.setContentLength(length);
		}
	}
	
	private static boolean isIE(HttpServletRequest request){
		String ua = request.getHeader("User-Agent");
		if(ua==null || ua.isEmpty()){
			return false;
		}
		ua = ua.toLowerCase();
		return ua.indexOf("msie")!=-1;
	}
	
	public static Map<String, String> getParamExcept( String ... except ) {
		List<String> exceptFields = null ;
		if( except != null && except.length > 0 ){
			exceptFields = Arrays.asList( except ) ;
		}
		Map<String, String[]> ms = resolveRequest().getParameterMap();
		Map<String, String> result = new HashMap<String, String>();
		if (ms == null || ms.size() == 0)
			return result;
		for (Map.Entry<String, String[]> m : ms.entrySet()) {
			if( exceptFields != null && exceptFields.contains( m.getKey() ) ){
				continue ;
			}
			result.put(m.getKey(), m.getValue()[0]);
			if(m.getValue().length > 1){
				result.put(m.getKey(), StringLang.join(m.getValue()));
			}
		}
		return result;
	}
	
	public static Map<String, String> getParam( String ... except ) {
		List<String> exceptFields = null ;
		if( except != null && except.length > 0 ){
			exceptFields = Arrays.asList( except ) ;
		}
		Map<String, String[]> ms = resolveRequest().getParameterMap();
		Map<String, String> result = new HashMap<String, String>();
		if (ms == null || ms.size() == 0)
			return result;
		for (Map.Entry<String, String[]> m : ms.entrySet()) {
			if( exceptFields != null && !exceptFields.contains( m.getKey() ) ){
				continue ;
			}
			result.put(m.getKey(), m.getValue()[0]);
			if(m.getValue().length > 1){
				result.put(m.getKey(), StringLang.join(m.getValue()));
			}
		}
		return result;
	}

  public static Map<String, String> getParameterMap(HttpServletRequest request) {
    Map<String, String[]> ms = request.getParameterMap();
    Map<String, String> result = new HashMap<String, String>();
    if (ms == null || ms.size() == 0)
      return result;
    for (Map.Entry<String, String[]> m : ms.entrySet()) {
      result.put(m.getKey(), m.getValue()[0]);
      if(m.getValue().length > 1){
        result.put(m.getKey(), join(m.getValue()));
      }
    }
    return result;
  }
	
	public static Map<String, Object> getParamAsObj( String ... except ) {
		List<String> exceptFields = null ;
		if( except != null && except.length > 0 ){
			exceptFields = Arrays.asList( except ) ;
		}
		Map<String, String[]> ms = resolveRequest().getParameterMap();
		Map<String, Object> result = new HashMap<String, Object>();
		if (ms == null || ms.size() == 0)
			return result;
		for (Map.Entry<String, String[]> m : ms.entrySet()) {
			if( exceptFields != null && !exceptFields.contains( m.getKey() ) ){
				continue ;
			}
			result.put(m.getKey(), m.getValue()[0]);
			if(m.getValue().length > 1){
				result.put(m.getKey(), Arrays.asList( m.getValue() ) );
			}
		}
		return result;
	}
	
	public static String getParameter( String name ){
		Map<String , String> parameters = getParam() ;
		if( parameters == null || parameters.isEmpty() ){
			return null ;
		}
		for( Map.Entry<String, String> parameter : parameters.entrySet() ){
			if( parameter.getKey().equalsIgnoreCase( name ) ){
				return parameter.getValue() ;
			}
		}
		return null ;
	}

  private static String join(String[] ss){
    StringBuilder sb = new StringBuilder();
    for(String s:ss){
      sb.append(s);
      sb.append(',');
    }
    return sb.substring(0, sb.length()-1);
  }

	/**
	 * 截取字符串放入List,通过&符号toSpilt
	 *
	 * @param
	 * @return
	 */
	public static List<String> getImageUrlDetail(String imagUrls) {
		if (imagUrls == null || "".equals(imagUrls)) {
			return null;
		}
		List<String> imageList = new ArrayList<>();
		String[] splits = imagUrls.split(",");
		for (String split : splits) {
			imageList.add(split);
		}
		return imageList;
	}


	/**
	 * 获取 crm 系统跳转链接
	 * @return
	 */
	public static String getHashKey(String path, String param) throws IOException, ScriptException {

		if (path == null || path.equals("")){
			return null;
		}

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");

		FileReader reader = new FileReader(path);   // 执行指定脚本

		engine.eval(reader);

		String resultUrl = null;
		if(engine instanceof Invocable) {
			Invocable invoke = (Invocable)engine;    // 调用merge方法，并传入两个参数

			try {
				resultUrl = (String)invoke.invokeFunction("hex_md5", param);
			} catch (NoSuchMethodException e) {
				throw new BusinessException("执行 js文件 转换 hashkey 异常:"+e);
			}
		}
		reader.close();
		return resultUrl;
	}

}

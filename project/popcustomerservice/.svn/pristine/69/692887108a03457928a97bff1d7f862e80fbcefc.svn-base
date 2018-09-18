package com.pop136.customerservice.controller;

import com.pop136.core.ValidateUtil;
import com.pop136.core.WebUtil;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 *
 */
public class BaseAction {

	/**
	 * Request Parameter Validation .
	 * 
	 * @param obj		Target object .
	 * @param groups	Validated groups .
	 * @throws MethodArgumentNotValidException
	 */
	protected <T> void assertValid( 
			T obj , Class<?> ... groups ) throws MethodArgumentNotValidException {
		BindingResult bindResult = null ;
		if( ( bindResult = ValidateUtil.validate(obj, groups) ) != null ){
			Method m = bindResult.getClass().getMethods()[0];
			throw new MethodArgumentNotValidException( new MethodParameter( m, 0) , bindResult ) ;
		}
	}
	

	protected static BindException bindParams(Object bean , Map map, String[] allowedFields , String[] disallowedFields){
		DataBinder binder = new DataBinder(bean);
		if(allowedFields!=null && allowedFields.length>0){
			binder.setAllowedFields(allowedFields);
		}
		if(disallowedFields!=null && disallowedFields.length>0){
			binder.setDisallowedFields(disallowedFields);
		}
		MutablePropertyValues mpvs = new MutablePropertyValues(map);
		binder.bind(mpvs);
		BindException errors = new BindException(binder.getBindingResult());
		return errors;
	}


	protected HttpServletRequest getRequest(){
		ServletRequestAttributes holder = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = holder.getRequest();
		return request;
	}

  protected Map<String, String> getParameterMap() {
    return WebUtil.getParameterMap(this.getRequest());
  }
	
	protected String getContextPath(){
		return this.getRequest().getContextPath();
	}
	
	/**
	 * 过滤为null或者空字符的参数
	 * 
	 * @param params
	 */
	protected void filteParams( Map<String , Object> params ){
		if( params == null || params.isEmpty() ) {
			return ;
		}
		Map<String , Object> tempParams = new HashMap<String , Object>() ;
		Set<String> paramsKeys = params.keySet() ;
		for( String paramsKey : paramsKeys ){
			Object temp = params.get( paramsKey ) ;
			if( temp != null && !temp.toString().trim().equals("") ){
				tempParams.put( paramsKey ,  temp ) ;
			}
		}
		params.clear(); 
		params.putAll( tempParams );
	}

	public String getPic(String picture){
		if(picture==null || picture.equals("")){
			return null;
		}else{
			String pic="http://ulb.oss-cn-beijing.aliyuncs.com"+picture;
			return pic;
		}
	}
}

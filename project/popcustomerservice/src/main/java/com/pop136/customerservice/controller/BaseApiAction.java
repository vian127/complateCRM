package com.pop136.customerservice.controller;

import com.pop136.customerservice.utils.BusinessException;
import com.pop136.customerservice.utils.PageParam;
import com.pop136.core.*;
import com.pop136.core.exception.AbstractBussinessException;
import com.pop136.core.exception.StatusCode;
import com.pop136.core.json.JsonSerializer;
import com.pop136.customerservice.vo.common.Page;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseApiAction extends BaseAction{
	
	public Logger logger = LoggerFactory.getLogger(getClass()) ;
	
	private ThreadLocal<JsonSerializer> jsonSerializer = new ThreadLocal<JsonSerializer>() ;;


	/**
	 * 统一返回数据模型封装.
	 * 
	 * @param exception
	 * @return
	 */
	private ResultModal handleMessage(AbstractBussinessException exception) {
		ResultModal codeMessage = new ResultModal(exception.getCode(), exception.getMessage());
		return codeMessage;
	}


	private String response(int code, String message, Object data , Object extra ) {
		ResultModal reultModal = getResultModal(code, message, data , extra ) ;
		if( jsonSerializer.get() == null ){
			jsonSerializer.set( new JsonSerializer().filterNullValues() );
		}
		return jsonSerializer.get().toJson( reultModal ) ;
	}

	protected String success(Object data , Object extra ) {
		return response( 
				StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), data , extra );
	}
	protected String success(Object data  ){
		return success( data , null ) ;
	}
	
	protected String error(int code, String message, Object data) {

		return response(code, message, data , null );
	}

	protected ResponseEntity<ResultModal> successEntity(Object data) {

		return resopnse(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage() , data,
				HttpStatus.OK);
	}

	private ResponseEntity<ResultModal> response(ResultModal codeMessage, Object data, HttpStatus status) {

		return resopnse(codeMessage.getCode(), codeMessage.getMessage(), data, status);
	}

	private ResponseEntity<ResultModal> resopnse(int code, String message, Object data, HttpStatus status) {

		return new ResponseEntity<ResultModal>(getResultModal(code, message, data , null ), status);
	}
	
	/**
	 * 设置返回包含字段.客户端动态返回字段优先于服务端设置的返回字段.
	 * 
	 * @param serializeClass
	 * @param includeProperties
	 */
	protected void setIncludeProperties( Class<?> serializeClass ,String ... includeProperties) {
		if( jsonSerializer.get() == null ){
			jsonSerializer.set( new JsonSerializer().filterNullValues() );
		}
		jsonSerializer.get().include( serializeClass , includeProperties ) ;
	}

	/**
	 * 设置返回过滤字段.客户端设置的动态返回过滤字段优先于服务端设置返回字段.
	 * 
	 * @param serializeClass
	 * @param excludeProperties
	 */
	protected void setExcludeProperties( Class<?> serializeClass , String ... excludeProperties) {
		if( jsonSerializer.get() == null ){
			jsonSerializer.set( new JsonSerializer().filterNullValues() );
		}
		jsonSerializer.get().exclude( serializeClass , excludeProperties ) ;
	}

	private ResultModal getResultModal(int code, String message, Object data , Object extra ) {
		ResultModal resultModal = null;
		if (data == null)
			resultModal = new ResultModal(code, message);
		else
			resultModal = new ResultModalWithData(code, message, data , extra );
		return resultModal;
	}

	public class ResultModal {
		private int code;
		private String message;
		private Object extra ;

		public ResultModal(int code, String message) {
			this.code = code;
			this.message = message;
		}
		
		public ResultModal(int code, String message , Object extra ) {
			this.code = code;
			this.message = message;
			this.extra = extra ;
		}

		public ResultModal() {
			this.code = StatusCode.SUCCESS.getCode();
			this.message = StatusCode.SUCCESS.getMessage();
		}

		public int getCode() {
			return code;
		}

		public Object getExtra() {
			return extra;
		}

		public void setExtra(Object extra) {
			this.extra = extra;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	class ResultModalWithData extends ResultModal {
		private Object data;

		public ResultModalWithData(int code, String message, Object data , Object extra ) {
			super(code, message , extra );
			this.data = data;
		}

		public ResultModalWithData(int code, String message) {
			super(code, message);
		}

		public ResultModalWithData(Object data) {
			super();
			this.data = data;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

	}
	
	protected ParamModal getParamModal( ){
		ParamModal paramModal = new ParamModal() ;
		paramModal.setPageNum( StringLang.getInt( WebUtil.getParameter( "page" )  ) );
		paramModal.setPageSize( StringLang.getInt( WebUtil.getParameter( "size" ) ) );
		paramModal.setSortField( WebUtil.getParameter("orderField")   );
		paramModal.setSortType( (WebUtil.getParameter("orderType") ) );
		paramModal.putAll( WebUtil.getParamExcept() );
		this.filteParams(paramModal);
		//"page" , "size" , "orderField" , "orderType"
		return paramModal ;
	}
	
	public class ParamModal extends HashMap<String,Object>{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private Integer pageNum ;
		private Integer pageSize ;
		private String sortField ;
		private String sortType ;
		
		public PageParam getPageParam(){
			PageParam pageParam = new PageParam( pageNum , pageSize , true ) ;
			pageParam.orderBy( sortField , sortType ) ;
			return pageParam ;
		}
		
		public Integer getPageNum() {
			return pageNum;
		}
		public void setPageNum(Integer pageNum) {
			this.pageNum = pageNum;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		public String getSortField() {
			return sortField;
		}
		public void setSortField(String sortField) {
			this.sortField = sortField;
		}
		public String getSortType() {
			return sortType;
		}
		public void setSortType(String sortType) {
			this.sortType = sortType;
		}
	}

  protected Integer resoveUserId( HttpServletRequest request ){
    Integer userId = null ;
    Object attr =  request.getAttribute("userId") ;
    if( attr != null ){
      try{
        userId = Integer.parseInt( attr.toString() ) ;
      }catch(Exception e){
        userId = null ;
      }
    }
    return userId ;
  }


  /**
   *验证手机号
   */
  private void validatePhoneNo(String phoneNo) {
    if(!phoneNo.trim().startsWith("+")) {
      Pattern pattern = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
      Matcher matcher = pattern.matcher(phoneNo);
      if(!matcher.matches()){
        logger.error("phone number format error...");
        throw new BusinessException("请输入正确的手机号");
      }
    }
  }


  /**
   * 获取JavaBean属性名
   *
   * @return String[]
   */
  public static void toColumnWithHump(Object obj)  {
    Field[] fields;
    Field field;
    int count = 0;
    String name;
    Object value;

    if (obj == null) {
      return ;
    }
    fields = obj.getClass().getDeclaredFields();
    if (fields != null && fields.length > 0) {
      count = fields.length;
    }

    for (int i = 0; i < count; i++) {
      field = fields[i];
      name = field.getName();
      StringLang.toColumnWithHump(name);
    }
  }


  public static Map<String, Object> convertPage(List<?> list, Object count){

	  Map<String, Object> pageResult = new HashMap<>();

	  pageResult.put("pageSize", list.isEmpty() ? 0 : list.size());
	  pageResult.put("count", count);

	  return pageResult;
  }



}

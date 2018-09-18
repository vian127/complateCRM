package com.pop136.customerservice.utils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * json参数解析工具类
 */
public class JsonParseUtil {
	
	public static Logger logger = LoggerFactory.getLogger(JsonParseUtil.class) ;

	public static Integer parsePageNum(JSONObject json) {
	    return parsePageNum(json,"pageNum");        
    }
	/**
	 * 解析页码
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static Integer parsePageNum(JSONObject json, String paramName) {
		Integer pageNum = null;
		try{
			pageNum = json.getInteger(paramName);
		} catch(NumberFormatException | JSONException e) {
			logger.error("parse pageNum by json error...");
			throw new BusinessException("参数校验异常");
		}
		return pageNum == null ? 1 : pageNum;
	}
	public static Integer parsePageSize(JSONObject json) {
	    return parsePageSize(json,"pageSize");
	}
	/**
	 * 解析页面大小
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static Integer parsePageSize(JSONObject json, String paramName) {
		Integer pageSize = null;
		try {
			pageSize = json.getInteger(paramName);
		} catch (NumberFormatException | JSONException e) {
			logger.error("parse pageSize by json error...");
			throw new BusinessException("参数校验异常");
		}
		return pageSize == null ? 10 : pageSize;
	}
	
	/**
	 * 获取非必传String参数
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static String parseStringValue(JSONObject json, String paramName) {
		String stringValue = null;
		try {
			stringValue = json.getString(paramName);

      if (stringValue == null || stringValue.equals("")) {
        return null;
      }

			if(stringValue != null && !stringValue.equals("")) {
//				stringValue = EmojiFilter.filterEmoji(stringValue);//过滤emoji 或者 其他非文字类型的字符
			}
		} catch(Exception e) {
			logger.error("parse param by json is error...");
			throw new BusinessException("参数校验异常");
		}
		return stringValue;
	}
	
	/**
	 * 获取必传String参数
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static String parseRequiredStringValue(JSONObject json, String paramName) {
		String stringValue = parseStringValue(json, paramName);
		if(stringValue == null || stringValue.equals("")) {
			logger.error("Required param:" + paramName + " is null...");
			throw new BusinessException("参数校验异常");
		}
		return stringValue;
	}
	
	/**
	 * 获取非必传,长度有限制的String参数
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static String parseStringValue(JSONObject json, String paramName, Integer maxLength) {
		String stringValue = null;
		try {
			stringValue = json.getString(paramName);
			if(stringValue != null && !stringValue.equals("")) {
//				stringValue = EmojiFilter.filterEmoji(stringValue);//过滤emoji 或者 其他非文字类型的字符
				if(stringValue.length() > maxLength) {
					logger.error("param: " + paramName + " too long...");
					throw new BusinessException("参数校验异常");
				}
			}
		} catch(Exception e) {
			logger.error("parse param by json is error...");
			throw new BusinessException("参数校验异常");
		}
		return stringValue;
	}
	
	/**
	 * 获取非必传Integer参数
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static Integer parseIntegerValue(JSONObject json, String paramName) {
		Integer integerValue = null;
		try {
			integerValue = json.getInteger(paramName);
		} catch (NumberFormatException | JSONException e) {
			logger.error("parse integer param by json error...");
			throw new BusinessException("参数校验异常");
		}
		return integerValue;
	}
	
	/**
	 * 获取非必传Integer参数
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static Integer parseIntegerValueOrDefult(JSONObject json, String paramName, Integer defultValue) {
		Integer integerValue = null;
		try {
			integerValue = json.getInteger(paramName);
		} catch (NumberFormatException | JSONException e) {
			logger.error("parse integer param by json error...");
			throw new BusinessException("参数校验异常");
		}
		return integerValue == null ? defultValue : integerValue;
	}
	
	/**
	 * 获取必传Integer参数
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static Integer parseRequiredIntegerValue(JSONObject json, String paramName) {
		Integer integerValue = parseIntegerValue(json, paramName);
		if(integerValue == null) {
			logger.error("Required param:" + paramName + " is null...");
			throw new BusinessException("参数校验异常");
		}
		return integerValue;
	}
	
	/**
	 * 获取非必传Double参数
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static Double parseDoubleValue(JSONObject json, String paramName) {
		Double doubleValue = null;
		try {
			doubleValue = json.getDouble(paramName);
		} catch (NumberFormatException | JSONException e) {
			logger.error("parse double param by json error...");
			throw new BusinessException("参数校验异常");
		}
		return doubleValue;
	}
	
	/**
	 * 获取必传Double参数
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static Double parseRequiredDoubleValue(JSONObject json, String paramName) {
		Double doubleValue = parseDoubleValue(json, paramName);
		if(doubleValue == null) {
			logger.error("Required param:" + paramName + " is null...");
			throw new BusinessException("参数校验异常");
		}
		return doubleValue;
	}
	
	/**
	 * 获取指定范围的参数
	 * @param json
	 * @param paramName
	 * @param array 指定参数范围（非必传），如new Integer[]{1,2,3}
	 * @return
	 */
	public static Integer parseIntegerAndValidate(JSONObject json, String paramName, Integer[] validateArray) {
		Integer integerValue = parseRequiredIntegerValue(json, paramName);
		if(validateArray != null && !Arrays.asList(validateArray).contains(integerValue)) {
			logger.error("param illegal error... ");
			throw new BusinessException("参数校验异常");
		}
		return integerValue;
	}
	
	/**
	 * 获取必传Float类型参数
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static Float parseRequiredFloatValue(JSONObject json, String paramName) {
		Float  floatValue =parseFloatValue(json, paramName);
		if(floatValue == null) {
			logger.error("Required param:" + paramName + " is null...");
			throw new BusinessException("参数校验异常");
		}
		return floatValue;
	}
	
	/**
	 * 获取必传Float类型参数,参数必须大于零
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static Float parseRequiredMinFloatValue(JSONObject json, String paramName) {
		Float  floatValue =parseFloatValue(json, paramName);
		if(floatValue == null||floatValue<=0) {
			logger.error("Required param:" + paramName + " is null...");
			throw new BusinessException("参数校验异常");
		}
		return floatValue;
	}
	
	/**
	 * 获取非必传Float类型参数
	 * @param json
	 * @param paramName
	 * @return
	 */
	public static Float parseFloatValue(JSONObject json, String paramName) {
		Float floatValue = null;
		try {
			floatValue = json.getFloat(paramName);
		} catch (NumberFormatException | JSONException e) {
			logger.error("parse Float param by json error...");
			throw new BusinessException("参数校验异常");
		}
		return floatValue;
	}
	
}

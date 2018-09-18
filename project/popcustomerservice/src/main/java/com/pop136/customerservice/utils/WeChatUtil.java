package com.pop136.customerservice.utils;

import java.util.HashMap;  
import java.util.Map;  
  
 
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class WeChatUtil {
 
	
	/** 
     *  
     * @param code 识别得到用户id必须的一个值 
     * 得到网页授权凭证和用户id 
     * @return 
     */  
    public static Map<String,String> oauth2GetOpenid(String code) {  
    	
        Map<String,String> result = new HashMap<String,String>();      	
    	
        RestTemplate rest = new RestTemplate();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+Constants.appid+"&secret="+Constants.secret+"&js_code="+code+"&grant_type=authorization_code";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        HttpEntity requestEntity = new HttpEntity( headers);
        try {     
            ResponseEntity<String> entity = rest.exchange(url, HttpMethod.GET, requestEntity, String.class, new Object[0]);
            JSONObject jsonObject= JSON.parseObject(entity.getBody());    	
        	        	
            String openid =String.valueOf(jsonObject.get("openid"));  
            String accesstoken=String.valueOf(jsonObject.get("session_key"));  
            
             
            result.put("openid", openid);  
            result.put("accesstoken", accesstoken);   
        } catch (Exception e) {  
            e.printStackTrace();   
        } finally {  
            //client.getConnectionManager().shutdown();  
        }  
        return result;  
    }  
    
 
    
   
}

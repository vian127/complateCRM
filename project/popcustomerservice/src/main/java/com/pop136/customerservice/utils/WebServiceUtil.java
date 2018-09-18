package com.pop136.customerservice.utils;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pop136.customerservice.service.RestfulClient;

public class WebServiceUtil {

	public static String getJSonByAPI(String url, Map<String, String> paraMap) 
	{
		String strJSon = "";
		
		RestfulClient client = new RestfulClient();		
		ResponseEntity<String> responseBody = client.getPostEntity(url, paraMap);

		System.out.println(responseBody.getBody());
		strJSon = responseBody.getBody();
		
		return strJSon;
	}
	
	public static <T> T getObjectByAPI(String url, Map<String, String> paraMap, Class<T> valueType) 
	{
		String strJSon = "";
		
		RestfulClient client = new RestfulClient();		
		ResponseEntity<String> responseBody = client.getPostEntity(url, paraMap);

		System.out.println(responseBody.getBody());
		strJSon = responseBody.getBody();
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(strJSon, valueType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static <T> T getObjectByAPI(String context, Class<T> valueType) 
	{

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(context, valueType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}	
	
}

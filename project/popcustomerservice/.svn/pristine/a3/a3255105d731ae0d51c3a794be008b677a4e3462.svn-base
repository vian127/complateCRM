package com.pop136.customerservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestfulClient {

	RestTemplate restTemplate;

	public RestfulClient() {
		restTemplate = new RestTemplate();
	}

	/**
	 * Post method
	 */
	public void postEntity(String url) {
		System.out.println("Begin /POST request!");
		// replace http://localhost:8080 by your restful services
		String postUrl = "http://121.41.13.95:8484/MjkPcV2/material/getMaterialById.bk";
		// String postUrl = url; //"http://localhost:8080/post";

		// TODO Auto-generated method stub
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");

		headers.setAll(map);

		Map<String, String> req_payload = new HashMap<String, String>();
		req_payload.put("c_id", "A47800IAC00037-16275C8DBBBP0CP56M2023G7J64IPBFK3");

		HttpEntity<?> request = new HttpEntity<>(req_payload, headers);

		/*
		 * ResponseEntity<?> response = new RestTemplate().postForEntity(url, request,
		 * String.class); ServiceResponse entityResponse = (ServiceResponse)
		 * response.getBody(); System.out.println(entityResponse.getData());
		 * 
		 * Customer customer = new Customer(123, "Jack", 23);
		 */
		ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, request, String.class);
		System.out.println("Response for Post Request: " + postResponse.getBody());
	}
	
	/**
	 * Post method
	 */
	public ResponseEntity<String> getPostEntity(String url, Map<String, String> req_payload) {
		System.out.println("Begin /POST request!");
		String postUrl = url; 

		// TODO Auto-generated method stub
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");

		headers.setAll(map);

		HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
		ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, request, String.class);
		return postResponse;
	}	

	/**
	 * get method
	 */
	public void getEntity(String url) {
		/*
		 * System.out.println("Begin /GET request!"); String getUrl = url;
		 * //"http://localhost:8080/get?id=1&name='Mary'&age=20";
		 * ResponseEntity<Customer> getResponse = restTemplate.getForEntity(getUrl,
		 * Customer.class); if(getResponse.getBody() != null){
		 * System.out.println("Response for Get Request: " +
		 * getResponse.getBody().toString()); }else{
		 * System.out.println("Response for Get Request: NULL"); }
		 */
	}

	/**
	 * put method
	 */
	public void putEntity(String url) {
		/*
		 * System.out.println("Begin /PUT request!"); String putUrl = url;
		 * //"http://localhost:8080/put/2"; Customer puttCustomer = new Customer("Bush",
		 * 23); restTemplate.put(putUrl, puttCustomer);
		 */
	}

	/**
	 * delete method
	 */
	public void deleteEntity(String url) {
		/*
		 * System.out.println("Begin /DELETE request!"); String deleteUl = url;
		 * //"http://localhost:8080/delete/1"; restTemplate.delete(deleteUl);
		 */
	}
}

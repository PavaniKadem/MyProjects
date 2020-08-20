package com.example.RestClientSide.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.RestClientSide.model.User;

@Service
public class ClientSideController {
	@Autowired
	RestTemplate restTemplate;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
	String dateAsString = simpleDateFormat.format(new Date());
	String serviceType="LAN";

	/*
	 * public ClientSideController(RestTemplateBuilder restTemplateBuilder) {
	 * restTemplate = restTemplateBuilder .basicAuthentication("pavani", "pav123")
	 * .build(); }
	 */
	private static HttpHeaders getHeaders() {
		String plainCredentials = "pavani:pav123";
		String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Credentials);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	public String getUsers() {
		// HttpHeaders headers=new HttpHeaders();
		// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<>(getHeaders());
		String output = restTemplate
				.exchange("http://localhost:9098/UserService/test", HttpMethod.GET, httpEntity, String.class).getBody();
		if (output != null && !output.isEmpty()) {
			return output;
		}
		return "unable to fetch data";

	}

	public User pathVarTest() {
		// HttpHeaders headers=new HttpHeaders();
		// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> httpEntity = new HttpEntity<>(getHeaders());
		Map<String, Integer> params = new HashMap<>();
		params.put("id", 101);
		ResponseEntity<User> user = restTemplate.exchange("http://localhost:9098/UserService/PathVarTest/{id}",
				HttpMethod.GET, httpEntity, User.class, params);

		if (user.getStatusCode().is2xxSuccessful()) {
			return user.getBody();
		}
		return null;

	}

	public User reqstParamTest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> httpEntity = new HttpEntity<>(headers);
		Map<String, Integer> params = new HashMap<>();
		params.put("id", 100);
		ResponseEntity<User> user = restTemplate.exchange("http://localhost:9098/UserService/ReqParamTest?id={id}",
				HttpMethod.GET, httpEntity, User.class, params);

		if (user.getStatusCode().is2xxSuccessful()) {
			return user.getBody();
		}
		return null;

	}

	// @RequestMapping(value = "/postUsers", method = RequestMethod.POST)
	public User createUsers(/* @RequestBody User user */) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		User u1 = new User();
		u1.setUserId(103);
		u1.setUserName("QWERTY");
		HttpEntity<User> httpEntity = new HttpEntity<User>(u1, headers);
		return restTemplate.exchange("http://localhost:9098/UserService/RespEntityPostTest", HttpMethod.POST,
				httpEntity, User.class).getBody();
	}

	public User updateUsers(/* @RequestBody User user */) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		User u1 = new User();
		// u1.setUserId(103);
		u1.setUserName("QWERTY");
		HttpEntity<User> httpEntity = new HttpEntity<User>(u1, headers);
		Map<String, Integer> params = new HashMap<>();
		params.put("id", 101);
		return restTemplate.exchange("http://localhost:9098/UserService/putTest/{id}", HttpMethod.PUT, httpEntity,
				User.class, params).getBody();
	}

	public void deleteTest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		Map<String, Integer> params = new HashMap<>();
		params.put("id", 101);
		ResponseEntity<Void> output = restTemplate.exchange("http://localhost:9098/UserService/deleteTest/{id}",
				HttpMethod.DELETE, httpEntity, Void.class, params);
		System.out.println(output.getStatusCode());

	}

	public User reqstParamAndPathVar(Integer no) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		// headers.setBasicAuth("pavani", "pav123");
		HttpEntity<User> httpEntity = new HttpEntity<>(headers);
		System.out.println("Date:" + dateAsString);
		String url = "http://localhost:9098/UserService/pathVarAndParam/{id}";
		// URI (URL) parameters
		Map<String, Integer> urlParams = new HashMap<>();
		urlParams.put("id", no);
		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
				// Add query parameter
				.queryParam("transactionId", dateAsString);

		System.out.println(builder.buildAndExpand(urlParams).toUri());

		ResponseEntity<User> user = restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET,
				httpEntity, User.class);

		if (user.getStatusCode().is2xxSuccessful()) {
			return user.getBody();
		}
		return null;

	}

	/**
	 * Console output:
	 * http://test.com/solarSystem/planets/Mars/moons/Phobos?firstName=Mark&lastName=Watney
	 */
	public User reqstParamAndMultiplePathVar(Integer no, String name) {
		ResponseEntity<User> user = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<User> httpEntity = new HttpEntity<>(getHeaders());
			System.out.println("Date:" + dateAsString);
			String url = "http://localhost:9098/UserService/pathVarAndMultipleParam/{id}/{name}";
			// URI (URL) parameters of different dataTypes
			Map<String, String> urlParams = new HashMap<>();
			urlParams.put("id", no.toString());
			// Map<String, String> urlParams1 = new HashMap<>();
			urlParams.put("name", name);
			// Query parameters
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
					// Add query parameter
					.queryParam("transactionId", dateAsString)
			.queryParam("deviceServiceType", serviceType);
			//System.out.println("before");
			System.out.println(builder.buildAndExpand(urlParams).toUri());
			;
			user = restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, httpEntity,
					User.class);
			System.out.println("User status:" + user.getStatusCode());
			if (user.getStatusCode().is2xxSuccessful()) {
				return user.getBody();
			}

			
			/*
			 * else if (user.getStatusCode().is4xxClientError()) {
			 * System.out.println("after"); System.out.println("transactionId: " +
			 * user.getBody().getUserId());
			 * user.getBody().setFailureMessage(user.getBody().getFailureMessage()
			 * +"ADDED here"); return user.getBody(); }
			 */
			 

		} catch (HttpStatusCodeException ex) {
			//System.out.println(ex.getStatusCode().toString());
			//ex.printStackTrace();
			System.out.println("~~Failure response~~");
			System.out.println(ex.getRawStatusCode());
			System.out.println(ex.getResponseBodyAsString());
			User u=new User();
            u.setFailureMessage("device Details missing:"+ex.getResponseBodyAsString());
            //u.setTranscationID(ex.getRawStatusCode());
            return u;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}

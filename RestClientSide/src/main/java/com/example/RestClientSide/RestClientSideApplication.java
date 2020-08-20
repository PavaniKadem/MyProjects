package com.example.RestClientSide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.example.RestClientSide.controller.ClientSideController;
import com.example.RestClientSide.model.User;

@SpringBootApplication
public class RestClientSideApplication implements ApplicationRunner {
	@Autowired
	ClientSideController csc;

	public static void main(String[] args) {
		SpringApplication.run(RestClientSideApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		/*
		 * RestTemplate template= new RestTemplate(); template.setErrorHandler(new
		 * MyErrorHandler()); return template;
		 */
		return new RestTemplate();
	}

	/*
	 * @Bean RestOperations templateBuilder(RestTemplateBuilder restTemplateBuilder)
	 * { return restTemplateBuilder.basicAuthentication("admin",
	 * "admin123").build(); }
	 */
	  
	 
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TO execute getUsers()

		/* System.out.println(csc.getUsers()); */

		// To execute PathVarTest() or reqstParamTest or createUsers() or updateUsers()
		/* User user=csc.pathVarTest(); */ 
		/* User user=csc.reqstParamTest(); */
		/* User user=csc.createUsers(); */
		/* User user=csc.updateUsers(); */
		/* User user=csc.reqstParamAndPathVar(100); */
		User user=csc.reqstParamAndMultiplePathVar( 100,"Pa");
		
		if (user != null && user.getFailureMessage()==null) {
			System.out.println("Successfully obtained the required User!");
			System.out.println("user details:"+user);
			//System.out.println("");
		} 
		else if(user != null && user.getFailureMessage()!=null) {
			System.out.println("fail msg:"+user.getFailureMessage());
		}
		else {
			System.out.println("Unable to obtain the required User");
		}

		// To execute deleteTest()
		/* csc.deleteTest(); */

	}
}

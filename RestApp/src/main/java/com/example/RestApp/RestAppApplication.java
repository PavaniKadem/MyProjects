package com.example.RestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RestAppApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		//RestAppController restAppController=new RestAppController();
		SpringApplication.run(RestAppApplication.class, args);
		//restAppController.getOutput();
	}

}

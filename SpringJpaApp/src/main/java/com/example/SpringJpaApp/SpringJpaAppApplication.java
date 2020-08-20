package com.example.SpringJpaApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.SpringJpaApp.entity.Comment;
import com.example.SpringJpaApp.entity.User;
import com.example.SpringJpaApp.repo.UserRepository;

@SpringBootApplication
public class SpringJpaAppApplication implements ApplicationRunner {
	@Autowired

	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAppApplication.class, args);
		System.out.println("SpringJpaAppApplication Started!");

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//User user = userRepository.findByUserID(1000);
		//User user = userRepository.usingQuery(1000);
		
		/*
		 * List<User> users=userRepository.findAll(); 
		 * User user=users.get(0);
		 */
		
		User u1=new User();
		u1.setUserID(1003);
		u1.setUserName("PAVANI");
		Comment c1=new Comment();
		c1.setCommentId("C123");
		c1.setTime("31-05-2020");
		c1.setData("very useful data");
		c1.setUser(u1);
		List<Comment> comments=new ArrayList<>();
		comments.add(c1);
		u1.setComment(comments);
		User user=userRepository.save(u1);
		if (user != null) {
			System.out.println("Successfull obtained the user");
			System.out.println("User Id:" + user.getUserID() + "\nUser name:" + user.getUserName() + "\nFirst comment:"
					+ user.getComment().get(0).getData());

		} else {
			System.out.println("Unable to fetch user");
		}
		boolean flag=userRepository.existsByUserName("pavani");
		if(flag) {
			System.out.println("~~~~~~~~working!~~~~~~~~~");
		}
		else {
			System.out.println("~~~~~~~~not working~~~~~~~");
		}

	}

}

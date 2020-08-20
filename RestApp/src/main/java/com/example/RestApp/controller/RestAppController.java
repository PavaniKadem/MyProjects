package com.example.RestApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApp.model.User;
import com.example.RestApp.service.UserService;

@RestController
@RequestMapping("/UserService")
public class RestAppController {
	UserService userService = new UserService();

	@RequestMapping("/test")
	public String getTest() {
		System.out.println("Inside test");
		return "HELLo WOrld";
	}

	@RequestMapping("/PathVarTest/{id}")
	public User getTheUser(@PathVariable(value = "id") Integer id) {
		System.out.println("Inside getTheUser");
		System.out.println("Required User's Id is:"+id);
		UserService userService = new UserService();
		List<User> users = userService.getUsers();
		System.out.println("list Size:" + users.size());
		for (User user : users) {
			if (user.getUserId() == id)
				return user;
		}
		return null;
	}

	@RequestMapping("/ReqParamTest")
	public User getDefaultUser(@RequestParam(value = "id", required = false, defaultValue = "101") Integer id) {
		System.out.println("Inside getDefaultUser");
		UserService userService = new UserService();
		List<User> users = userService.getUsers();
		System.out.println("list Size:" + users.size());
		for (User user : users) {
			if (user.getUserId() == id)
				return user;
		}
		return null;
	}

	@RequestMapping(value = "/RespEntityPostTest", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		System.out.println("addUser");
		// User user1=new User();
		boolean added = userService.addUsers(user);
		if (added) {
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/putTest/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		System.out.println("addUser");
		// User user1=new User();
		User updated = userService.updateUsers(id, user);

		return new ResponseEntity<User>(updated, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/deleteTest/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		System.out.println("inside deleteUser");
		boolean deleted = userService.deleteUsers(id);
		if (deleted) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	@RequestMapping("/pathVarAndParam/{id}")
	public User pathVarAndParam(@PathVariable("id") Integer id,
			@RequestParam(value = "transactionId", required = false, defaultValue = "12345") String tid) {
		System.out.println("Inside pathVarAndParam");
		UserService userService = new UserService();
		System.out.println("Obtained Txn id:"+tid);
		List<User> users = userService.getUsers();
		System.out.println("list Size:" + users.size());
	for (User user : users) {
			if (user.getUserId() == id)
				return user;
		}
		return null;
	}
	@RequestMapping("/pathVarAndMultipleParam/{id}/{name}")
	public ResponseEntity<User> pathVarAndMultipleParam(@PathVariable("id") Integer id,@PathVariable("name") String name,
			@RequestParam(value = "transactionId", required = false, defaultValue = "12345") String tid,
			@RequestParam(value = "deviceServiceType") String serviceType) {
		System.out.println("Inside pathVarAndParam");
		UserService userService = new UserService();
		System.out.println("Obtained Txn id:"+tid+"\n obtained service Type:"+serviceType);
		List<User> users = userService.getUsers();
		System.out.println("list Size:" + users.size());
		User user1=new User();
		for (User user : users) {
			if (user.getUserId() == id && name.equals("Pav"))
				return new ResponseEntity<User>(user,HttpStatus.OK);
			else if(user.getUserId() == id && !name.equals("Pav")){
				user1.setFailureMessage("DL-DB Service Error, please contact APLSUPIONIX");
				user1.setTranscationID(tid);
				return new ResponseEntity<User>(user1,HttpStatus.BAD_REQUEST);
			}
			else {
				return new ResponseEntity<User>(user,HttpStatus.BAD_GATEWAY);
			}
		}
		
		return null;
	}



}

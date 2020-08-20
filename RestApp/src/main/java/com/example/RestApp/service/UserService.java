package com.example.RestApp.service;

import java.util.ArrayList;
import java.util.List;

import com.example.RestApp.model.User;

public class UserService {
	List<User> users = new ArrayList<>();
	{
		User u1 = new User();
		u1.setUserId(100);
		u1.setUserName("PAVANI");
		User u2 = new User();
		u2.setUserId(101);
		u2.setUserName("RAMYA");
		users.add(u1);
		users.add(u2);
	}

	public List<User> getUsers() {

		return users;
	}

	public boolean addUsers(User user) {
		if (user != null && !user.equals("")) {
			users.add(user);
			return true;
		}
		return false;
	}
	public boolean deleteUsers(Integer userId) {
		boolean deleted=false;
		User deletable=new User();
		for(User user:users) {
			if(user.getUserId().equals(userId)) {
				deletable=user;
				deleted=true;
			}
		}
		deleted=users.remove(deletable);
		
		return deleted;
	}

	public User updateUsers(Integer Id,User user) {
		User updatable=new User();
		for(User u:users) {
			if(u.getUserId()==Id) {
				updatable=u;
			}
		}
		//updatable.setUserId(user.getUserId());
		updatable.setUserName(user.getUserName());
		return updatable;
	}
	
}

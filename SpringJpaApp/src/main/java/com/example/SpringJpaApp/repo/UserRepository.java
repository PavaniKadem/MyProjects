package com.example.SpringJpaApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SpringJpaApp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUserID(Integer userID);
	@Query("select u from User u where u.userID=(:userID)")
	User usingQuery(@Param("userID")Integer userID);
	boolean existsByUserName(String name);

}

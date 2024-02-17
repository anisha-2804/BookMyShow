package com.springboot.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bookmyshow.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.userEmail=?1 and u.userPassword=?2")
	public User userLogin(String userEmail,String userPassword);
}

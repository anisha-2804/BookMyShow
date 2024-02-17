package com.springboot.bookmyshow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.bookmyshow.entity.User;
import com.springboot.bookmyshow.repository.UserRepo;

@Repository
public class UserDao 
{
	@Autowired
	UserRepo userRepo;
	
	public User saveUser(User user)
	{
		return userRepo.save(user);
	}
	
	public User findUser(int userId)
	{
		Optional<User> opUser = userRepo.findById(userId);
		if(opUser.isPresent()) {
			return opUser.get();
		}
		return null;
	}
	
	public User deleteUser(int userId)
	{
		User user = findUser(userId);
		userRepo.delete(user);
		return user;
	}
	
	public User updateUser(User user,int userId)
	{
		User exUser = findUser(userId);
		if(exUser != null) {
			user.setUserId(userId);
			return userRepo.save(user);
		}
		return null;
	}
	
	public List<User> findAllUser()
	{
		List<User> users = userRepo.findAll();
		return users;
		
	}
	
	public User userLogin(String userEmail,String userPassword)
	{
		return userRepo.userLogin(userEmail, userPassword);
	}

}

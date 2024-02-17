package com.springboot.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookmyshow.dto.UserDto;
import com.springboot.bookmyshow.entity.User;
import com.springboot.bookmyshow.service.UserService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController 
{
	@Autowired
	UserService userService ;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(@RequestBody User user)
	{
		return userService.saveUser(user);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<UserDto>> findUser(@RequestParam int userId)
	{
		return userService.findUser(userId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(@RequestParam String userEmail,@RequestParam String userPassword,@RequestParam int userId)
	{
		return userService.deleteUser(userEmail, userPassword, userId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(@RequestParam String userEmail,@RequestParam String userPassword,@RequestBody User user,@RequestParam int userId)
	{
		return userService.updateUser(userEmail, userPassword, user, userId);
	}

}

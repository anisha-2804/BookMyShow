package com.springboot.bookmyshow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.UserDao;
import com.springboot.bookmyshow.dto.UserDto;
import com.springboot.bookmyshow.entity.User;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class UserService 
{
	@Autowired
	UserDao userDao;
	
	UserDto dto = new UserDto();
	ModelMapper mapper = new ModelMapper();
	
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(User user)
	{
		mapper.map(userDao.saveUser(user), dto);
		ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
		structure.setMessage("User data saved Successfully...");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> findUser(int userId)
	{
		User user = userDao.findUser(userId);
		ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
		if(user!=null)
		{
			mapper.map(user, dto);
			structure.setMessage("User Data Found...");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(int adminId)
	{
		User user = userDao.deleteUser(adminId);
		ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
		if(user!=null)
		{
			mapper.map(user, dto);
			structure.setMessage("User Data Deleted...");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(User user,int userId)
	{
		User user1 = userDao.updateUser(user, userId);
		ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
		if(user1!=null)
		{
			mapper.map(user1, dto);
			structure.setMessage("User Data Updated...");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> userLogin(String userEmail,String userPassword)
	{
		ResponseStructure<UserDto> structure = new ResponseStructure<UserDto>();
		List<User> userList = new ArrayList<User>();
		if(!userList.isEmpty())
		{
			for (User user : userList) {
				if (user.getUserEmail().equals(userEmail) && user.getUserPassword().equals(userPassword)) {
					mapper.map(user, dto);
					structure.setMessage("User Login Success...");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(dto);
					return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
				}
			}
		}
		return null;
	}

}

package com.springboot.bookmyshow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.AdminDao;
import com.springboot.bookmyshow.dao.UserDao;
import com.springboot.bookmyshow.dto.AdminDto;
import com.springboot.bookmyshow.entity.Admin;
import com.springboot.bookmyshow.entity.User;
import com.springboot.bookmyshow.exception.AdminNotFound;
import com.springboot.bookmyshow.exception.LoginFailed;
import com.springboot.bookmyshow.exception.UserNotFound;
import com.springboot.bookmyshow.util.ResponseStructure;


@Service
public class AdminService 
{
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	UserDao userDao;
	
	
	AdminDto dto = new AdminDto();
	ModelMapper mapper = new ModelMapper();
	
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(Admin admin)
	{
		mapper.map(adminDao.saveAdmin(admin), dto);
		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
		structure.setMessage("Admin data saved Successfully...");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> findAdmin(int adminId)
	{
		Admin admin = adminDao.findAdmin(adminId);
		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
		if(admin!=null)
		{
			mapper.map(admin, dto);
			structure.setMessage("Admin Data Found...");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.FOUND);
		}
		throw new AdminNotFound("Admin not Found with the given id...");
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(String adminEmail,String adminPassword,int adminId)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null) {
			Admin admin = adminDao.deleteAdmin(adminId);
			ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
			if(admin!=null)
			{
				mapper.map(admin, dto);
				structure.setMessage("Admin Data Deleted...");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
			}
			throw new AdminNotFound("Admin not Found with the given id...");
		}
		throw new LoginFailed("Admin Login Failed...");
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(String adminEmail,String adminPassword,Admin admin,int adminId)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null) {
			Admin admin1 = adminDao.updateAdmin(admin, adminId);
			ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
			if(admin1!=null)
			{
				mapper.map(admin1, dto);
				structure.setMessage("Admin Data Updated...");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
			}
			throw new AdminNotFound("Admin not Found with the given id...");
		}
		throw new LoginFailed("Admin Login Failed...");
	}
	
	public ResponseEntity<ResponseStructure<Admin>> assignUserToAdmin(String adminEmail,String adminPassword)
	{
		Admin admin = adminDao.adminLogin(adminEmail, adminPassword);
		if(admin!=null) {
			ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
			
			java.util.List<User> user= userDao.findAllUser();
			if(!user.isEmpty()) 
			{
				admin.setUsers(user);
				structure.setData(adminDao.updateAdmin(admin, admin.getAdminId()));
				structure.setMessage("User assigned....");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
			}
			throw new UserNotFound("user not Found with the given id..."); 
		}
		throw new LoginFailed("Admin Login Failed....");
		  
	}

	
	

}

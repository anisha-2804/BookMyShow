package com.springboot.bookmyshow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.AdminDao;
import com.springboot.bookmyshow.dto.AdminDto;
import com.springboot.bookmyshow.entity.Admin;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class AdminService 
{
	@Autowired
	AdminDao adminDao;
	
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
		return null;
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(int adminId)
	{
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
		return null;
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(Admin admin,int adminId)
	{
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
		return null;
	}
	
	public ResponseEntity<ResponseStructure<AdminDto>> adminLogin(String adminEmail,String adminPassword)
	{
		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
		List<Admin> adminList = new ArrayList<Admin>();
		if(!adminList.isEmpty())
		{
			for (Admin admin : adminList) {
				if (admin.getAdminEmail().equals(adminEmail) && admin.getAdminPassword().equals(adminPassword)) {
					mapper.map(admin, dto);
					structure.setMessage("Admin Login Success...");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(dto);
					return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
				}
			}
		}
		return null;
	}
	
	

}

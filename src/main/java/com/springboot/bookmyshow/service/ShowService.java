package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.AdminDao;
import com.springboot.bookmyshow.dao.ShowDao;
import com.springboot.bookmyshow.entity.Admin;
import com.springboot.bookmyshow.entity.Shows;
import com.springboot.bookmyshow.exception.LoginFailed;
import com.springboot.bookmyshow.exception.ShowNotFound;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class ShowService 
{
	@Autowired
	ShowDao showDao;
	
	@Autowired
	AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Shows>> saveShow(String adminEmail,String adminPassword,Shows show)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null)
		{
			ResponseStructure<Shows> structure = new ResponseStructure<Shows>();
			structure.setMessage("Save data Success...");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(showDao.saveShow(show));
			return new ResponseEntity<ResponseStructure<Shows>>(structure,HttpStatus.CREATED);
		}
		throw new LoginFailed("Admin Login Failed...");
	}
	
	public ResponseEntity<ResponseStructure<Shows>> findShow(int showId)
	{
		ResponseStructure<Shows> structure = new ResponseStructure<Shows>();
		Shows show = showDao.findShow(showId);
		if(show!=null)
		{
			structure.setMessage("Data Found...");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(show);
			return new ResponseEntity<ResponseStructure<Shows>>(structure,HttpStatus.FOUND);
		}
		throw new ShowNotFound("show not Found with the given id...");
	}
	
	public ResponseEntity<ResponseStructure<Shows>> deleteShow(String adminEmail,String adminPassword,int showId)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null)
		{
			ResponseStructure<Shows> structure = new ResponseStructure<Shows>();
			Shows show = showDao.deleteShow(showId);
			if(show!=null) {
				structure.setMessage("Data Deleted...");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(show);
				return new ResponseEntity<ResponseStructure<Shows>>(structure,HttpStatus.OK);
			}
			throw new ShowNotFound("show not Found with the given id...");
		}
		throw new LoginFailed("Admin Login Failed...");
	}
	
	public ResponseEntity<ResponseStructure<Shows>> updateShow(String adminEmail,String adminPassword,Shows show, int showId)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null)
		{
			ResponseStructure<Shows> structure = new ResponseStructure<Shows>();
			Shows exShow = showDao.updateShow(show, showId);
			if(exShow!=null)
			{
				structure.setMessage("Data Updated...");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(exShow);
				return new ResponseEntity<ResponseStructure<Shows>>(structure,HttpStatus.OK);
			}
			throw new ShowNotFound("show not Found with the given id...");
		}
		throw new LoginFailed("Admin Login Failed...");
	}

}

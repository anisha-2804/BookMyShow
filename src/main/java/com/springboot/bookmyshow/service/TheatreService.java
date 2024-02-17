package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.AdminDao;
import com.springboot.bookmyshow.dao.TheatreDao;
import com.springboot.bookmyshow.entity.Admin;
import com.springboot.bookmyshow.entity.Theatre;
import com.springboot.bookmyshow.exception.LoginFailed;
import com.springboot.bookmyshow.exception.TheatreNotFound;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class TheatreService 
{
	@Autowired
	TheatreDao theatreDao;
	
	@Autowired
	AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(String adminEmail,String adminPassword,Theatre theatre)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null)
		{
			ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
			structure.setMessage("Save data Success...");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(theatreDao.saveTheatre(theatre));
			return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.CREATED);
		}
		throw new LoginFailed("Admin Login Failed...");
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> findTheatre(int theatreId)
	{
		ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
		Theatre theatre = theatreDao.findTheatre(theatreId);
		if(theatre!=null)
		{
			structure.setMessage("Data Found...");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(theatre);
			return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.FOUND);
		}
		throw new TheatreNotFound("Theatre not Found with the given id...");
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(String adminEmail,String adminPassword,int theatreId)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null)
		{
			ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
			Theatre theatre = theatreDao.deleteTheatre(theatreId);
			if(theatre!=null) {
				structure.setMessage("Data Deleted...");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(theatre);
				return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
			}
			throw new TheatreNotFound("Theatre not Found with the given id...");
		}
		throw new LoginFailed("Admin Login Failed...");
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(String adminEmail,String adminPassword,Theatre theatre, int theatreId)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null)
		{
			ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
			Theatre exTheatre = theatreDao.updateTheatre(theatre, theatreId);
			if(exTheatre!=null)
			{
				structure.setMessage("Data Updated...");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(exTheatre);
				return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
			}
			throw new TheatreNotFound("Theatre not Found with the given id...");
		}
		throw new LoginFailed("Admin Login Failed...");
	}

}

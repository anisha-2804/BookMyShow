package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.AdminDao;
import com.springboot.bookmyshow.dao.SeatDao;
import com.springboot.bookmyshow.entity.Admin;
import com.springboot.bookmyshow.entity.Seat;
import com.springboot.bookmyshow.exception.LoginFailed;
import com.springboot.bookmyshow.exception.SeatNotFound;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class SeatService 
{
	@Autowired
	SeatDao seatDao;
	
	@Autowired
	AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(String adminEmail,String adminPassword,Seat seat)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null)
		{
			ResponseStructure<Seat> structure = new ResponseStructure<Seat>();
			structure.setMessage("Save data Success...");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(seatDao.saveSeat(seat));
			return new ResponseEntity<ResponseStructure<Seat>>(structure,HttpStatus.CREATED);
		}
		throw new LoginFailed("Admin Login Failed...");
	}
	
	public ResponseEntity<ResponseStructure<Seat>> findSeat(int seatId)
	{
		ResponseStructure<Seat> structure = new ResponseStructure<Seat>();
		Seat seat = seatDao.findSeat(seatId);
		if(seat!=null)
		{
			structure.setMessage("Data Found...");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(seat);
			return new ResponseEntity<ResponseStructure<Seat>>(structure,HttpStatus.FOUND);
		}
		throw new SeatNotFound("Seat not Found with the given id...");
	}
	
	public ResponseEntity<ResponseStructure<Seat>> deleteSeat(String adminEmail,String adminPassword,int seatId)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null) {
			ResponseStructure<Seat> structure = new ResponseStructure<Seat>();
			Seat seat = seatDao.deleteSeat(seatId);
			if(seat!=null) {
				structure.setMessage("Data Deleted...");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(seat);
				return new ResponseEntity<ResponseStructure<Seat>>(structure,HttpStatus.OK);
			}
			throw new SeatNotFound("Seat not Found with the given id...");
		}
		throw new LoginFailed("Admin Login Failed...");
	}
	
	public ResponseEntity<ResponseStructure<Seat>> updateSeat(String adminEmail,String adminPassword,Seat seat, int seatId)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null)
		{
			ResponseStructure<Seat> structure = new ResponseStructure<Seat>();
			Seat exSeat = seatDao.updateSeat(seat, seatId);
			if(exSeat!=null)
			{
				structure.setMessage("Data Updated...");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(exSeat);
				return new ResponseEntity<ResponseStructure<Seat>>(structure,HttpStatus.OK);
			}
			throw new SeatNotFound("Seat not Found with the given id...");
		}
		throw new LoginFailed("Admin Login Failed...");
	}

}

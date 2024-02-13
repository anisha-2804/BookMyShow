package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.SeatDao;
import com.springboot.bookmyshow.entity.Seat;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class SeatService 
{
	@Autowired
	SeatDao seatDao;
	
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(Seat seat)
	{
		ResponseStructure<Seat> structure = new ResponseStructure<Seat>();
		structure.setMessage("Save data Success...");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(seatDao.saveSeat(seat));
		return new ResponseEntity<ResponseStructure<Seat>>(structure,HttpStatus.CREATED);
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
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Seat>> deleteSeat(int seatId)
	{
		ResponseStructure<Seat> structure = new ResponseStructure<Seat>();
		Seat seat = seatDao.deleteSeat(seatId);
		if(seat!=null) {
			structure.setMessage("Data Deleted...");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(seat);
			return new ResponseEntity<ResponseStructure<Seat>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Seat>> updateSeat(Seat seat, int seatId)
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
		return null;
	}

}

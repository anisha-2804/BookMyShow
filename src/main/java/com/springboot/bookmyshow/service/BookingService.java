package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.BookingDao;
import com.springboot.bookmyshow.entity.Booking;
import com.springboot.bookmyshow.exception.BookingNotFound;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class BookingService 
{
	@Autowired
	BookingDao bookingDao;
	
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking)
	{
		ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
		structure.setMessage("Save data Success...");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(bookingDao.saveBooking(booking));
		return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Booking>> findBooking(int bookingId)
	{
		ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
		Booking booking = bookingDao.findBooking(bookingId);
		if(booking!=null)
		{
			structure.setMessage("Data Found...");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(booking);
			return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.FOUND);
		}
		throw new BookingNotFound("Booking not Found with the given id...Please Enter a valid booking Id");
	}
	
	public ResponseEntity<ResponseStructure<Booking>> CancelBooking(int bookingId)
	{
		ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
		Booking booking = bookingDao.deleteBooking(bookingId);
		if(booking!=null) {
			structure.setMessage("Ticket was Cancelled...");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(booking);
			return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.OK);
		}
		throw new BookingNotFound("Booking not Found with the given id...Please Enter a valid booking Id");
	}
	

}

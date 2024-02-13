package com.springboot.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookmyshow.entity.Booking;
import com.springboot.bookmyshow.service.BookingService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("booking")
public class BookingController 
{
	@Autowired
	BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Booking>> saveLaptop(@RequestBody Booking booking)
	{
		return bookingService.saveBooking(booking);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Booking>> findBooking(@RequestParam int bookingId)
	{
		return bookingService.findBooking(bookingId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Booking>> cancelBooking(@RequestParam int bookingId)
	{
		return bookingService.CancelBooking(bookingId);
	}
	

}

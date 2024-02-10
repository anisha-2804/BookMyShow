package com.springboot.bookmyshow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.bookmyshow.entity.Booking;
import com.springboot.bookmyshow.repository.BookingRepo;

public class BookingDao 
{
	@Autowired
	BookingRepo bookingRepo;
	

	public Booking saveBooking(Booking booking)
	{
		return bookingRepo.save(booking);
	}
	
	public Booking findBooking(int bookingId)
	{
		Optional<Booking> opBooking = bookingRepo.findById(bookingId);
		if(opBooking.isPresent()) {
			return opBooking.get();
		}
		return null;
	}
	
	public Booking deleteBooking(int bookingId)
	{
		Booking booking = findBooking(bookingId);
		bookingRepo.delete(booking);
		return booking;
	}
	
	public Booking updateBooking(Booking booking,int bookingId)
	{
		Booking exBooking = findBooking(bookingId);
		if(exBooking != null) {
			booking.setBookingId(bookingId);
			return bookingRepo.save(booking);
		}
		return null;
	}
	
}

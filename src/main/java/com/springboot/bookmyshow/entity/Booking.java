package com.springboot.bookmyshow.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;

@Entity
@Component
public class Booking 
{
	private int bookingId;
	private int bookingNoOfTicket;
	private double bookingPrice;
	private LocalDate bookingDate;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getBookingNoOfTicket() {
		return bookingNoOfTicket;
	}
	public void setBookingNoOfTicket(int bookingNoOfTicket) {
		this.bookingNoOfTicket = bookingNoOfTicket;
	}
	public double getBookingPrice() {
		return bookingPrice;
	}
	public void setBookingPrice(double bookingPrice) {
		this.bookingPrice = bookingPrice;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	

}

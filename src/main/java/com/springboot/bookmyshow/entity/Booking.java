package com.springboot.bookmyshow.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

@Entity
@Component
public class Booking 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@Positive(message = "enter a valid number of tickets")
	@Min(value = 1)
	@Max(value = 5)
	private int bookingNoOfTicket;
	
	@Positive(message = "enter a valid Price")
	private double bookingPrice;
	
	@DateTimeFormat(pattern = "yyyy/mm/dd")
	private LocalDate bookingDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Ticket> tickets;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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

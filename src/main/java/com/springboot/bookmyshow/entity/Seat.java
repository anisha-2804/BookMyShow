package com.springboot.bookmyshow.entity;

import org.springframework.stereotype.Component;

import com.springboot.bookmyshow.theatreEnum.SeatType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Component
public class Seat 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatId;
	
	@Positive
	private int noOfSeats;
	
	
	private SeatType seatType;
	
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	private Shows show;
	
	
	public Shows getShow() {
		return show;
	}
	public void setShow(Shows show) {
		this.show = show;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	

}

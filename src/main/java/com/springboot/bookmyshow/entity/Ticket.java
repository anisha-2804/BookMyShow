package com.springboot.bookmyshow.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Positive;

@Entity
@Component
public class Ticket 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	
	@Positive(message = "enter a valid Price")
	private double ticketPrice;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Shows show;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Shows getShow() {
		return show;
	}

	public void setShow(Shows show) {
		this.show = show;
	}

	
	
	

}

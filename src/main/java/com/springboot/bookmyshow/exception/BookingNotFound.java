package com.springboot.bookmyshow.exception;

public class BookingNotFound extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public BookingNotFound(String message) {
		this.message = message;
	}
	
	

}

package com.springboot.bookmyshow.exception;

public class LoginFailed extends RuntimeException 
{
	String message;

	public String getMessage() {
		return message;
	}

	public LoginFailed(String message) {
		this.message = message;
	}
	
	

}

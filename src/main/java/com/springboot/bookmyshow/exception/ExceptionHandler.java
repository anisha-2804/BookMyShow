package com.springboot.bookmyshow.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.bookmyshow.util.ResponseStructure;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;


@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler
{
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> adminNotFoundException(AdminNotFound ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Admin Does Not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> LoginFailedException(LoginFailed ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Login Failed");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> bookingNotFoundException(BookingNotFound ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Please Enter a valid booking Id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> movieNotFoundException(MovieNotFound ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Movie does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> SeatNotFoundException(SeatNotFound ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Seat does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> showNotFoundException(ShowNotFound ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Show does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> theatreNotFoundException(TheatreNotFound ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Theatre does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TicketNotFoundException(TicketNotFound ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Ticket does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userNotFoundException(UserNotFound ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("User does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex)
	{
		ResponseStructure<Object> structure = new ResponseStructure<Object>();
		Map<String, String> hashmap = new HashMap<String, String>();
		
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) 
		{
			String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			hashmap.put(field, message);
		}
		structure.setMessage("add Proper details");
		structure.setStatus(HttpStatus.FORBIDDEN.value());
		structure.setData(hashmap);
		return new ResponseEntity<Object>(structure,HttpStatus.BAD_REQUEST);
	}
}

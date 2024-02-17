package com.springboot.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookmyshow.entity.Seat;
import com.springboot.bookmyshow.service.SeatService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("seat")
public class SeatController 
{
	@Autowired
	SeatService seatService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestBody Seat seat)
	{
		return seatService.saveSeat(adminEmail, adminPassword, seat);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Seat>> findSeat(@RequestParam int seatId)
	{
		return seatService.findSeat(seatId);
	} 
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Seat>> deleteSeat(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestParam int seatId)
	{
		return seatService.deleteSeat(adminEmail, adminPassword, seatId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Seat>> updateSeat(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestBody Seat seat,@RequestParam int seatId)
	{
		return seatService.updateSeat(adminEmail, adminPassword, seat, seatId);
	}

}

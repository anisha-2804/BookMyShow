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

import com.springboot.bookmyshow.entity.Theatre;
import com.springboot.bookmyshow.service.TheatreService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("theatre")
public class TheatreController 
{
	@Autowired
	TheatreService theatreService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestBody Theatre theatre)
	{
		return theatreService.saveTheatre(adminEmail, adminPassword, theatre);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Theatre>> findTheatre(@RequestParam int theatreId)
	{
		return theatreService.findTheatre(theatreId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestParam int theatreId)
	{
		return theatreService.deleteTheatre(adminEmail, adminPassword, theatreId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestBody Theatre theatre,@RequestParam int theatreId)
	{
		return theatreService.updateTheatre(adminEmail, adminPassword, theatre, theatreId);
	}


}

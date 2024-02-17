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
import com.springboot.bookmyshow.entity.Shows;
import com.springboot.bookmyshow.service.ShowService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("show")
public class ShowController 
{
	@Autowired
	ShowService showService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Shows>> saveShow(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestBody Shows show)
	{
		return showService.saveShow(adminEmail, adminPassword, show);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Shows>> findShow(@RequestParam int showId)
	{
		return showService.findShow(showId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Shows>> deleteShow(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestParam int showId)
	{
		return showService.deleteShow(adminEmail, adminPassword, showId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Shows>> updateShow(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestBody Shows show,@RequestParam int showId)
	{
		return showService.updateShow(adminEmail, adminPassword, show, showId);
	}

}

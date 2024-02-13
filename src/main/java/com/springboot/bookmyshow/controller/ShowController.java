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

import com.springboot.bookmyshow.entity.Show;
import com.springboot.bookmyshow.service.ShowService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("show")
public class ShowController 
{
	@Autowired
	ShowService showService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Show>> saveShow(@RequestBody Show show)
	{
		return showService.saveShow(show);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Show>> findShow(@RequestParam int showId)
	{
		return showService.findShow(showId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Show>> deleteShow(@RequestParam int showId)
	{
		return showService.deleteShow(showId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Show>> updateShow(@RequestBody Show show,@RequestParam int showId)
	{
		return showService.updateShow(show, showId);
	}

}

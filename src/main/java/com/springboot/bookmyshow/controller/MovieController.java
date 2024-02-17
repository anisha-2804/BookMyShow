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

import com.springboot.bookmyshow.entity.Movie;
import com.springboot.bookmyshow.service.MovieService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("movie")
public class MovieController 
{
	@Autowired
	MovieService movieService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestBody Movie movie)
	{
		return movieService.saveMovie(adminEmail, adminPassword, movie);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Movie>> findMovie(@RequestParam int movieId)
	{
		return movieService.findMovie(movieId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Movie>> deleteMovie(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestParam int movieId)
	{
		return movieService.deleteMovie(adminEmail, adminPassword, movieId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Movie>> updateMovie(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestBody Movie movie,@RequestParam int movieId)
	{
		return movieService.updateMovie(adminEmail, adminPassword, movie, movieId);
	}

}

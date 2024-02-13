package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.MovieDao;
import com.springboot.bookmyshow.entity.Movie;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class MovieService 
{
	@Autowired
	MovieDao movieDao;
	
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(Movie movie)
	{
		ResponseStructure<Movie> structure = new ResponseStructure<Movie>();
		structure.setMessage("Movie was Saved...");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(movieDao.saveMovie(movie));
		return new ResponseEntity<ResponseStructure<Movie>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Movie>> findMovie(int movieId)
	{
		ResponseStructure<Movie> structure = new ResponseStructure<Movie>();
		Movie movie = movieDao.findMovie(movieId);
		if(movie!=null)
		{
			structure.setMessage("Data Found...");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(movie);
			return new ResponseEntity<ResponseStructure<Movie>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Movie>> deleteMovie(int movieId)
	{
		ResponseStructure<Movie> structure = new ResponseStructure<Movie>();
		Movie movie = movieDao.deleteMovie(movieId);
		if(movie!=null) {
			structure.setMessage("Data Deleted...");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(movie);
			return new ResponseEntity<ResponseStructure<Movie>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Movie>> updateMovie(Movie movie, int movieId)
	{
		ResponseStructure<Movie> structure = new ResponseStructure<Movie>();
		Movie exMovie = movieDao.updateMovie(movie, movieId);
		if(exMovie!=null)
		{
			structure.setMessage("Data Updated...");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(exMovie);
			return new ResponseEntity<ResponseStructure<Movie>>(structure,HttpStatus.OK);
		}
		return null;
	}

}

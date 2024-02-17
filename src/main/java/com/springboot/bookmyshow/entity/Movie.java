package com.springboot.bookmyshow.entity;

import java.time.LocalTime;
import org.springframework.stereotype.Component;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Component
public class Movie 
{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int movieId;
	
	@NotNull(message = "Movie title cannot be null")
	@NotBlank(message = "Movie title cannot be blank")
	private String movieTitle;
	
	@NotNull(message = "Movie genre cannot be null")
	@NotBlank(message = "Movie genre cannot be blank")
	private String movieGenre;
	private LocalTime movieDuration;
	private double movieRating;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Shows show;
	
	public Shows getShow() {
		return show;
	}
	public void setShow(Shows show) {
		this.show = show;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public LocalTime getMovieDuration() {
		return movieDuration;
	}
	public void setMovieDuration(LocalTime movieDuration) {
		this.movieDuration = movieDuration;
	}
	public double getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(double movieRating) {
		this.movieRating = movieRating;
	}
	
	
	

}

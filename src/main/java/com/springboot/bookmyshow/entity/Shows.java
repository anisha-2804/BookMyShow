package com.springboot.bookmyshow.entity;

import java.time.LocalTime;
import java.util.List;
import org.springframework.stereotype.Component;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Component
public class Shows
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showsId;
	private LocalTime showStartTime;
	private LocalTime showEndTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Movie movie;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Seat> seats;
	
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getShowId() {
		return showsId;
	}
	public void setShowId(int showId) {
		this.showsId = showId;
	}
	public LocalTime getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(LocalTime showStartTime) {
		this.showStartTime = showStartTime;
	}
	public LocalTime getShowEndTime() {
		return showEndTime;
	}
	public void setShowEndTime(LocalTime showEndTime) {
		this.showEndTime = showEndTime;
	}
	
	

}

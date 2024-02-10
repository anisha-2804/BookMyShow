package com.springboot.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.bookmyshow.entity.Theatre;
import com.springboot.bookmyshow.repository.TheatreRepo;

public class TheatreDao 
{
	@Autowired
	TheatreRepo theatreRepo;
	
	public Theatre saveTheatre(Theatre theatre)
	{
		return theatreRepo.save(theatre);
	}
	
	public Theatre findTheatre(int theatreId)
	{
		Optional<Theatre> opTheatre = theatreRepo.findById(theatreId);
		if(opTheatre.isPresent()) {
			return opTheatre.get();
		}
		return null;
	}
	
	public Theatre deleteTheatre(int theatreId)
	{
		Theatre theatre = findTheatre(theatreId);
		theatreRepo.delete(theatre);
		return theatre;
	}
	
	public Theatre updateTheatre(Theatre theatre,int theatreId)
	{
		Theatre exTheatre = findTheatre(theatreId);
		if(exTheatre != null) {
			theatre.setTheatreId(theatreId);
			return theatreRepo.save(theatre);
		}
		return null;
	}

}

package com.springboot.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.bookmyshow.entity.Show;
import com.springboot.bookmyshow.repository.ShowRepo;

public class ShowDao 
{
	@Autowired
	ShowRepo showRepo;
	
	public Show saveShow(Show show)
	{
		return showRepo.save(show);
	}
	
	public Show findShow(int showId)
	{
		Optional<Show> opShow = showRepo.findById(showId);
		if(opShow.isPresent()) {
			return opShow.get();
		}
		return null;
	}
	
	public Show deleteShow(int showId)
	{
		Show show = findShow(showId);
		showRepo.delete(show);
		return show;
	}
	
	public Show updateShow(Show show,int showId)
	{
		Show exShow = findShow(showId);
		if(exShow != null) {
			show.setShowId(showId);
			return showRepo.save(show);
		}
		return null;
	}

}

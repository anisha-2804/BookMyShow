package com.springboot.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springboot.bookmyshow.entity.Shows;
import com.springboot.bookmyshow.repository.ShowRepo;

@Repository
public class ShowDao 
{
	@Autowired
	ShowRepo showRepo;
	
	public Shows saveShow(Shows show)
	{
		return showRepo.save(show);
	}
	
	public Shows findShow(int showId)
	{
		Optional<Shows> opShow = showRepo.findById(showId);
		if(opShow.isPresent()) {
			return opShow.get();
		}
		return null;
	}
	
	public Shows deleteShow(int showId)
	{
		Shows show = findShow(showId);
		showRepo.delete(show);
		return show;
	}
	
	public Shows updateShow(Shows show,int showId)
	{
		Shows exShow = findShow(showId);
		if(exShow != null) {
			show.setShowId(showId);
			return showRepo.save(show);
		}
		return null;
	}

}

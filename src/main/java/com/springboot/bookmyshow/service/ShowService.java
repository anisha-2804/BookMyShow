package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.ShowDao;
import com.springboot.bookmyshow.entity.Show;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class ShowService 
{
	@Autowired
	ShowDao showDao;
	
	public ResponseEntity<ResponseStructure<Show>> saveShow(Show show)
	{
		ResponseStructure<Show> structure = new ResponseStructure<Show>();
		structure.setMessage("Save data Success...");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(showDao.saveShow(show));
		return new ResponseEntity<ResponseStructure<Show>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Show>> findShow(int showId)
	{
		ResponseStructure<Show> structure = new ResponseStructure<Show>();
		Show show = showDao.findShow(showId);
		if(show!=null)
		{
			structure.setMessage("Data Found...");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(show);
			return new ResponseEntity<ResponseStructure<Show>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Show>> deleteShow(int showId)
	{
		ResponseStructure<Show> structure = new ResponseStructure<Show>();
		Show show = showDao.deleteShow(showId);
		if(show!=null) {
			structure.setMessage("Data Deleted...");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(show);
			return new ResponseEntity<ResponseStructure<Show>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Show>> updateShow(Show show, int showId)
	{
		ResponseStructure<Show> structure = new ResponseStructure<Show>();
		Show exShow = showDao.updateShow(show, showId);
		if(exShow!=null)
		{
			structure.setMessage("Data Updated...");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(exShow);
			return new ResponseEntity<ResponseStructure<Show>>(structure,HttpStatus.OK);
		}
		return null;
	}

}

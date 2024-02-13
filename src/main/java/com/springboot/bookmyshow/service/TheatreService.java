package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.TheatreDao;
import com.springboot.bookmyshow.entity.Theatre;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class TheatreService 
{
	@Autowired
	TheatreDao theatreDao;
	
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre theatre)
	{
		ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
		structure.setMessage("Save data Success...");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(theatreDao.saveTheatre(theatre));
		return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> findTheatre(int theatreId)
	{
		ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
		Theatre theatre = theatreDao.findTheatre(theatreId);
		if(theatre!=null)
		{
			structure.setMessage("Data Found...");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(theatre);
			return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> deleteShow(int theatreId)
	{
		ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
		Theatre theatre = theatreDao.deleteTheatre(theatreId);
		if(theatre!=null) {
			structure.setMessage("Data Deleted...");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(theatre);
			return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> updateShow(Theatre theatre, int theatreId)
	{
		ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
		Theatre exTheatre = theatreDao.updateTheatre(theatre, theatreId);
		if(exTheatre!=null)
		{
			structure.setMessage("Data Updated...");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(exTheatre);
			return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
		}
		return null;
	}

}

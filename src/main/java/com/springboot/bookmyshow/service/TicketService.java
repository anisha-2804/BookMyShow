package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.AdminDao;
import com.springboot.bookmyshow.dao.TicketDao;
import com.springboot.bookmyshow.entity.Admin;
import com.springboot.bookmyshow.entity.Ticket;
import com.springboot.bookmyshow.exception.LoginFailed;
import com.springboot.bookmyshow.exception.TicketNotFound;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class TicketService 
{
	@Autowired
	TicketDao ticketDao;
	
	@Autowired
	AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(String adminEmail,String adminPassword,Ticket ticket)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null)
		{
			ResponseStructure<Ticket> structure = new ResponseStructure<Ticket>();
			structure.setMessage("Save data Success...");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(ticketDao.saveTicket(ticket));
			return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.CREATED);
		}
		throw new LoginFailed("Admin Login Failed...");
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> findTicket(int ticketId)
	{
		ResponseStructure<Ticket> structure = new ResponseStructure<Ticket>();
		Ticket ticket = ticketDao.findTicket(ticketId);
		if(ticket!=null)
		{
			structure.setMessage("Data Found...");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(ticket);
			return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.FOUND);
		}
		throw new TicketNotFound("Ticket not Found with the given id...");
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(String adminEmail,String adminPassword,int ticketId)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null)
		{
			ResponseStructure<Ticket> structure = new ResponseStructure<Ticket>();
			Ticket ticket = ticketDao.deleteTicket(ticketId);
			if(ticket!=null) {
				structure.setMessage("Data Deleted...");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(ticket);
				return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.OK);
			}
			throw new TicketNotFound("Ticket not Found with the given id...");
		}
		throw new LoginFailed("Admin Login Failed...");
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(String adminEmail,String adminPassword,Ticket ticket, int ticketId)
	{
		Admin exAdmin = adminDao.adminLogin(adminEmail, adminPassword);
		if(exAdmin!=null)
		{
			ResponseStructure<Ticket> structure = new ResponseStructure<Ticket>();
			Ticket exticket = ticketDao.updateTicket(ticket, ticketId);
			if(exticket!=null)
			{
				structure.setMessage("Data Updated...");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(exticket);
				return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.OK);
			}
			throw new TicketNotFound("ticket not Found with the given id...");
		}
		throw new LoginFailed("Admin Login Failed...");
	}

}

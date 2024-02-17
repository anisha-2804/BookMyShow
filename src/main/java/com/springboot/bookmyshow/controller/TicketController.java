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

import com.springboot.bookmyshow.entity.Ticket;
import com.springboot.bookmyshow.service.TicketService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("ticket")
public class TicketController 
{
	@Autowired
	TicketService ticketService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestBody Ticket ticket)
	{
		return ticketService.saveTicket(adminEmail, adminPassword, ticket);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Ticket>> findTicket(@RequestParam int ticketId)
	{
		return ticketService.findTicket(ticketId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestParam int ticketId)
	{
		return ticketService.deleteTicket(adminEmail, adminPassword, ticketId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestBody Ticket Ticket,@RequestParam int TicketId)
	{
		return ticketService.updateTicket(adminEmail, adminPassword, Ticket, TicketId);
	}

}

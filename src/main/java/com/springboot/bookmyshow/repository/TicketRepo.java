package com.springboot.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer>{

}

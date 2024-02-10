package com.springboot.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer>{

}

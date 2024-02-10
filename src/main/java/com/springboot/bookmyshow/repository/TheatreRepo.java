package com.springboot.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Theatre;

public interface TheatreRepo extends JpaRepository<Theatre, Integer>{

}

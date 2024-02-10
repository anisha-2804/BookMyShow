package com.springboot.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Show;

public interface ShowRepo extends JpaRepository<Show, Integer>{

}

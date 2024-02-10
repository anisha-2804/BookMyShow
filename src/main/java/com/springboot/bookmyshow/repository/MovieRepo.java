package com.springboot.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie,Integer>{

}

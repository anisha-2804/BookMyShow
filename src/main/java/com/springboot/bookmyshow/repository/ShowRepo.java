package com.springboot.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.bookmyshow.entity.Shows;

public interface ShowRepo extends JpaRepository<Shows, Integer>{

}

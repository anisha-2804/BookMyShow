package com.springboot.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}

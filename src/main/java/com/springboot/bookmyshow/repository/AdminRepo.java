package com.springboot.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>
{

}

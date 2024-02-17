package com.springboot.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bookmyshow.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>
{
	@Query("select a from Admin a where a.adminEmail=?1 and a.adminPassword=?2")
	public Admin adminLogin(String adminEmail,String adminPassword);

}

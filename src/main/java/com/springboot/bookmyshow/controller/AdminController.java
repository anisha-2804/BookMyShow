package com.springboot.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookmyshow.dto.AdminDto;
import com.springboot.bookmyshow.entity.Admin;
import com.springboot.bookmyshow.service.AdminService;
import com.springboot.bookmyshow.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("admin")
public class AdminController 
{
	@Autowired
	AdminService adminService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<AdminDto>> saveLaptop(@Valid @RequestBody Admin admin, BindingResult result)
	{
		return adminService.saveAdmin(admin);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<AdminDto>> findLaptop(@RequestParam int adminId)
	{
		return adminService.findAdmin(adminId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<AdminDto>> deleteLaptop(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestParam int adminId)
	{
		return adminService.deleteAdmin(adminEmail, adminPassword, adminId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<AdminDto>> updateLaptop(@RequestParam String adminEmail,@RequestParam String adminPassword,@Valid @RequestBody Admin admin,@RequestParam int adminId,BindingResult result)
	{
		return adminService.updateAdmin(adminEmail, adminPassword, admin, adminId);
	}
	
	@PutMapping("assignUserToAdmin")
	public ResponseEntity<ResponseStructure<Admin>> assignUserToAdmin(@RequestParam String adminEmail,@RequestParam String adminPassword)
	{
		return adminService.assignUserToAdmin(adminEmail, adminPassword);
	}

}

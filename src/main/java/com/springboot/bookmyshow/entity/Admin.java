package com.springboot.bookmyshow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Component
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	@NotNull(message = "Admin name cannot be null")
	@NotBlank(message = "Admin name cannot be blank")
	private String adminName;
	
	@NotNull(message = "Admin Email cannot be null")
	@NotBlank(message = "Admin Email cannot be blank")
	@Email(message = "Please Enter a valid email address")
	private String adminEmail;
	
	@NotNull(message = "Password cannot be null")
	@NotBlank(message = "Password cannot be blank")
	@Size(min=8,message = "Password must be at least 8 characters")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
			message = "Password must have at least 1 Digit, 1 Uppercase, 1 Lowercase and 1 Special character")
	private String adminPassword;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<User> users;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Theatre> theatres;
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Theatre> getTheatres() {
		return theatres;
	}
	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	
}

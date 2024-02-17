package com.springboot.bookmyshow.dto;

public class UserDto 
{
	private int userId;
	private String userName;
	private long userContact;
	private String userEmail;
	
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public long getUserContact() {
		return userContact;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	

}

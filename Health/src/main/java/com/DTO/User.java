package com.DTO;

import java.math.BigInteger;

public class User {
	private String userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private BigInteger userContact;
	private String userRole;
	private String userSec;
	private String userGender;
	public User(String userId, String userName, String userPassword, String userEmail,BigInteger userContact,
			String userRole,String userSec, String userGender) {
		//super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userRole = userRole;
		this.userSec=userSec;
		this.userGender = userGender;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public BigInteger getUserContact() {
		return userContact;
	}
	public void setUserContact(BigInteger userContact) {
		this.userContact = userContact;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserSec()
	{
		return this.userSec;
	}
	public void setUserSec(String userSec)
	{
		this.userSec=userSec;
	}
	
	

}

package com.DAO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.DTO.CollectionUtil;
import com.DTO.User;
import com.Service.Validation;

public class DataAccess {
	User u;

Scanner sc=new Scanner(System.in);
	public boolean register(String key,User u)
	{
		CollectionUtil.user.put(key, u);
		if(CollectionUtil.user.get(key).getUserName()!=null)
			return true;
	return false;
	}
	
	
	public boolean register1()
	{
		boolean g=false;
		System.out.println("Enter Your Name");

		String uname = sc.next();

		System.out.println("Enter Your Email");

		String uemail = sc.next();

		boolean checkemail = Validation.validateEmail(uemail);//validating Email
		if (checkemail) {
			System.out.println("Enter Password");
			String upass = sc.next();
			boolean checkpass = Validation.validatePass(upass);// validating password
			if (checkpass) {
				System.out.println("Cofirm Password");
				String confirmPass = sc.next();

				if (confirmPass.equals(upass)) {
					System.out.println("Enter  Phone Number");
					String upNumber = sc.next();
					boolean checkPn = Validation.validatePhoneN(upNumber);//validating phone number
					if (checkPn) {
						System.out.println("Enter your NICK/favourite sports name");
						String sec = sc.next();
						boolean checksec = Validation.validateSec(sec);
						if (checksec) {
							System.out.println("Select GENDER\n 1.Male\n 2.Female ");
							String ug = sc.next();
							BigInteger b = BigInteger.valueOf(Long.parseLong(upNumber));
							long count = 0;

							String key = "U" + (++count);
							if (ug == "1") {
								u = new User(key, uname, upass, uemail, b, "USER", sec, "Male");
								register(key, u);
								System.out.println(" You are successfully registered");
								System.out.println("You are redirected to LOGIN PAGE");
								userLogin();
								g=true;
								
							} else if (ug == "2") {
								u = new User(key, uname, upass, uemail, b, "USER", sec, "FeMale");
								register(key, u);
								System.out.println(" You are successfully registered");
								System.out.println("You are redirected to LOGIN PAGE");
								userLogin();
								g=true;
								
							} else {
								System.out.println("Wrong input");
							}
						} else {
							System.out.println(" please enter valid answer");
						}
					} else {
						System.out.println(" please  enter Valid phone Number");
					}
				} else {
					System.out.println("Password not Matched");
				}
			} else {
				System.out.println(" Enter valid Password");
			}

		} else {
			System.out.println("please enter valid EMAIL");
		}
		return g;

	}
	
	public boolean userLogin()
	{boolean g=false;
	System.out.println("        NOTE:ENTER 1. to LOG IN ADMIN");
	System.out.println("Enter Email");
	String uemail = sc.next();
	System.out.println("Enter Password");
	String upass = sc.next();
	for (User u : CollectionUtil.user.values()) {
		if (u.getUserEmail() == uemail) {
			if (u.getUserPassword() == upass) {
				if (u.getUserRole() == "USER") {
					System.out.println("You are successfully Logged In");
					System.out.println("MAKE APPOINTMENT");
					System.out.println("CHECK APPOITMENT STATUS");
					modules(u.getUserId());
					g=true;
				} else if (u.getUserRole() == "ADMIN") {
					System.out.println("ADMIN logged In");
					System.out.println("-----------------");
					System.out.println("Add Center");
					System.out.println("Remove Center");
					System.out.println("Add Test");
					System.out.println("Remove Test");
					modules(u.getUserId());
					g=true;
				}
			} else {
				System.out.println("Please Enter valid password");
			}
		} else {
			System.out.println("Please Enter valid Input");
		}

	}

	return g;}
	
	
	public boolean forgotpass(String userId)
	{boolean g=false;
		System.out.println(" Enter your Email");
		String uemail = sc.next();
		System.out.println("Enter your nick/favourite Sports");
		String usec = sc.next();
		for (User u : CollectionUtil.user.values()) {
			if (uemail.equals(u.getUserEmail())) {
				if (usec.equals(u.getUserSec())) {
					g=changePass(u.getUserId());
				} else {
					System.out.println("Your security answer is wrong ");
				}
			} else {
				System.out.println("EMAIL does not exists");
			}
		}

	return g;}
	
	public boolean changePass(String userId)
	{boolean g=false;
		System.out.println("Enter old PASSWORD");
		String userOpass = sc.next();
		if (userOpass.equals(CollectionUtil.user.get(userId).getUserPassword())) {
			System.out.println("Enter New PASSWORD");
			String userNpass = sc.next();
			boolean checkpass = Validation.validatePass(userNpass);
			if (checkpass) {
				System.out.println("Confirm PASSWORD");
				String userCpass = sc.next();
				if (userCpass.equals(userNpass)) {
					CollectionUtil.user.get(userId).setUserPassword(userNpass);
					System.out.println("Your PAssword changed Successfully");
					return true;
				} else {
					System.out.println(" new and confirm password should be same");
				}
			} else {
				System.out.println("Enter valid password to meet criteria");
			}
		} else {
			System.out.println("Old password is wrong");
		}


	return false;}
	public boolean updateProfile(String userId)
	{
		System.out.println("enter 1. to update your Email");
		System.out.println("enter 2. to upadte your phone number");
		System.out.println("enter 3. to update your Security Answer");
		String up=sc.next();
		switch (up) {
		case "1":
			System.out.println("Enter your new Email");
			String newEmail=sc.next();
			boolean checkE=Validation.validateEmail(newEmail);
			if(checkE)
			{
				
					CollectionUtil.user.get(userId).setUserEmail(newEmail);
					System.out.println("EMAIL Updated successfully");
					return true;
			}
			
			break;
		case "2":
			System.out.println("enter your new phone number");
			String newph=sc.next();
			boolean checkP=Validation.validatePhoneN(newph);
			if(checkP)
			{
			CollectionUtil.user.get(userId).setUserContact(BigInteger.valueOf(Long.parseLong(newph)));
			System.out.println("Phone Number updated successfully");
			return true;
			}
			else
			{
				System.out.println("Not valid Enter again");
			}
			break;
		case "3":
			System.out.println("enter your NEW NICK/favourite Sports name");
			String newsec=sc.next();
			boolean checkS=Validation.validateSec(newsec);
			if(checkS)
			{
				CollectionUtil.user.get(userId).setUserSec(newsec);
				System.out.println("Your response has been Updated");
				return true;
			}
			else
			{
				System.out.println("Not valid Enter again");
			}
			break;
		default:
			System.out.println("please select valid input");
			break;
		}
		return false;
		
	
	}
	
	
	public void modules(String userId)
	{
		System.out.println("Enter 1. to CHANGE PASSWORD");
		System.out.println("Enter 2. to Update Profile");
		System.out.println("Enter 3. to View Profile");
		String choice=sc.next();
		switch (choice) {
		case "1":
			changePass(userId);
			break;
		case "2":
			updateProfile(userId);
			break;
		case "3":
			ViewProfile(userId);
		default:
			System.out.println("Please enter valid Input");
			break;
		}
	}
	public boolean ViewProfile(String userId)
	{if(true) {
		System.out.println("Your DETAILS");
		User u=CollectionUtil.getDetails().get(userId);
		
			System.out.println("ID   : "+u.getUserId());
			System.out.println("NAME : "+u.getUserName());
			System.out.println("EMAIL: "+u.getUserEmail());
			System.out.println("phone Number : "+u.getUserContact());
			System.out.println("Role :"+u.getUserRole());
			System.out.println("Gender :"+u.getUserGender());
		return true;
	}return false;
		}
}




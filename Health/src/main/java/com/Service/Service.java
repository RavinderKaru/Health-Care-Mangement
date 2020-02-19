package com.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import com.DAO.DataAccess;
import com.DTO.CollectionUtil;
import com.DTO.User;

public class Service {
	Scanner sc = new Scanner(System.in);
	DataAccess d = new DataAccess();
	User u;
public boolean register(String key,User u)
{
	return d.register(key, u);
}
	public boolean userRegister() {//Registration details
			return d.register1();}

	public boolean userLogin() {
		return d.userLogin();
		
			}

	public boolean forgotpass(String userId) {
		return d.forgotpass(userId);
			}

	public boolean changePass(String userId) {
		return d.changePass(userId);
			}
	
	public boolean updateProfile(String userId)
	{return d.updateProfile(userId);
		}
	
	
	public boolean ViewProfile(String userId)
	{
	return d.ViewProfile(userId);
	}
	
}





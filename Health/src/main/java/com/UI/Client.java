package com.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.Service.Service;

public class Client {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Service ser=new Service();
			while(true) {
				System.out.println("*********WELCOME TO HEALTH CARE SYSTEM*********");
				System.out.println("==============MENU====================");
		        System.out.println("1. Sign Up ");
		        System.out.println("2. Sign In");
		        System.out.println("2. EXIT");
		        System.out.println("Enter your choice\n");
		        String choice;
				try {
					choice = br.readLine();
					switch (choice) {
					case "1":
						System.out.println("Welcome  USER Please fill your details");
						ser.userRegister();
						break;
					case "2":
							
						ser.userLogin();
						 System.exit(0);
		                   break;
		                   
		            default:
		            	  System.out.println("Invalid choice");
		            	  break;
			        }
				} catch (IOException e) {
					e.printStackTrace();
				}

		    }
	    }
	}



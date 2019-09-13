package com.revature.service;

import java.io.IOException;
import java.util.Scanner;
import com.revature.controller.Controller;
import com.revature.model.User;
import com.revature.repository.AddUserDAO;
import com.revature.repository.UserDAO;

public class UsernameAndPassword {
	public static User currentUser;

		// this method check user input for user name and password and
		// validate if they are correct or not and depends of result
		// Prompt to reenter or if is correct calling displayMenu Method
		// what display banking options
		public static  void usernameAndPassword() throws IOException {
			//User currentUser = null;
			String userName;
			String password;
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter Your Username: ");
			
			  userName = sc.next();
			  UserDAO userDAO = new AddUserDAO();
			  System.out.println("Enter Your Password: ");
			  password = sc.next();
	      if (userDAO.getUser(userName, password) != null) {
	    	  currentUser = userDAO.getUser(userName);
	    	  System.out.println(currentUser.firstName +" welcome to Bank App!");
	          Controller.displayMenu();	    	  							    	  				
		
	      } else {
			System.out.println("Not quite, try again...");
			usernameAndPassword();// if mismatch calling same method over and over			
		  }

	     			
			sc.close();
		}
	     	            
	     		
}
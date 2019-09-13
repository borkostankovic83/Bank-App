package com.revature.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.controller.Controller;
import com.revature.controller.MenuOptions;
import com.revature.model.User;
import com.revature.repository.AddUserDAO;
import com.revature.repository.UserDAO;

public class AddUser {
	private static Scanner sc = new Scanner(System.in);
	public static int id;
	public static String firstName;
	public static String lastName;
	public static String userName;
	public static String password;
	public static String accountType;
	public static float balance;
	public static ArrayList<User> users = new ArrayList<User>();
	
	
	public static void addNewUser() throws IOException {
		
		User newUser = new User( id,"Mike", "Peterson", "mike23", "12345", "Saving", 5000);
		users.add(newUser);
		boolean validInput;

		System.out.println("Enter a user information to register user");
		
		
			System.out.print("Enter First Name: ");
			firstName = sc.next();
			System.out.print("Enter Last Name: ");
			lastName = sc.next();
			System.out.print("Enter Username: ");
			userName = sc.next();
			System.out.print("Enter Password: ");
			password = sc.next();
			System.out.print("Enter Cheking or Saving: ");
			accountType = sc.next();
			System.out.print("Enter how much you want to deposit: ");
			do {
				validInput = true;
			if (sc.hasNextFloat())
				balance = sc.nextFloat();
			else
				validInput = false;
			if (!validInput) {
				System.out.println("\nIncorrect Input.");
				System.out.println("Enter a user information to register user");
				validInput = true;
			}
		} while (validInput == false);
		
			
			UserDAO userDAO = new AddUserDAO();
			userDAO.createUser(new User(id,firstName, lastName, userName, password, accountType, balance));
		users.add(new User(id, firstName, lastName, userName, password, accountType, balance));

		System.out.println("User been added Sucesfully! ");
		MenuOptions.menuOptions();

	}
	
}
package com.revature.controller;

import java.io.IOException;
import java.util.Scanner;
import com.revature.service.AddUser;
import com.revature.service.UsernameAndPassword;
public class MenuOptions {
	/**
	 * This is first menu what gives option for user 
	 * to log in or create account as well t quit.
	 * @throws IOException
	 */
	public static void menuOptions() throws IOException {
		Scanner in = new Scanner(System.in);

		do {//looping menu
			System.out.println(" ");
			System.out.println("1. Login User");
			System.out.println("2. Create Acount");
			System.out.println("3. Exit.");

			Controller.userChoice = in.nextLine();
			// When user input option decide where to go
			// if option not recognized go to default
			switch (Controller.userChoice) {
			case "1":
				// Calls method usernameAndPassword() in class UsernameAndPassword 
				//then validate user name and password.
				UsernameAndPassword.usernameAndPassword();
				break;
			case "2":
				// Call to class AdUser and method addNewUser
				//Prompt to put information in specific order to register.
				AddUser.addNewUser();
				break;
			case "3":
				//thanks Qc and Adam I learned how to use static primitives
				Controller.quit = true;
				System.out.println("Thank you for banking");
				break;
			default:
				System.err.println("Option not recognized");
				break;
			}

			//System.out.println();

		} while (!Controller.quit);//when variable quit is true quits
		in.close();

	}
}

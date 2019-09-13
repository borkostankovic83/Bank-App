package com.revature.controller;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.log4j.Logger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.revature.exception.FileNotFounException;
import com.revature.exception.TransactionFaildException;
import com.revature.model.Transaction;
import com.revature.model.User;
import com.revature.repository.AddUserDAO;
import com.revature.repository.TransDAO;
import com.revature.repository.TransaDAOImplemnt;
import com.revature.repository.UserDAO;
import com.revature.service.UsernameAndPassword;

public class Controller {
	public static Logger logger = Logger.getLogger(Controller.class);
	public static int id;
	public static double amount;
	public static String transactions;
	public static int user_id;
	static String userChoice;
	static boolean quit = false;
	static float balance = 0f;
	public static ArrayList<Transaction> transaction = new ArrayList<Transaction>();

	// In displayMenu method displays menu
	// and depends of user go to specific case where
	// determine what to do next
	public static void displayMenu() throws IOException {
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.println(" ");
			System.out.println("1. Deposit money.");
			System.out.println("2. Withdraw money.");
			System.out.println("3. Check balance.");
			System.out.println("0. Logout.");
			try {
			userChoice = in.next();}
			catch(NumberFormatException e)
			{
			    throw new IllegalArgumentException();
			}
			
			// When user input option decide where to go
			// if option not recognized go to default
			switch (userChoice) {
			case "1":
				
				System.out.print("Amount to deposit: ");
				try {
				amount = in.nextDouble();				
				deposit(amount);
				}catch (InputMismatchException e) {
					System.out.println("Cant deposit an nonumber!");
				}				
				break;
			case "2":
				System.out.print("Amount to withdraw: ");
				amount = in.nextDouble(); 
				try {
				withdraw(amount);
				}catch (TransactionFaildException e) {
				System.out.println(e.getMessage());
				}
				break;
			case "3":
				System.out.println("Your balance: $" 
						+ UsernameAndPassword.currentUser.balance);
				break;
			case "0":
				quit = true;
				in.close();
				break;
			default:
				System.err.println("Option not recognized");
				//logger.debug("Option not recognized");
				break;
			}

			//System.out.println();

		} while (!quit);
		in.close();
		System.out.println("Thank You for Banking!");
	}
	/**
	 *  Withdraw method takes care of logic 
	 * and subtract withdraws amount to previous amount.
	 * From there is updated to the database
	 */
	public static void withdraw(double amount) {
		if (amount <= 0 || amount > UsernameAndPassword.currentUser.balance)
			System.out.println("Withdrawal can't be completed.");				
		else {
			UsernameAndPassword.currentUser.balance -= amount;				
			UserDAO userDAO = new AddUserDAO();
			for(User u : userDAO.getUser()) {
				if(u.getUserName().equals(UsernameAndPassword.currentUser.userName)) {
					u.setBalance((float) UsernameAndPassword.currentUser.balance);
					userDAO.updateUser(u);
				}				
			}
			try {
			TransDAO transDAO = new TransaDAOImplemnt();
			user_id = UsernameAndPassword.currentUser.id;
			transactions = "$(" + amount + ") has been withdrawn.";
			
			transDAO.createTeansaction(new Transaction(id, transactions, user_id));
			transaction.add(new Transaction(id, transactions, user_id));
			}catch (TransactionFaildException e) {
				System.out.println("Sorry, cant acces DB");
				System.out.println("problemm = " + e.getMessage());
			}
			try {
				// BufferedWriter write to file i created
				//I used writter.append so every time i go back 
				//write at existing document at new line
				BufferedWriter writer = new BufferedWriter(
										//stores to specific location
				new FileWriter("C:\\Users\\Borko Stankovic\\Desktop\\testout.txt", true));
				writer.append("\n");//makes new line
				writer.append("$(" + amount + ") has been withdrawn.");
				writer.close();
			} catch (FileNotFounException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {				
				e.printStackTrace();
			}
			//System.out.println("$" + amount + " has been withdrawn.");
			logger.debug("$" + amount + " has been withdrawn.");
		}
		
	}
	/**
	 *  Deposit method takes care of logic 
	 * and add deposit amount to previous amount.
	 * From there is updated to the database
	 */
	private static void deposit(double amount) throws IOException {
		if (amount <= 0)
			System.out.println("Can't deposit nonpositive amount.");
		else {
			UsernameAndPassword.currentUser.balance += amount;
			UserDAO userDAO = new AddUserDAO();
			for(User u : userDAO.getUser()) {
				if(u.getUserName().equals(UsernameAndPassword.currentUser.userName)) {
					u.setBalance((float) UsernameAndPassword.currentUser.balance);
					userDAO.updateUser(u);
				}				
			}			
			
			try {
				// BufferedWriter write to file i created
				//I used writter.append so every time i go back 
				//write at existing document at new line
				BufferedWriter writer = new BufferedWriter(
										//stores to specific location
						new FileWriter("C:\\Users\\Borko Stankovic\\Desktop\\testout.txt", true));
				writer.append("\n");//makes new line
				writer.append("$" + amount + " has been deposited.");
				writer.close();
			} catch (FileNotFounException e) {
				System.out.println(e);
			}					
			// Logger prints to console and as well differently 
			//prints in logs file. So i don't need sysout anymore. 
			//System.out.println("$" + amount + " has been deposited.");
			logger.info("$" + amount + " has been deposited.");				
		}
		
	}

	

}

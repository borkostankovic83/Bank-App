package com.revature.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.revature.repository.TransDAO;
import com.revature.repository.TransaDAOImplemnt;

public class ViewAllMyTransactions {

	public static void main(String[] args) throws IOException {
		
		//String readTransaction = null;
		TransDAO transDAO = new TransaDAOImplemnt();
		//UsernameAndPassword.currentUser.id=1;
		while(transDAO.getTansaction(UsernameAndPassword.currentUser.getId())!=null) {
			System.out.println(transDAO.getTansaction(1));
		}
		
		
		
		FileReader fr = new FileReader("C:\\Users\\Borko Stankovic\\Desktop\\testout.txt");
		BufferedReader ReadFileBuffer = new BufferedReader(fr);
		// Read the text Written
		// using BufferedWriter
		int i = 1;
		String line = ReadFileBuffer.readLine();
		while(line != null) {	
			System.out.println(i + ".Transaction: " + line);
			i++;
			line = ReadFileBuffer.readLine();
		}
	 
		// Close the Readers
		ReadFileBuffer.close();
	}

	public static void allCurrentUserTransactions() {
		
			TransDAO transDAO = new TransaDAOImplemnt();
		
		while(transDAO.getTansaction(UsernameAndPassword.currentUser.id)!=null) {
					System.out.println(transDAO.getTansaction(UsernameAndPassword.currentUser.id));
				}
		
	}

}

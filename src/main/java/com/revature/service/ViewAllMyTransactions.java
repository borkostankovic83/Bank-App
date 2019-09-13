package com.revature.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewAllMyTransactions {

	public static void main(String[] args) throws IOException {
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

}

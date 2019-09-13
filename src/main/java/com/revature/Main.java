package com.revature;

import java.io.IOException;
import com.revature.controller.*;


/** @author Borko Stankovic 
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

	public static void main(String[] args) throws IOException  {
		System.out.println("Welcome to the Bank!");
		
		// Call to MenuOptions Class and menuOptions method
		MenuOptions.menuOptions();
		
	}
}

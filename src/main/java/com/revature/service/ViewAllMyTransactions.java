package com.revature.service;
import java.text.SimpleDateFormat;

import com.revature.model.Transaction;
import com.revature.repository.TransDAO;
import com.revature.repository.TransaDAOImplemnt;

public class ViewAllMyTransactions {
	
	/**
	 * here can look all transactions
	 */
	public static void allCurrentUserTransactions() {
		
		TransDAO transDAO = new TransaDAOImplemnt();
		//System.out.println(transDAO.getTransaction(1));
		for(Transaction t : transDAO.getTransaction()) {
			String s = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(t.last_updated);
			System.out.println(s + "  " + t.transactions );
			
		}			
	}

}





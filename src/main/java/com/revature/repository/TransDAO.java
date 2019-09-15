package com.revature.repository;

import com.revature.model.Transaction;

public interface TransDAO {

	Transaction getTansaction(int id);
	
	boolean createTransaction(Transaction t);
	
	boolean updateTransaction(Transaction t);

	boolean deleteTransaction(Transaction t);
}


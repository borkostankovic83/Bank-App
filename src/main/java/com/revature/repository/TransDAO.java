package com.revature.repository;

import com.revature.model.Transaction;

public interface TransDAO {

	Transaction getTansaction(int id);
	
	boolean createTeansaction(Transaction t);
	
	boolean updateTeansaction(Transaction t);

	boolean deleteTransaction(Transaction t);
}


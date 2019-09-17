package com.revature.repository;
import java.util.List;
import com.revature.model.Transaction;

public interface TransDAO {

	Transaction getTransaction(int id);
	
	boolean createTransaction(Transaction t);
	
	boolean updateTransaction(Transaction t);

	boolean deleteTransaction(Transaction t);

	List<Transaction> getTransaction();
}
package com.revature.model;
import java.util.Date;

public class Transaction {
	public int id;
	public String transactions;
	public int users_id;
	public Date last_updated;
	


	public Transaction(int id, String transactions, int users_id, Date timestamp) {
		super();
		this.id = id;
		this.transactions = transactions;
		this.users_id = users_id;
		this.last_updated = timestamp;
	}

	public Transaction(int id, String transactions, int users_id) {
		super();
		this.id = id;
		this.transactions = transactions;
		this.users_id = users_id;
	}

	public Transaction(int id, String transactions) {
		super();
		this.id = id;
		this.transactions = transactions;
	}
	public Transaction(int id) {
		super();
		this.id = id;
		 
	}

	/**
	 * @return the last_updated
	 */
	public Date getLast_updated() {
		return last_updated;
	}

	/**
	 * @param last_updated the last_updated to set
	 */
	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the transactions
	 */
	public String getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(String transactions) {
		this.transactions = transactions;
	}

	/**
	 * @return the users_id
	 */
	public int getUsers_id() {
		return users_id;
	}

	/**
	 * @param users_id the users_id to set
	 */
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactions=" + transactions + ", users_id=" + users_id + ", last_updated="
				+ last_updated + "]";
	}



	
}

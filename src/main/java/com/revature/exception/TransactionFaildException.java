package com.revature.exception;


public class TransactionFaildException extends RuntimeException{

	/**@author Borko Stankovic
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TransactionFaildException() {
		this("Transaction is not saved");
	}
	public TransactionFaildException(String message) {
		super(message);
	}
}

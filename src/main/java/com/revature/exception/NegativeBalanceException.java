package com.revature.exception;

public class NegativeBalanceException extends RuntimeException {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public NegativeBalanceException() {
			this("Can't deposit nonpositive amount.");
			
		}	
		public NegativeBalanceException(String message) {
			super(message);
			
		}	
}

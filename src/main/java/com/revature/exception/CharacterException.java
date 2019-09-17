package com.revature.exception;

public class CharacterException extends RuntimeException{
	
	/**
	 * @author Borko Stankovic
	 */
	private static final long serialVersionUID = 1L;
	public CharacterException() {
		this("Can't deposit characters.");
		
	}	
	public CharacterException(String message) {
		super(message);
		
	}
}

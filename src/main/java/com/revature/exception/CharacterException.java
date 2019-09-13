package com.revature.exception;

public class CharacterException extends RuntimeException{
	
	public CharacterException() {
		this("Can't deposit characters.");
		
	}	
	public CharacterException(String message) {
		super(message);
		
	}
}

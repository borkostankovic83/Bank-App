package com.revature.exception;

public class FileNotFounException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FileNotFounException() {
		this("File not found");
	}
	public FileNotFounException(String message) {
		super(message);
	}
}

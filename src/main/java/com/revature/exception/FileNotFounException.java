package com.revature.exception;

import java.io.IOException;

public class FileNotFounException extends IOException{
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

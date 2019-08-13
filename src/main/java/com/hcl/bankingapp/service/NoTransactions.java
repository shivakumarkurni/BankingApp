package com.hcl.bankingapp.service;

public class NoTransactions extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoTransactions(String message) {
		
		super(message);
		
	}

}

package com.hcl.bankingapp.global;

public class ExceptionPojo {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExceptionPojo(String message) {
		super();
		this.message = message;
	}

}

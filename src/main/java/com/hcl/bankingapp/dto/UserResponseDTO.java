package com.hcl.bankingapp.dto;

import java.io.Serializable;

public class UserResponseDTO implements Serializable {

	private Long accno;

	private String message;
	
	private int statusCode;
	

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Long getAccno() {
		return accno;
	}

	public void setAccno(Long accno) {
		this.accno = accno;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
package com.hcl.bankingapp.dto;

import java.io.Serializable;

public class PayeeDTO implements Serializable{
	private Long userId;
	private String userName;
	private Long accountNo;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	
	
}

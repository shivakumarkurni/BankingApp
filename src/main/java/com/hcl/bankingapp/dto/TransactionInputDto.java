package com.hcl.bankingapp.dto;

import java.io.Serializable;

import org.springframework.web.bind.annotation.RequestParam;

public class TransactionInputDto {

	/**
	 * 
	 */
	
	public Long fromaccount ;
	public  Long toaccount;
	public Double amount;
	public Long getFromaccount() {
		return fromaccount;
	}
	public void setFromaccount(Long fromaccount) {
		this.fromaccount = fromaccount;
	}
	public Long getToaccount() {
		return toaccount;
	}
	public void setToaccount(Long toaccount) {
		this.toaccount = toaccount;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	

}

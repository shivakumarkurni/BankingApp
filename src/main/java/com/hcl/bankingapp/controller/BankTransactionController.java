package com.hcl.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankingapp.dto.TransactionInputDto;
import com.hcl.bankingapp.exception.ErrorResponse;
import com.hcl.bankingapp.service.BankTransactionService;

@RestController
@CrossOrigin(allowedHeaders  = {"*","*/"}, origins = {"*","*/"})
public class BankTransactionController {
	@Autowired BankTransactionService bankTransactionService;
	
	
	@PostMapping("/transaction")
	public ResponseEntity<ErrorResponse> transaction(@RequestBody TransactionInputDto transactionInputDto){
		
	System.out.println("hii");
		return bankTransactionService.transaction(transactionInputDto.getFromaccount(),transactionInputDto.getToaccount(), transactionInputDto.getAmount());
	}


}

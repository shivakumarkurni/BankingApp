package com.hcl.bankingapp.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.bankingapp.controller.BankTransactionController;
import com.hcl.bankingapp.entity.Account;
import com.hcl.bankingapp.entity.Transactions;
import com.hcl.bankingapp.exception.BankException;
import com.hcl.bankingapp.exception.ErrorResponse;
import com.hcl.bankingapp.repository.AccountRepository;
import com.hcl.bankingapp.repository.TransactionsRepository;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {
	
	private static final Logger logger = LoggerFactory.getLogger(BankTransactionController.class);

	@Autowired 
	TransactionsRepository transactionsRepository;
	
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountRepository accountRepository2;

	@Override
	public ResponseEntity<ErrorResponse> transaction(Long fromaccount, Long toaccount, Double amount) {
		
		logger.info("entered into transaction service");
		
		List<Account> fromaccountData = accountRepository.findByAccountNo(fromaccount);
		
		if(fromaccountData.isEmpty())
			throw new BankException(fromaccount+" acount not existed");
		 
		List<Account> toaccountData = accountRepository2.findByAccountNo(toaccount);
		if(toaccountData.isEmpty())
			throw new BankException(toaccount+" acount not existed");
		
		if(fromaccountData.get(0).getBalance()<amount)
			throw new BankException("in sufficient balence");
		
		double fromAccountBalenceUpdate = fromaccountData.get(0).getBalance()-amount;
		double toAccountBalenceUpdate = toaccountData.get(0).getBalance()+amount;
		
		fromaccountData.get(0).setBalance(fromAccountBalenceUpdate);
		toaccountData.get(0).setBalance(toAccountBalenceUpdate);
		
		Transactions transactions=new Transactions();
		transactions.setAmount(amount);
		transactions.setDate(LocalDate.now());
		transactions.setFromAccount(fromaccount);
		transactions.setToAccount(toaccount);
		
		
		transactionsRepository.save(transactions);
		accountRepository.save(fromaccountData.get(0));
		accountRepository2.save(toaccountData.get(0));
		
		ErrorResponse error=new ErrorResponse();
		error.setMessage("succsess");
		return ResponseEntity.ok().body(error);

		
		
	}

}

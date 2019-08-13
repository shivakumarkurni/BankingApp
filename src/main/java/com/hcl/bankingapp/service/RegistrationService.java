package com.hcl.bankingapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankingapp.controller.BankTransactionController;
import com.hcl.bankingapp.entity.Account;
import com.hcl.bankingapp.entity.UserDetails;
import com.hcl.bankingapp.exception.BankException;
import com.hcl.bankingapp.repository.AccountRepository;
import com.hcl.bankingapp.repository.UserDetailsRepository;

@Service
public class RegistrationService {
	
	private static final Logger logger = LoggerFactory.getLogger(BankTransactionController.class);
	
	@Autowired
	UserDetailsRepository userdetailsrepository;

	@Autowired
	AccountRepository accountrepository;

	static long accno = 1000000;
	final Double balance = 20000.00;
 
	public long registerCustomer(UserDetails details) {
		
		logger.info("entered inot register service");

		UserDetails users = userdetailsrepository.findByUserName(details.getUserName());
		if (users != null){
			logger.error(details.getUserName() +"already exists");
			throw new BankException(details.getUserName() + " already existed");
		}
		UserDetails user = userdetailsrepository.save(details);
		accno++;
		Account acc = new Account();
		acc.setAccountNo(accno);
		acc.setBalance(balance);
		acc.setUserDetails(user);
		accountrepository.save(acc);
		return accno;

	}

	public List<UserDetails> getUsers() {
		return userdetailsrepository.findAll();
	}

	public List<Account> getAccountDetails() {
		return accountrepository.findAll();
	}

}

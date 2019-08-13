package com.hcl.bankingapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankingapp.dto.LoginDto;
import com.hcl.bankingapp.entity.Account;
import com.hcl.bankingapp.entity.Transactions;
import com.hcl.bankingapp.entity.UserDetails;
import com.hcl.bankingapp.exception.EnterValidCredentials;
import com.hcl.bankingapp.exception.UserNotFound;
import com.hcl.bankingapp.repository.AccountRepository;
import com.hcl.bankingapp.repository.TransactionsRepository;
import com.hcl.bankingapp.repository.UserDetailsRepository;
import com.hcl.bankingapp.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	TransactionsRepository transactionsRepository;

	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Transactions> userLogin(LoginDto loginDto) {

		List<Transactions> transactions = null;
		List<Account> accountlist = null;
		Account account = null;
		Long userId = 0L;
		
		String userName= loginDto.getUserName();
		String password=loginDto.getPassword();

		UserDetails userDetails = userDetailsRepository.findByUserName(userName);

		if (userDetails != null) {

			if ((userDetails.getUserName().equals(userName) && userDetails.getPassword().equals(password))) {

				userId = userDetails.getUserId();

				accountlist = accountRepository.findByUserDetails(userDetails);
				
				if(accountlist.isEmpty())
					throw new  UserNotFound("accounts are not existed");
					
					account=accountlist.get(0);
				
				
				transactions = transactionsRepository.getTransactionsByFromAccount(account.getAccountNo());

				return transactions;
			}

			else {
				throw new EnterValidCredentials("Please enter correct username or password");
			}
		} else {
			throw new UserNotFound("User does not exists");
		}

	}

}

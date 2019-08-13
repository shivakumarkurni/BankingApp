package com.hcl.bankingapp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankingapp.controller.BankTransactionController;
import com.hcl.bankingapp.dto.PayeeDTO;
import com.hcl.bankingapp.entity.Account;
import com.hcl.bankingapp.entity.UserDetails;
import com.hcl.bankingapp.repository.AccountRepository;
import com.hcl.bankingapp.repository.UserDetailsRepository;
import com.hcl.bankingapp.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
private static final Logger logger = LoggerFactory.getLogger(BankTransactionController.class);


@Autowired
UserDetailsRepository userDetailsRepository;

@Autowired 
AccountRepository accountRepository;

public List<PayeeDTO> getAllPayeeDetails(Long userId){
	
	logger.info("entered into payee details service");
	List<PayeeDTO> listPayeeDTOs = new ArrayList<PayeeDTO>();
	List<UserDetails> listUserDetails = userDetailsRepository.findAll();
	for (UserDetails userDetails : listUserDetails) {
			if(userDetails.getUserId()!=userId) {
			List<Account> accountList = accountRepository.findByUserDetails(userDetails);
			PayeeDTO payeeDTO = new PayeeDTO();
			payeeDTO.setAccountNo(accountList.get(0).getAccountNo());
			payeeDTO.setUserId(userDetails.getUserId());
			payeeDTO.setUserName(userDetails.getUserName());
			listPayeeDTOs.add(payeeDTO);
		}
	}
	return listPayeeDTOs;
}
}

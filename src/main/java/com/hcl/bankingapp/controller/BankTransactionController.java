package com.hcl.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankingapp.dto.PayeeDTO;
import com.hcl.bankingapp.dto.TransactionInputDto;
import com.hcl.bankingapp.dto.UserResponseDTO;
import com.hcl.bankingapp.entity.UserDetails;
import com.hcl.bankingapp.exception.ErrorResponse;
import com.hcl.bankingapp.service.BankTransactionService;
import com.hcl.bankingapp.service.RegistrationService;
import com.hcl.bankingapp.service.UserDetailsServiceImpl;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class BankTransactionController {
	@Autowired
	BankTransactionService bankTransactionService;

	@Autowired
	UserDetailsServiceImpl userDetailsImpl;

	@Autowired
	RegistrationService registerservice;
	
	
	@PostMapping("/transaction")
	public ResponseEntity<ErrorResponse> transaction(@RequestBody TransactionInputDto transactionInputDto) {
 
		return bankTransactionService.transaction(transactionInputDto.getFromaccount(),
				transactionInputDto.getToaccount(), transactionInputDto.getAmount());

	}

	@GetMapping("/getAll/{userId}")
	public ResponseEntity<List<PayeeDTO>> getAllPayeeDetails(@PathVariable("userId") Long userId) {
		List<PayeeDTO> success = userDetailsImpl.getAllPayeeDetails(userId);
		return new ResponseEntity<List<PayeeDTO>>(success, HttpStatus.OK);
	}
	
	
	
	
	@PostMapping("/save")
	public UserResponseDTO saveCustomer(@RequestBody UserDetails details){
		 long accno = registerservice.registerCustomer(details);
		  
		 UserResponseDTO response = new UserResponseDTO();
		 response.setAccno(accno);
		 response.setMessage("success");
		 return response;
	}

}

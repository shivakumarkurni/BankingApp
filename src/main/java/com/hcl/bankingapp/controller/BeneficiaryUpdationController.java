package com.hcl.bankingapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankingapp.dto.CommonResponseDTO;
import com.hcl.bankingapp.dto.BenificiaryUpdationDto;
import com.hcl.bankingapp.service.BenificiaryUpdationService;

/**
 * @author Shiva
 *
 */

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class BeneficiaryUpdationController {

	private static final Logger logger = LoggerFactory.getLogger(BeneficiaryUpdationController.class);

	@Autowired
	BenificiaryUpdationService beneficiaryUpdationService;

	@PutMapping("/fundtransfer/payee")
	public ResponseEntity<CommonResponseDTO> beneficiaryUpdation(
			@RequestBody BenificiaryUpdationDto benificiaryUpdationDto) {

		logger.info("Inside BeneficiaryUpdationController");

		return new ResponseEntity<>(beneficiaryUpdationService.benificiaryUpdation(benificiaryUpdationDto),
				HttpStatus.OK);

	}

}

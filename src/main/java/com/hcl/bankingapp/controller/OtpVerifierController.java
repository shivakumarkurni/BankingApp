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
import com.hcl.bankingapp.dto.OtpVerifierDTO;
import com.hcl.bankingapp.service.OtpVerification;

/**
 * @author Shiva
 *
 */

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class OtpVerifierController {

	private static final Logger logger = LoggerFactory.getLogger(BeneficiaryUpdationController.class);

	@Autowired
	OtpVerification otpVerification;

	@PutMapping("/fundtransfer/payee/authentication")
	public ResponseEntity<CommonResponseDTO> otpVerifier(@RequestBody OtpVerifierDTO otpVerifierDTO) {

		logger.info(
				"Inside Otp verifierController:" + otpVerifierDTO.getUserId() + "-------" + otpVerifierDTO.getOtp());

		return new ResponseEntity<>(otpVerification.otpVerifier(otpVerifierDTO), HttpStatus.OK);

	}

}

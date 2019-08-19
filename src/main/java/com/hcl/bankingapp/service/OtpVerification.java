package com.hcl.bankingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankingapp.dto.ResponseDto;
import com.hcl.bankingapp.entity.Beneficiary;
import com.hcl.bankingapp.repository.BenificiaryUpdationRepository;
import com.hcl.bankingapp.repository.OtpVerificationRepository;

@Service
public class OtpVerification {

	@Autowired
	OtpVerificationRepository otpVerificationRepository;

	@Autowired
	BenificiaryUpdationRepository benificiaryUpdationRepository;

	public ResponseDto otpVerifier() {

		ResponseDto responseDto = new ResponseDto();

		Long user = 1L;
		List<Beneficiary> beneficiary = benificiaryUpdationRepository.findByUserDetails(user);

		for (Beneficiary beneficiary2 : beneficiary) {

		}
		return responseDto;

	}

}

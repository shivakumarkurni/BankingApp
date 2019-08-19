package com.hcl.bankingapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankingapp.dto.CommonResponseDTO;
import com.hcl.bankingapp.dto.OtpVerifierDTO;

import com.hcl.bankingapp.entity.Beneficiary;
import com.hcl.bankingapp.entity.BeneficiaryStatus;
import com.hcl.bankingapp.entity.Otp;
import com.hcl.bankingapp.entity.UserDetails;
import com.hcl.bankingapp.repository.BeneficiaryStatusRepository;
import com.hcl.bankingapp.repository.BenificiaryUpdationRepository;
import com.hcl.bankingapp.repository.OtpVerificationRepository;

/**
 * @author Shiva
 *
 */
@Service
public class OtpVerification {

	private static final Logger logger = LoggerFactory.getLogger(OtpVerification.class);

	@Autowired
	OtpVerificationRepository otpVerificationRepository;

	@Autowired
	BenificiaryUpdationRepository benificiaryUpdationRepository;

	@Autowired
	BeneficiaryStatusRepository beneficiaryStatusRepository;

	public CommonResponseDTO otpVerifier(OtpVerifierDTO otpVerifierDTO) {

		Integer otp = otpVerifierDTO.getOtp();
		Integer userId = otpVerifierDTO.getUserId();

		logger.info("Inside otpVerifier service");

		CommonResponseDTO responseDto = new CommonResponseDTO();

		List<Beneficiary> beneficiary = benificiaryUpdationRepository.findByUserId(userId);

		for (Beneficiary beneficiary2 : beneficiary) {

			Integer statusId = beneficiary2.getStatusId();

			BeneficiaryStatus beneficiaryStatus = beneficiaryStatusRepository.findById(statusId).get();

			String status = beneficiaryStatus.getStatus();

			if (status.equals("not verified")) {

				List<Otp> otps = otpVerificationRepository.findByBeneficiaryId(beneficiary2.getBeneficiaryId());

				if (otp.equals(otps.get(0).getOtp())) {

					responseDto.setMessage("Your OTP is verified");
					beneficiaryStatus.setStatus("verified");
					beneficiaryStatusRepository.save(beneficiaryStatus);
				}

				else {
					responseDto.setMessage("Your OTP is incorrect");
				}

			}

		}
		return responseDto;

	}

}

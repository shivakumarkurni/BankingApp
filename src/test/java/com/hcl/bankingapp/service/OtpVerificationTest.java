package com.hcl.bankingapp.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bankingapp.dto.CommonResponseDTO;
import com.hcl.bankingapp.dto.OtpVerifierDTO;
import com.hcl.bankingapp.entity.Beneficiary;
import com.hcl.bankingapp.entity.BeneficiaryStatus;
import com.hcl.bankingapp.entity.Otp;
import com.hcl.bankingapp.repository.BeneficiaryStatusRepository;
import com.hcl.bankingapp.repository.BenificiaryUpdationRepository;
import com.hcl.bankingapp.repository.OtpVerificationRepository;

@RunWith(MockitoJUnitRunner.class)
public class OtpVerificationTest {

	@Mock
	OtpVerificationRepository otpVerificationRepository;

	@Mock
	BenificiaryUpdationRepository benificiaryUpdationRepository;

	@Mock
	BeneficiaryStatusRepository beneficiaryStatusRepository;

	@InjectMocks
	OtpVerification otpVerification;

	OtpVerifierDTO otpVerifierDTO;

	Beneficiary beneficiary;

	Beneficiary beneficiary1;

	List<Beneficiary> benificiaryList;

	BeneficiaryStatus beneficiaryStatus;

	Otp otp;
	Otp otp1;

	List<Otp> otpList = new ArrayList<>();

	CommonResponseDTO responseDto;

	@Before
	public void setup() {
		otpVerifierDTO = new OtpVerifierDTO();

		benificiaryList = new ArrayList<>();

		beneficiaryStatus = new BeneficiaryStatus();

		otp = new Otp();
		otp1 = new Otp();
		responseDto = new CommonResponseDTO();

		otpVerifierDTO.setOtp(123);
		otpVerifierDTO.setUserId(1);

		beneficiary = new Beneficiary();
		beneficiary.setUserId(1);
		beneficiary.setName("arjun");
		beneficiary.setMobile(9030853295L);
		beneficiary.setIfscCode("ICIC000037");
		beneficiary.setEmail("raja@Gmail.com");
		beneficiary.setCreatedDate(LocalDateTime.now());
		beneficiary.setBeneficiaryId(1);
		beneficiary.setAccountNumber(1234L);
		beneficiary.setStatusId(1);

		beneficiary1 = new Beneficiary();
		beneficiary1.setUserId(1);
		beneficiary1.setName("arjun");
		beneficiary1.setMobile(9030853295L);
		beneficiary1.setIfscCode("ICIC000037");
		beneficiary1.setEmail("raja@Gmail.com");
		beneficiary1.setCreatedDate(LocalDateTime.now());
		beneficiary1.setBeneficiaryId(1);
		beneficiary1.setAccountNumber(1234L);
		beneficiary1.setStatusId(2);

		benificiaryList.add(beneficiary);
		benificiaryList.add(beneficiary1);

		beneficiaryStatus.setStatusId(1);
		beneficiaryStatus.setStatus("not verified");

		otp.setOtpId(1);
		otp.setOtp(123);
		otp.setBeneficiaryId(1);
		otp.setOtpCreatedDate(LocalDateTime.now());

		otp1.setOtpId(1);
		otp1.setOtp(234);
		otp1.setBeneficiaryId(1);
		otp1.setOtpCreatedDate(LocalDateTime.now());

		otpList.add(otp);
		otpList.add(otp1);

		responseDto.setMessage("Your OTP is verified");
		responseDto.setStatusCode(201);
	}

	@Test
	public void testOtpVerifier() {

		Integer otp = otpVerifierDTO.getOtp();
		Integer userId = otpVerifierDTO.getUserId();

		Mockito.when(benificiaryUpdationRepository.findByUserId(userId)).thenReturn(benificiaryList);

		Mockito.when(beneficiaryStatusRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(beneficiaryStatus));

		Mockito.when(otpVerificationRepository.findByBeneficiaryId(Mockito.anyInt())).thenReturn(otpList);

		CommonResponseDTO actualValue = otpVerification.otpVerifier(otpVerifierDTO);
		assertEquals(responseDto.getMessage(), actualValue.getMessage());

	}

	@Test
	public void testOtpVerifierNegitive() {

		List<Beneficiary> benificiaryList;

		BeneficiaryStatus beneficiaryStatus;

		List<Otp> otpList = new ArrayList<>();

		CommonResponseDTO responseDto;

		OtpVerifierDTO otpVerifierDTO = new OtpVerifierDTO();

		benificiaryList = new ArrayList<>();

		beneficiaryStatus = new BeneficiaryStatus();

		Otp otp = new Otp();
		Otp otp1 = new Otp();
		responseDto = new CommonResponseDTO();

		otpVerifierDTO.setOtp(123);
		otpVerifierDTO.setUserId(1);

		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setUserId(1);
		beneficiary.setName("arjun");
		beneficiary.setMobile(9030853295L);
		beneficiary.setIfscCode("ICIC000037");
		beneficiary.setEmail("raja@Gmail.com");
		beneficiary.setCreatedDate(LocalDateTime.now());
		beneficiary.setBeneficiaryId(1);
		beneficiary.setAccountNumber(1234L);
		beneficiary.setStatusId(1);

		Beneficiary beneficiary1 = new Beneficiary();
		beneficiary1.setUserId(1);
		beneficiary1.setName("arjun");
		beneficiary1.setMobile(9030853295L);
		beneficiary1.setIfscCode("ICIC000037");
		beneficiary1.setEmail("raja@Gmail.com");
		beneficiary1.setCreatedDate(LocalDateTime.now());
		beneficiary1.setBeneficiaryId(2);
		beneficiary1.setAccountNumber(1234L);
		beneficiary1.setStatusId(2);

		benificiaryList.add(beneficiary);
		benificiaryList.add(beneficiary1);

		beneficiaryStatus.setStatusId(2);
		beneficiaryStatus.setStatus("not verified");

		otp.setOtpId(1);
		otp.setOtp(234);
		otp.setBeneficiaryId(1);
		otp.setOtpCreatedDate(LocalDateTime.now());

		otp1.setOtpId(1);
		otp1.setOtp(234);
		otp1.setBeneficiaryId(1);
		otp1.setOtpCreatedDate(LocalDateTime.now());

		otpList.add(otp);
		otpList.add(otp1);

		responseDto.setMessage("Your OTP is incorrect");
		responseDto.setStatusCode(201);

		Integer otpId = otpVerifierDTO.getOtp();
		Integer userId = otpVerifierDTO.getUserId();

		Mockito.when(benificiaryUpdationRepository.findByUserId(userId)).thenReturn(benificiaryList);

		Mockito.when(beneficiaryStatusRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(beneficiaryStatus));

		Mockito.when(otpVerificationRepository.findByBeneficiaryId(Mockito.anyInt())).thenReturn(otpList);

		CommonResponseDTO actualValue = otpVerification.otpVerifier(otpVerifierDTO);
		assertEquals(responseDto.getMessage(), actualValue.getMessage());

	}

}

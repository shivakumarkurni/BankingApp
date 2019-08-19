package com.hcl.bankingapp.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.bankingapp.dto.BenificiaryUpdationDto;
import com.hcl.bankingapp.dto.CommonResponseDTO;
import com.hcl.bankingapp.dto.EmailDto;
import com.hcl.bankingapp.entity.Beneficiary;
import com.hcl.bankingapp.repository.BenificiaryUpdationRepository;

/**
 * @author Shiva
 *
 */

@Service
public class BenificiaryUpdationService {

	private static final Logger logger = LoggerFactory.getLogger(BenificiaryUpdationService.class);

	@Autowired
	BenificiaryUpdationRepository benificiaryUpdationRepository;

	public CommonResponseDTO benificiaryUpdation(BenificiaryUpdationDto benificiaryUpdationDto) {

		logger.info("Beneficiary updation service:" + benificiaryUpdationDto.getAccountNumber());

		CommonResponseDTO responseDTO = new CommonResponseDTO();

		Beneficiary benificiary = new Beneficiary();

		org.springframework.beans.BeanUtils.copyProperties(benificiaryUpdationDto, benificiary);

		Long accountNumber = benificiary.getAccountNumber();

		List<Beneficiary> beneficiries = benificiaryUpdationRepository.findByAccountNumber(accountNumber);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Integer> otpResponse = restTemplate.exchange("http://10.117.189.248:9090/bankUtility/otp",
				HttpMethod.GET, entity, Integer.class);
		int otp = otpResponse.getBody().intValue();
		System.out.println("otp " + otp);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		EmailDto emailDto = new EmailDto();
		emailDto.setEmailId("vlaxman926@gmail.com");
		emailDto.setSubject("OTP for Account");
		emailDto.setTextBody("Dear Sir/madam, \n This is yout OTP " + otp + ",\n Please don't share.");
		HttpEntity<EmailDto> emailDtoEntity = new HttpEntity<>(emailDto, httpHeaders);
		ResponseEntity<String> mailResponse = restTemplate.exchange("http://10.117.189.248:9090/bankUtility/email",
				HttpMethod.POST, emailDtoEntity, String.class);
		Beneficiary benificies = beneficiries.get(0);
		benificies.setName(benificiary.getName());

		if (benificiaryUpdationRepository.save(benificies) != null) {

			responseDTO.setMessage("Updated Successfully");
			responseDTO.setStatusCode(201);

			return responseDTO;
		}

		else {

			responseDTO.setMessage("Couldn't able to update");
			responseDTO.setStatusCode(403);
			return responseDTO;
		}

	}

}

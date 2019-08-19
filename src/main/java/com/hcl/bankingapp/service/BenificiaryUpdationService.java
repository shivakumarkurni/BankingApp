package com.hcl.bankingapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankingapp.dto.BenificiaryUpdationDto;
import com.hcl.bankingapp.entity.Beneficiary;
import com.hcl.bankingapp.repository.BenificiaryUpdationRepository;


@Service
public class BenificiaryUpdationService {
	
	private static final Logger logger = LoggerFactory.getLogger(BenificiaryUpdationService.class);
	
	@Autowired
	BenificiaryUpdationRepository benificiaryUpdationRepository;
	
	public String benificiaryUpdation(BenificiaryUpdationDto benificiaryUpdationDto) {
		
		Beneficiary benificiary=new Beneficiary();
		
		
		org.springframework.beans.BeanUtils.copyProperties(benificiaryUpdationDto, benificiary);
		
		benificiaryUpdationRepository.save(benificiary);
		
		return "";
		
		
		
	}
	
	

}

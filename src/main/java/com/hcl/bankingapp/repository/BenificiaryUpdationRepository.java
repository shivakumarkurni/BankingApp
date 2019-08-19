package com.hcl.bankingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingapp.entity.Beneficiary;


public interface BenificiaryUpdationRepository extends JpaRepository<Beneficiary, Integer> {
	
	List<Beneficiary> findByUserId(Integer long1);
	
	List<Beneficiary> findByAccountNumber(Long accountNumber);

}

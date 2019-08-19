package com.hcl.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingapp.entity.BeneficiaryStatus;

public interface BeneficiaryStatusRepository extends JpaRepository<BeneficiaryStatus, Integer> {

}

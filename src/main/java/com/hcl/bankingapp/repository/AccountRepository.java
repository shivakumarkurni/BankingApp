package com.hcl.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingapp.entity.Account;
import com.hcl.bankingapp.entity.UserDetails;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Account findByUserDetails(UserDetails userDetails);

}

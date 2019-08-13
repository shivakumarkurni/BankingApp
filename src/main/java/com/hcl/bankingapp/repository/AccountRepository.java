package com.hcl.bankingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingapp.entity.Account;
import com.hcl.bankingapp.entity.UserDetails;

public interface AccountRepository extends JpaRepository<Account, Long> {
	



	
	public List<Account> findByAccountNo(Long accountno);
	
	


	public List<Account> findByUserDetails(UserDetails userDetails);

}

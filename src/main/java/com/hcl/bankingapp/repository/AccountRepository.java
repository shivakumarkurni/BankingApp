package com.hcl.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingapp.entity.Account;
import java.lang.Long;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	public List<Account> findByAccountNo(Long accountno);

}

package com.hcl.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}

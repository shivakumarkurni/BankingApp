package com.hcl.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingapp.entity.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

}

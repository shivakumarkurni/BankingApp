package com.hcl.bankingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.bankingapp.entity.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
	

	@Query(value="select * FROM transactions u where u.from_account=:fromAccount order by u.date DESC",nativeQuery=true )
	 List<Transactions> getTransactionsByFromAccount(@Param ("fromAccount")Long fromAccount);
	

	

}

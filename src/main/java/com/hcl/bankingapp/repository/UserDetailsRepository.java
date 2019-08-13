package com.hcl.bankingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingapp.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
	

	public UserDetails findByUserName(String userName);

}

package com.hcl.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bankingapp.entity.Otp;

public interface OtpVerificationRepository extends JpaRepository<Otp, Integer> {

}

package com.hcl.bankingapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.bankingapp.dto.LoginDto;
import com.hcl.bankingapp.entity.Transactions;

@Service
public interface UserLoginService {
	
	public List<Transactions> userLogin(LoginDto loginDto);

}

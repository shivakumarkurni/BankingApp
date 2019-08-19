package com.hcl.bankingapp.dto;

import java.io.Serializable;

public class OtpVerifierDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Integer otp;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

}

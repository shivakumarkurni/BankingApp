package com.hcl.bankingapp.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Otp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer otpId;
	private Integer beneficiaryId;

	private Integer otp;
	private LocalDateTime otpCreatedDate;

	public Integer getOtpId() {
		return otpId;
	}

	public void setOtpId(Integer otpId) {
		this.otpId = otpId;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public LocalDateTime getOtpCreatedDate() {
		return otpCreatedDate;
	}

	public void setOtpCreatedDate(LocalDateTime otpCreatedDate) {
		this.otpCreatedDate = otpCreatedDate;
	}

	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

}

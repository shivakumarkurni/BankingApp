package com.hcl.bankingapp.dto;

public class EmailDto {

	private String emailId;
	private String subject;
	private String textBody;

	public EmailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailDto(String emailId, String subject, String textBody) {
		super();
		this.emailId = emailId;
		this.subject = subject;
		this.textBody = textBody;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}
}
package com.hcl.bankingapp.controller;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.bankingapp.dto.OtpVerifierDTO;
import com.hcl.bankingapp.service.OtpVerification;

@RunWith(MockitoJUnitRunner.class)
public class OtpVerifierControllerTest {

	@Mock
	OtpVerification otpVerifier;

	@InjectMocks
	OtpVerifierController otpVerifierController;

	MockMvc mockMvc;
	
	OtpVerifierDTO otpVerifierDTO;

	@Before
	public void setup() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(otpVerifierController).build();

		otpVerifierDTO = new OtpVerifierDTO();

		otpVerifierDTO.setOtp(123);
		otpVerifierDTO.setUserId(1);
	}

	@Test
	public void testOtpVerifier() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/fundtransfer/payee/authentication").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(otpVerifierDTO))).andExpect(status().isOk());

	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}

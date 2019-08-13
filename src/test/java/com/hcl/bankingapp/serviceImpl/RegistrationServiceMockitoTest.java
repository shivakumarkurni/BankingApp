package com.hcl.bankingapp.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bankingapp.entity.Account;
import com.hcl.bankingapp.entity.UserDetails;
import com.hcl.bankingapp.exception.BankException;
import com.hcl.bankingapp.repository.AccountRepository;
import com.hcl.bankingapp.repository.UserDetailsRepository;
import com.hcl.bankingapp.service.RegistrationService;


@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceMockitoTest {
	
	@Mock
	UserDetailsRepository userdetailsrepository;
	
	@Mock
	AccountRepository accountsrepository;
	
	@InjectMocks
	RegistrationService registrationService;
	
	static List<UserDetails> userdetails = new ArrayList<>();
	
	static List<Account> accounts = new ArrayList<>();
	
	static UserDetails detail = null;
	
	static Account account = null;
	@BeforeClass
	public static void setUp(){
		detail = new UserDetails();
		detail.setUserId(1L);
		detail.setUserName("sravya");
		detail.setPassword("pass");
		detail.setMobile(9000L);
		userdetails.add(detail);
		
		account = new Account();
		account.setAccountId(1L);
		account.setAccountNo(100001L);
		account.setBalance(7000D);
		account.setUserDetails(detail);
		accounts.add(account);
		
		account = new Account();
		account.setAccountId(2L);
		account.setAccountNo(100021L);
		account.setBalance(70000D);
		account.setUserDetails(detail);
		accounts.add(account);
	
	}	
	
	
	@Test
	public void testGetDetails(){
		when(accountsrepository.findAll()).thenReturn(accounts);
		List<Account> acc = registrationService.getAccountDetails();		
		assertNotNull(acc);
		assertEquals(acc.size(), 2);
		
		when(userdetailsrepository.findAll()).thenReturn(userdetails);
		List<UserDetails> user = registrationService.getUsers();		
		assertNotNull(user);
		assertEquals(user.size(), 1);
		
		
	}
	
	@Test(expected = BankException.class)
	public void registerCustomerTest() {
		
		Mockito.when(userdetailsrepository.findByUserName(detail.getUserName())).thenReturn(detail);
		Mockito.when(userdetailsrepository.save(detail)).thenReturn(detail);
		  
		
		long actualvalue = registrationService.registerCustomer(detail);
		
		
		
	}
	
	
	@Test
	public void registerCustomerTestPositive() {
		
		Mockito.when(userdetailsrepository.findByUserName(detail.getUserName())).thenReturn(null);
		Mockito.when(userdetailsrepository.save(detail)).thenReturn(detail);
		  
		
		long actualvalue = registrationService.registerCustomer(detail);
		
		
		Assert.assertEquals(actualvalue, 1000001L);
		
	}
	   
	
	 

}

package com.socialconnect;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.socialconnect.model.UserDetails;
import com.socialconnect.service.UserDetailsService;

public class UserDetailsTestCase {

	UserDetailsService userDetailsService;
	AnnotationConfigApplicationContext context;
	UserDetails userDetails;
	
	@Before
	public void setUp(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.socialconnect");
		context.refresh();
		userDetails = (UserDetails)context.getBean("userDetails");
		userDetailsService=(UserDetailsService)context.getBean("userDetailsService");
	}
	
	@Test
	public void insertOrUpdateUserDetails()
	{
		int result;
		userDetails.setFirstname("Rohit");
		userDetails.setLastname("Gupta");
		userDetails.setEmail("rohitgupta@gmail.com");
		userDetails.setAddress("Address of Rohit Gupta");
		userDetails.setMobile(981234567);
		userDetails.setOnline_status(false);
		userDetails.setRole("ROLE_USER");
		userDetails.setPassword("rohit");
		userDetails.setUsername("rohitgupta");
		
		userDetailsService.insertOrUpdateUserDetails(userDetails);
	}
	
	@After
	public void tearDown(){
		context.close();
	}


}
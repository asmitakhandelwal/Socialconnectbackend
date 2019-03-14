package com.socialconnect.service;
import com.socialconnect.model.UserDetails;

public interface UserDetailsService 
{
	public void insertOrUpdateUserDetails(UserDetails userDetails);
	public UserDetails getUserDetails(String username);
	public UserDetails getUserDetailsByEmail(String email);
	public UserDetails login(UserDetails userDetails);
}
